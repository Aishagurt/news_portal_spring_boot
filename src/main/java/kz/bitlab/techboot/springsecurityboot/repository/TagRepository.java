package kz.bitlab.techboot.springsecurityboot.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.techboot.springsecurityboot.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String name);
}