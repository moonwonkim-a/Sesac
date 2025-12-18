package com.ohgirafferas.restapi.section02.responseentity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entity")
public class ResponseEntityTestController {

    private List<UserDTO> users;

    public ResponseEntityTestController(){
        users = new ArrayList<>();

        users.add(new UserDTO(1,"user01","pass01","Moon",new Date(),"active"));
        users.add(new UserDTO(2,"user02","pass02","Sun",new Date(),"active"));
        users.add(new UserDTO(3,"user03","pass03","Star",new Date(),"inactive"));
    }

    /* 전체 회원 조회 */
//    @GetMapping("/users")
//    public ResponseEntity<ResponseMessage> findAllUsers(){
//        // 응답 헤더 설정 -> 응답에 대한 부가 정보
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
//        // 응답 바디(본문)
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("users",users);
//        ResponseMessage responseMessage = new ResponseMessage(200,"조회 성공", responseMap);
//
//        // ResponseEntity 객체 생성
//        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
//    }

    /* 쿼리스트링으로 사용자를 검색/필터링 */
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findUserByConditions(@RequestParam(required = false) String name, @RequestParam(required = false) String status){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json",StandardCharsets.UTF_8));

        List<UserDTO> foundUser = users.stream()
                .filter(user -> {
                    if(status != null && !user.getStatus().equals(status)){
                        return false;
                    }
                    if(name != null && !user.getName().contains(name)){
                        return false;
                    }
                    return true;
                }).collect(Collectors.toList());    // 필터링된 결과를 새로운 List로 만든다.

                // 응답 데이터 설정
                Map<String, Object> responseMap = new HashMap<>();
                responseMap.put("users",foundUser);
                ResponseMessage responseMessage = new ResponseMessage(200,"조회 성공", responseMap);

                return new ResponseEntity<>(responseMessage,headers,HttpStatus.OK);
    }

    /* 특정 번호의 회원 조회 */
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo){

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users",foundUser);     // JSON 변환 -> "user" : {...}

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        return ResponseEntity.ok(responseMessage);
    }

    /* 회원 등록 */
    @PostMapping("/users")
    // <T>가 Void라는 것은 응답 body가 없다는 의미
    // @RequestBody : HTTP 클라이언트가 보낸 JSON 데이터를 UserDTO 객체로 반환한다.
    // {"name" : "홍길동", "age" : 30} -> newUser.name = "홍길동", newUser.age = 30 이런식으로 반환됨
    public ResponseEntity<Void> registUser(@RequestBody UserDTO newUser) {

        // users 리스트의 마지막 사용자의 번호를 가져온다. (별로 중요하지 않은 부분)
        int lastUserNo = users.get(users.size() - 1).getNo();
        newUser.setNo(lastUserNo + 1);
        newUser.setEnrollDate(new Date());
        users.add(newUser);

        return ResponseEntity
                .created(URI.create("/entity/users/" + newUser.getNo()))
                .build();   // body가 Void인 응답을 만들 때 사용
    }

    /* 회원 정보 수정 */
    @PutMapping("/users/{userNo}")  // {} : 경로 변수(@PathVariable) 식별
    public ResponseEntity<Void> modifyUser(@PathVariable int userNo, @RequestBody UserDTO modifyInfo){

        // 수정할 회원 정보 조회
        UserDTO foundUser = users.stream()
                .filter(user-> user.getNo() == userNo)
                .findFirst()
                .get();

        // 회원 정보 수정
        foundUser.setId(modifyInfo.getId());
        foundUser.setPwd(modifyInfo.getPwd());
        foundUser.setName(modifyInfo.getName());

        return ResponseEntity
                .created(URI.create("/entity/users/" + userNo))
                .build();
    }

    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<Void> removeUser(@PathVariable int userNo){

        UserDTO foundUser = users.stream()
                .filter(user-> user.getNo() == userNo)
                .findFirst()
                .get();

        users.remove(foundUser);

        return ResponseEntity
                .noContent()    // 성공했지만 컨텐츠 없음을 의미하는 HTTP 상태코드 204 No Content 반환
                .build();
    }

}
