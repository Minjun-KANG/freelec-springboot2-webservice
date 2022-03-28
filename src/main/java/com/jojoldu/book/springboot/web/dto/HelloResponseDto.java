package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드의 get 메소드를 생성한다. 
@RequiredArgsConstructor // 내가 선언한 final 필드가 포함된 private 변수를 파라미터로 갖는 생성자를 생성해준다. final이 없는 필드는 생성자에 포함되지 않는다.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
