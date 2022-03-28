package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
Entity Class에는 절대로 Setter를 선언하지 않음.대신 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야함,
예를 들어 주문 취소 메소드를 만든다면  order.setStatus(false);를 하지 아니하고, order.cancleOrder();로 새로운 메소드를 구성하는 게 좋음.
그럼 어케 DB에 값을 넣음?
--> 기본적인 골자는 생성자를 통해 최종값을 채운 후 DB에 삽입하는 것이며 값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하는 것을 전제로함.
이 책에서는 생성자 대신 @Builder 를 통해 값을 넣는데, 왜냐면 생성자는 파라미터의 위치가 변경되면 햇갈려버림.
하지만 빌더를 사용하면 어느 필드에 어떤 값을 채워야하는지 알 수 있고, 보다 atomic 하게 관리할 수 있음.

 */
@Getter
@NoArgsConstructor // 아무것도 없는 통짜 생성자를 생성하는 롬복임
@Entity // JPA의 어노테이션 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭함. SalesManager -> sales_manager table
public class Posts { //DB Table과 매칭될 클래스 보통 Entity Class라고 함.

    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue //PK의 생성 규칙을 나타냄, 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 Auto-Increment가 됨.
    private Long id; //웬만하면 Long 타입으로 하셈. 필자는 Long 추천함.

    @Column(length = 500, nullable = false) // 해당 클래스의 필드는 굳이 선언안해도 모두 테이블의 칼럼이 됨.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //그래도 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 잇으면 사용함. VARCHAR(255)가 기본 값임
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
