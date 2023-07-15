package kz.bitlab.techboot.springsecurityboot.repository;

import kz.bitlab.techboot.springsecurityboot.model.Comment;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteByPost(Post post);
    List<Comment> findByPostId(Long postId);
}
