package kz.bitlab.techboot.springsecurityboot;

import jakarta.transaction.Transactional;
import kz.bitlab.techboot.springsecurityboot.dto.PostDTO;
import kz.bitlab.techboot.springsecurityboot.mapper.PostMapper;
import kz.bitlab.techboot.springsecurityboot.model.Category;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import kz.bitlab.techboot.springsecurityboot.model.Tag;
import kz.bitlab.techboot.springsecurityboot.repository.PostRepository;
import kz.bitlab.techboot.springsecurityboot.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@Transactional
class TestApp {

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private PostService postService;

	@Autowired
	private PostRepository postRepository;

	@Test
	void checkPostDto() {
		Post post = new Post();
		post.setId(777L);
		post.setTitle("News that are interesting");
		post.setContent("Content of news that is very interesting");
		post.setCreatedAt(LocalDateTime.now());

		Category category = new Category();
		category.setId(1L);
		category.setName("Sports");

		post.setCategory(category);

		Set<Tag> tags = new HashSet<>();
		Tag tag = new Tag();
		tag.setId(1L);
		tag.setName("Popular");
		tags.add(tag);

		post.setTags(tags);

		post.setImageUrl("https://example.com/image.jpg");

		PostDTO postDTO = postMapper.toPostDTO(post);

		Assertions.assertEquals(post.getId(), postDTO.getId());
		Assertions.assertEquals(post.getTitle(), postDTO.getTitle());
		Assertions.assertEquals(post.getContent(), postDTO.getContent());
		Assertions.assertEquals(post.getCreatedAt(), postDTO.getCreatedAt());
		Assertions.assertEquals(post.getCategory().getName(), postDTO.getCategory());
		Assertions.assertEquals(post.getTags().size(), postDTO.getTags().size());

		for(Tag tagDto : postDTO.getTags()) {
			for(Tag tagModel : post.getTags()) {
				Assertions.assertEquals(tagDto, tagModel);
			}
		}

		Assertions.assertEquals(post.getImageUrl(), postDTO.getImageUrl());
	}

	@Test
	void checkInsertIntoDb() {

		PostDTO postDTO = new PostDTO();
		postDTO.setId(54L);
		postDTO.setTitle("News that are interesting");
		postDTO.setContent("Content of news that is very interesting");
		postDTO.setCreatedAt(LocalDateTime.now());
		postDTO.setCategory("Sports");
		postDTO.setImageUrl("https://example.com/image.jpg");

		List<Tag> tags = new ArrayList<>();
		tags.add(new Tag("Popular"));
		postDTO.setTags(tags);

		postRepository.save(postMapper.toPost(postDTO));

		Post insertedPost = postRepository.getReferenceById(postDTO.getId());

		Assertions.assertNotNull(insertedPost);
		Assertions.assertEquals(postDTO.getId(), insertedPost.getId());
		Assertions.assertEquals(postDTO.getTitle(), insertedPost.getTitle());
		Assertions.assertEquals(postDTO.getContent(), insertedPost.getContent());
		Assertions.assertEquals(postDTO.getCreatedAt(), insertedPost.getCreatedAt());
		Assertions.assertEquals(postDTO.getCategory(), insertedPost.getCategory().getName());
		Assertions.assertEquals(postDTO.getImageUrl(), insertedPost.getImageUrl());
		Assertions.assertEquals(postDTO.getTags().size(), insertedPost.getTags().size());

		postRepository.delete(postMapper.toPost(postDTO));
	}

}
