package kz.bitlab.techboot.springsecurityboot.api;

import jakarta.transaction.Transactional;
import kz.bitlab.techboot.springsecurityboot.dto.CommentDTO;
import kz.bitlab.techboot.springsecurityboot.dto.PostDTO;
import kz.bitlab.techboot.springsecurityboot.service.CommentService;
import kz.bitlab.techboot.springsecurityboot.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/post")
public class PostController {

    @Autowired
    private final PostService postService;

    @Autowired
    private final CommentService commentService;

    @GetMapping
    public List<PostDTO> getPostList(){ return postService.getPosts(); }

    @GetMapping(value = "/get-post/{id}")
    public PostDTO getPost(@PathVariable(name = "id") Long id){ return postService.getPost(id); }

    @PostMapping(value = "/add-post")
    public PostDTO addPost(@RequestBody PostDTO postDTO){ return postService.addPost(postDTO); }

    @PutMapping(value = "/update-post")
    public PostDTO updatePost(@RequestBody PostDTO postDTO){ return postService.updatePost(postDTO); }

    @DeleteMapping(value = "/delete-post/{id}")
    @Transactional
    public void deletePost(@PathVariable(name = "id") Long id){ postService.deletePost(id); }

    @PostMapping(value = "/{id}/comments")
    public List<CommentDTO> getComments(@PathVariable(name = "id") Long id){ return commentService.getCommentsByPostId(id); }
}
