package kz.bitlab.techboot.springsecurityboot.api;

import kz.bitlab.techboot.springsecurityboot.dto.PostDTO;
import kz.bitlab.techboot.springsecurityboot.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/post")
public class PostController {
    @Autowired
    private final PostService postService;

    @GetMapping
    public List<PostDTO> getPostList(){ return postService.getPosts(); }

    @GetMapping(value = "/get-post/{id}")
    public PostDTO getPost(@PathVariable(name = "id") Long id){ return postService.getPost(id); }

    @PostMapping(value = "/add-post")
    public PostDTO addPost(@RequestBody PostDTO postDTO){ return postService.addPost(postDTO); }

    @PutMapping(value = "/update-post")
    public PostDTO updatePost(@RequestBody PostDTO postDTO){ return postService.updatePost(postDTO); }

    @DeleteMapping(value = "/delete-post/{id}")
    public void deletePost(@PathVariable(name = "id") Long id){ postService.deletePost(id); }


}
