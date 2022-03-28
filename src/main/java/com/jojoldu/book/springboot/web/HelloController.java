package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON을 반환하는 컨트롤러로 만들어줌 메소드마다 Response body 안써도됨.
public class HelloController {
    @GetMapping("/hello") // Get 요청을 받을 수 있음
    public String hello() {
        return "Hello";
    }
}
