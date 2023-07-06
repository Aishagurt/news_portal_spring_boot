package kz.bitlab.techboot.springsecurityboot.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.techboot.springsecurityboot.model.Category;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import kz.bitlab.techboot.springsecurityboot.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTagsIn(List<Tag> tags);

    List<Post> findByCategory(Category category);
}