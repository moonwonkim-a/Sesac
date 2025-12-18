package com.ohgirafferas.restapi.section01.response;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController // 이 클래스는 데이터만 주고받는 API를 만드는 클래스임을 나타네는 어노테이션
@RequestMapping("/response")
public class ResponseRestController {

    /* 문자열 응답 */
    @GetMapping("/hello")  // "/response/hello" 주소로 GET 요청이 오면 이 메소드 실행
    public String helloWorld(){
        return "Hello World";
    }

    /* 기본 자료형 응답 */
    @GetMapping("/random")
    public int getRandomNumber(){
        return (int)(Math.random() * 10) + 1;
    }

    /* Object 응답 */
    @GetMapping("/message")
    public Message getMessage(){
        return new Message(200,"메세지를 응답합니다.");
    }

    /* List 응답 */
    @GetMapping("/list")
    public List<String> getList(){
        return List.of(new String[] {"사과","바나나","복숭아"});
    }

    /* Map 응답 */
    @GetMapping("/map")
    public Map<Integer,String> getMap(){
        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(200,"정상 응답"));
        messageList.add(new Message(404,"페이지를 찾을 수 없음"));
        messageList.add(new Message(500,"서버 에러"));
        return messageList.stream().collect(Collectors.toMap(Message::getHttpStatusCode,Message::getMessage));
    }

    /* 파일 응답 */
    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage() throws IOException {
        return getClass().getResourceAsStream("/images/strawberry.jpg").readAllBytes();
    }

    /* ResponseEntity 응답 */
    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity(){
        return ResponseEntity.ok(new Message(123,"hello world"));
    }
}
