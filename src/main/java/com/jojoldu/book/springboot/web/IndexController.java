package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
gradle에 추가한 의존성 때문에 컨트롤러에서 문자열을 반환할 때 앞의 경로
src/main/resource/templates와 뒷 파일 확장자는 .mustache 자동으로 붙고
여기서는 index를 반환하므로, src/main/resource/templates/index.mustache 로 전환되어 View Resolver가 처리함.
View 리졸버는 URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자 격으로 볼 수 있음.
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
