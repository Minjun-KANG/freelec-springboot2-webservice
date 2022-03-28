package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON을 반환하는 컨트롤러로 만들어줌 메소드마다 Response body 안써도됨.
public class HelloController {
    @GetMapping("/hello") // Get 요청을 받을 수 있음
    public String hello() {
        return "Hello";
    }

    @GetMapping("/hello/dto") // Get 요청을 받을 수 있음
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        //RequestParam은, 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션임.
        //외부에서 anme이란 이름으로 넘긴 파라미터를 메소드의 인자 name에 저장함.
        return new HelloResponseDto(name, amount);
    }
}
