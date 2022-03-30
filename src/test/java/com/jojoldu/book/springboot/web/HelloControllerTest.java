package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.SecurityConfig;
import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // JUnit에 내장된 실행자가 아닌 SpringRunner라는 스프링 실행자를 사용, 스프링부트테스트와 JUnit 사이에 연결자 역할

@WebMvcTest(controllers = HelloController.class, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                classes = SecurityConfig.class)}) // Web(Spring MVC)에 집중할 수 있는 어노테이션이고, @Controller와 @controllerAdvice가 내장됨

public class HelloControllerTest {
    @Autowired //스프링이 관리하는 Bean을 Injection 받음
    private MockMvc mvc; // 스프링 MVC 테스트의 시작점 HTTP GET< POST 등에 대한 API 테스트 가능

    @Test
    @WithMockUser(roles = "USER")
    public void ReturnedHello() throws Exception {
        String hello = "Hello";

        mvc.perform(get("/hello")) //해당 /hello 주ㅇ소로 HTTP GET 요청을 함 .perform
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증하고, HTTP Header의 Status를 검증하고, 200,404,500 상태를 검증함. // 여기선 성공시나리오 밖에 없으니 200을 검증함
                .andExpect(content().string(hello)); // Controller에서 hello를 리턴하기에 이 값이 맞는지 검증함.
        //and Expect가 다 통과되면 Tests passed 출력
    }

    @Test
    @WithMockUser(roles = "USER")
    public void ReturnedHelloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name) //API 테스트할 때 사용될 요청 파라미터를 설정함
                        .param("amount", String.valueOf(amount)))// 단, 값은 String 만 허용되며, 숫자 날짜도 전부 문자열로 변경해서 사용해야함.
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //Json 응답 값을 필드별로 검증할 수 있는 메소드이고 $를 기준으로 필드명을 명시할 수 있음.
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
