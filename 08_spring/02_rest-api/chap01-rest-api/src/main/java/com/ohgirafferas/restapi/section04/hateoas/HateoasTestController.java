package com.ohgirafferas.restapi.section04.hateoas;
import com.ohgirafferas.restapi.section02.responseentity.ResponseMessage;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/hateoas")
public class HateoasTestController {

    private List<UserDTO> users;

    public HateoasTestController(){
        users = new ArrayList<>();

        users.add(new UserDTO(1,"user01","pass01","Moon",new Date()));
        users.add(new UserDTO(2,"user02","pass02","Sun",new Date()));
        users.add(new UserDTO(3,"user03","pass03","Star",new Date()));
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers(){
        // 응답 헤더 설정 -> 응답에 대한 부가 정보
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));

        /* HATEOAS 적용 */
        // 1. EntityModel : 기존 DTO를 감싸서 링크 정보를 추가할 수 있게 해주는 클래스
        List<EntityModel<UserDTO>> usersWithRel = users.stream()
                .map(user -> {
                    return EntityModel.of(
                            user, // 실제 데이터
                            // HateoasTestController의 findUserByNo(user.getNo()) 메소드를 가리키는 리크를 만든다.
                            linkTo(methodOn(HateoasTestController.class).findUserByNo(user.getNo())).withSelfRel(), // withSelfRel() : 자기자신
                            linkTo(methodOn(HateoasTestController.class).findAllUsers()).withRel("users")
                    );
                }).toList();

        // 응답 바디(본문)
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users",usersWithRel);  // 링크가 포함된 리스트로 교체
        ResponseMessage responseMessage = new ResponseMessage(200,"조회 성공", responseMap);

        // ResponseEntity 객체 생성
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo){
        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users",foundUser);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        return ResponseEntity.ok(responseMessage);
    }



}
