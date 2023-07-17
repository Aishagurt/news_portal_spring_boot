package kz.bitlab.techboot.springsecurityboot.service;

import kz.bitlab.techboot.springsecurityboot.dto.CommentDTO;
import kz.bitlab.techboot.springsecurityboot.mapper.CommentMapper;
import kz.bitlab.techboot.springsecurityboot.mapper.PostMapper;
import kz.bitlab.techboot.springsecurityboot.model.Comment;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import kz.bitlab.techboot.springsecurityboot.repository.CommentRepository;
import kz.bitlab.techboot.springsecurityboot.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final CommentRepository commentRepository;

    @Autowired
    private final CommentMapper commentMapper;

    public void deleteCommentsByPost(Post post) {
        commentRepository.deleteByPost(post);
    }

    public List<CommentDTO> getCommentsByPostId(Long postId) {
        return commentMapper.toDtoList(commentRepository.findByPostId(postId));
    }

    public CommentDTO addComment(Long postId, CommentDTO commentDTO){
        Post post = postRepository.findById(postId).orElse(null);
        if(post != null) {
            Comment comment = commentMapper.toComment(commentDTO);
            comment.setPost(post);
            post.getComments().add(comment);
            postRepository.save(post);
            return commentMapper.toCommentDTO(comment);
        } else return null;
    }

    public void deleteComment(Long postId, Long commentId){
        Post post = postRepository.findById(postId).orElse(null);
        if(post != null) {
            Comment comment = commentRepository.findById(commentId).orElse(null);

            post.getComments().remove(comment);
            postRepository.save(post);

            if(comment != null)
                commentRepository.delete(comment);
        }
    }
}
