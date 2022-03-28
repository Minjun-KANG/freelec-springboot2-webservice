package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_function_test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // assertthat은 aseert object에 있는 junit의 메소드로 사용자의 값에 대한 체크를 지원한다. 단 여기서는 asserj의 assertThat을 사용한 것.
        //assertThat("123",is("123")); // 이렇게 기본형으로 쓰일 수 있음
        assertThat(dto.getAmount()).isEqualTo(amount); //isEqualTo의 경우 aseertj의 동등 비교 메소드로, assertThat에 있는 값과 isEqualTo의 갑승ㄹ 비교해서 같을 때만 성공임.
    }
}
