package kz.bitlab.techboot.springsecurityboot.api;

import kz.bitlab.techboot.springsecurityboot.dto.CommentDTO;
import kz.bitlab.techboot.springsecurityboot.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{postId}")
    public List<CommentDTO> getComments(@PathVariable Long postId) {
        return commentService.getCommentsByPostId(postId);
    }
    @PostMapping("/add-comment/{id}")
    public CommentDTO addComment(@PathVariable(name = "id") Long id, @RequestBody CommentDTO commentDTO){
        return commentService.addComment(id, commentDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable(name = "id") Long id, @RequestParam("commentId") Long commentId) {
        commentService.deleteComment(id, commentId);
    }
}