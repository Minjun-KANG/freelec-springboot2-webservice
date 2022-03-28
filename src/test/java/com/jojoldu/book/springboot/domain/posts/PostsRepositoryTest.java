package com.jojoldu.book.springboot.domain.posts;

/*
save, findAll 기능을 테스트
 */

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest //H2-DB를 자동으로 실행함
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After// Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정 // 보통 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기위해 사용함.
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void postSaveAndLoad(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() //테이블 posts에 insert/update 쿼리를 실행함. id 값이 있다면 update 그렇지 않다면 insert
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); // 테이블 posts에 있는 모든 데이터를 조회하는 메소드임.

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
