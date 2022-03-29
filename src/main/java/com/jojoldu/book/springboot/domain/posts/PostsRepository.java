package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
ibatis나 MyBatis 등에서 DAO 라고 불리우는 DB Layer 접근자임. JPA에서는 Repository라고 부르며 인터페이스로 생성함.
JpaRepository<Entity Class, PK Type>을 상속하면 기본 적인 CRUD 메소드가 자동으로 생성됨.

@Repository를 추가할 필요가 없지만 Entity class와 기본 Entity Repository는 같은 패키지 내에 함께 위치해야함.
플젝 규모가 커지는 경우 Eintiy Class와 기본 Repository는 도메인 패키지에서 함께 관리함.
 */
public interface PostsRepository extends JpaRepository<Posts, Long>{

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC ")
    List<Posts> findAllDesc();
}
