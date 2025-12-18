package com.ohgiraffers.jwtsecurity.auth.filter;

import com.ohgiraffers.jwtsecurity.auth.model.DetailsUser;
import com.ohgiraffers.jwtsecurity.common.AuthConstants;
import com.ohgiraffers.jwtsecurity.common.UserRole;
import com.ohgiraffers.jwtsecurity.common.utils.TokenUtils;
import com.ohgiraffers.jwtsecurity.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {


        // 1. 헤더에서 토큰 꺼내기
        String header = request.getHeader(AuthConstants.AUTH_HEADER);

        // [핵심 수정] 토큰이 없거나, Bearer 타입이 아니면? -> 그냥 통과시킨다.
        // 이유: 로그인(/login)이나 회원가입(/signup) 요청은 토큰이 없으므로 여기서 막으면 안 됩니다.
        // 여기서 통과되어도, WebSecurityConfig에서 인증이 필요한 페이지라면 알아서 막아줍니다.
        if (header == null || !header.startsWith(AuthConstants.TOKEN_TYPE)) {
            chain.doFilter(request, response);
            return;
        }

        try {
            // 2. 토큰이 있다면 유효성 검사 시작
            String token = TokenUtils.splitHeader(header);

            if (TokenUtils.isValidToken(token)) {
                Claims claims = TokenUtils.getClaimsFromToken(token);

                // 토큰에 담긴 정보로 인증 객체(User)를 만듦
                User user = new User();
                user.setUserName(claims.get("userName").toString());
                user.setRole(UserRole.valueOf(claims.get("Role").toString()));

                // (참고) 만약 TokenUtils에서 userId도 claims에 넣었다면 여기서 user.setUserId(...) 도 해주면 좋습니다.

                DetailsUser authentication = new DetailsUser(user);

                AbstractAuthenticationToken authenticationToken
                        = UsernamePasswordAuthenticationToken
                        .authenticated(authentication, token, authentication.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetails(request));

                // 시큐리티 컨텍스트에 인증 정보 저장 (이제 이 요청은 "로그인 된 상태"로 취급됨)
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                // 다음 필터로 진행
                chain.doFilter(request, response);
            } else {
                throw new RuntimeException("토큰이 유효하지 않습니다.");
            }
        } catch (Exception e) {
            response.setContentType("application/json");
            PrintWriter printWriter = response.getWriter();
            JSONObject jsonObject = jsonResponseWrapper(e);
            printWriter.print(jsonObject);
            printWriter.flush();
            printWriter.close();
        }
    }

    /**
     * description. 토큰 관련 Exception 발생 시 예외 내용을 담은 객체 반환하는 메소드
     *
     * @param e : Exception
     * @return JSONObject
     */
    private JSONObject jsonResponseWrapper(Exception e) {
        String resultMsg = "";

        if (e instanceof ExpiredJwtException) {
            resultMsg = "Token Expired";
        } else if (e instanceof SignatureException) {
            resultMsg = "Token SignatureException";
        } else if (e instanceof JwtException) {
            resultMsg = "Token Parsing JwtException";
        } else {
            resultMsg = "other Token error";
        }

        HashMap<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("status", 401);
        jsonMap.put("message", resultMsg);
        jsonMap.put("reason", e.getMessage());

        return new JSONObject(jsonMap);
    }
}
