package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스가 BaseTimeEntity를 상속할 경우 내부 필드(생성시간, 수정시간)등을 칼럼으로 인식하게함
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 클래스에 Auditing 기능을 포함시킴 Auditing은 자동으로 시간 넣어주는 기능임
public abstract class BaseTimeEntity {

    @CreatedDate //Entity 가 생성될 때 시간이 자동저장됨.
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity 의 값을 변경할 때 시간이 자동 저장됨.
    private LocalDateTime modifiedData;

}
