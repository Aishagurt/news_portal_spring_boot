package kz.bitlab.techboot.springsecurityboot.service;

import kz.bitlab.techboot.springsecurityboot.dto.CommentDTO;
import kz.bitlab.techboot.springsecurityboot.dto.PostDTO;
import kz.bitlab.techboot.springsecurityboot.mapper.CommentMapper;
import kz.bitlab.techboot.springsecurityboot.mapper.PostMapper;
import kz.bitlab.techboot.springsecurityboot.model.Category;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import kz.bitlab.techboot.springsecurityboot.model.Tag;
import kz.bitlab.techboot.springsecurityboot.repository.CategoryRepository;
import kz.bitlab.techboot.springsecurityboot.repository.PostRepository;
import kz.bitlab.techboot.springsecurityboot.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final PostMapper postMapper;

    private final TagRepository tagRepository;

    private final CategoryRepository categoryRepository;

    private final CommentService commentService;

    private final CommentMapper commentMapper;

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

            Category category = post.getCategory();
            if (category != null) {
                post.setCategory(null);
                categoryRepository.save(category);
            }

            commentService.deleteCommentsByPost(post);

            post.setTags(null);
            postRepository.save(post);
            postRepository.delete(post);
        }
    }
    public PostDTO updatePost(PostDTO postDTO) {
        Post existingPost = postRepository.findById(postDTO.getId()).orElse(null);
        Post updatedPost = postMapper.toPost(postDTO);
        updatedPost.setTags(mapTagDTOs(postDTO.getTags()));
        updatedPost.setCreatedAt(postDTO.getCreatedAt());

        String categoryName = postDTO.getCategory();
        Category category = categoryRepository.findByName(categoryName);

        updatedPost.setCategory(category);

        List<CommentDTO> comments = commentService.getCommentsByPostId(existingPost.getId());
        updatedPost.setComments(commentMapper.toModelList(comments));

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

    public List<PostDTO> getInitialPostsByCategoryId(Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        List<PostDTO> posts = postMapper.toDtoList(postRepository.findByCategory(category));
        List<PostDTO> initialPosts = new ArrayList<>();
        for(int i = 0; i < POSTS_PER_PAGE && i < posts.size(); i++){
            initialPosts.add(posts.get(i));
        }
        return initialPosts;
    }

    public List<PostDTO> getInitialPosts() {
        List<PostDTO> allPosts = getPosts();
        List<PostDTO> initialPosts = new ArrayList<>();
        for (int i = 0; i < POSTS_PER_PAGE && i < allPosts.size(); i++) {
            initialPosts.add(allPosts.get(i));
        }
        return initialPosts;
    }

    public List<PostDTO> getMorePosts(int page, int postsPerPage, Long catId) {
        List<PostDTO> posts;

        if(catId!= null) {
            Category category = categoryRepository.findById(catId).orElse(null);
            posts = postMapper.toDtoList(postRepository.findByCategory(category));
        }else {
            posts = postMapper.toDtoList(postRepository.findAll());
        }

        int totalPosts = posts.size();
        int startIndex = page * postsPerPage;

        if (startIndex >= totalPosts) {
            return Collections.emptyList();
        }

        int endIndex = Math.min(startIndex + postsPerPage, totalPosts);
        return posts.subList(startIndex, endIndex);
    }
}
