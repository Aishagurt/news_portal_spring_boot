package kz.bitlab.techboot.springsecurityboot.service;

import kz.bitlab.techboot.springsecurityboot.dto.PostDTO;
import kz.bitlab.techboot.springsecurityboot.mapper.CategoryMapper;
import kz.bitlab.techboot.springsecurityboot.mapper.PostMapper;
import kz.bitlab.techboot.springsecurityboot.model.Category;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import kz.bitlab.techboot.springsecurityboot.model.Tag;
import kz.bitlab.techboot.springsecurityboot.repository.CategoryRepository;
import kz.bitlab.techboot.springsecurityboot.repository.PostRepository;
import kz.bitlab.techboot.springsecurityboot.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final TagRepository tagRepository;
    private final CategoryRepository categoryRepository;
    private final int POSTS_PER_PAGE = 7;

    public List<PostDTO> getPosts() { return postMapper.toDtoList(postRepository.findAll()); }
    public PostDTO addPost(PostDTO postDTO) {
        Post post = postMapper.toPost(postDTO);
        Set<Tag> tags = mapTagDTOs(postDTO.getTags());
        post.setTags(tags);

        String categoryName = postDTO.getCategory();
        Category category = categoryRepository.findByName(categoryName);

        if (category == null) {
            category = new Category();
            category.setName(categoryName);
            category = categoryRepository.save(category);
        }

        post.setCategory(category);

        Post savedPost = postRepository.save(post);
        return postMapper.toPostDTO(savedPost);
    }

    public PostDTO getPost(Long id) { return postMapper.toPostDTO(postRepository.findById(id).orElse(new Post())); }

    public void deletePost(Long id){
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            Set<Tag> tags = post.getTags();
            for (Tag tag : tags) {
                tag.getPosts().remove(post);
            }

            post.setTags(null);
            postRepository.save(post);
            postRepository.delete(post);
        }
    }
    public PostDTO updatePost(PostDTO postDTO) {
        Post existingPost = postRepository.findById(postDTO.getId()).orElse(null);
        Post updatedPost = postMapper.toPost(postDTO);
        updatedPost.setTags(mapTagDTOs(postDTO.getTags()));
        updatedPost.setCreatedAt(existingPost.getCreatedAt());

        String categoryName = postDTO.getCategory();
        Category category = categoryRepository.findByName(categoryName);

        updatedPost.setCategory(category);

        Post savedPost = postRepository.save(updatedPost);
        return postMapper.toPostDTO(savedPost);
    }
    private Set<Tag> mapTagDTOs(List<Tag> tagDTOs) {
        Set<Tag> tags = new HashSet<>();
        for (Tag tagDTO : tagDTOs) {
            Tag tag = tagRepository.findByName(tagDTO.getName());
            if (tag == null) {
                tag = new Tag(tagDTO.getName());
                tagRepository.save(tag);
            }
            tags.add(tag);
        }
        return tags;
    }

    public List<PostDTO> getPosts(int startIndex, int limit) {
        List<PostDTO> allPosts = postMapper.toDtoList(postRepository.findAll());
        int endIndex = Math.min(startIndex + limit, allPosts.size());

        return allPosts.subList(startIndex, endIndex);
    }

    public List<PostDTO> getPostsByCategoryId(Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        List<Post> posts = postRepository.findByCategory(category);
        return postMapper.toDtoList(posts);
    }

    public List<PostDTO> getInitialPosts() {
        List<PostDTO> allPosts = getPosts();
        List<PostDTO> initialPosts = new ArrayList<>();
        for (int i = 0; i < POSTS_PER_PAGE && i < allPosts.size(); i++) {
            initialPosts.add(allPosts.get(i));
        }
        return initialPosts;
    }

    public List<PostDTO> getMorePosts(int page, int postsPerPage) {
        List<PostDTO> allPosts = getPosts();
        int totalPosts = allPosts.size();
        int startIndex = page * postsPerPage;
        int endIndex = Math.min(startIndex + postsPerPage, totalPosts);
        return allPosts.subList(startIndex, endIndex);
    }
}
