package kz.bitlab.techboot.springsecurityboot.service;

import kz.bitlab.techboot.springsecurityboot.dto.PostDTO;
import kz.bitlab.techboot.springsecurityboot.mapper.PostMapper;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import kz.bitlab.techboot.springsecurityboot.model.Tag;
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

    public List<PostDTO> getPosts() { return postMapper.toDtoList(postRepository.findAll()); }
    public PostDTO addPost(PostDTO postDTO) {
        Post post = postMapper.toPost(postDTO);
        Set<Tag> tags = mapTagDTOs(postDTO.getTagNames());
        post.setTags(tags);
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
        updatedPost.setTags(mapTagDTOs(postDTO.getTagNames()));
        updatedPost.setCreatedAt(existingPost.getCreatedAt());

        Post savedPost = postRepository.save(updatedPost);
        return postMapper.toPostDTO(savedPost);
    }
    private Set<Tag> mapTagDTOs(List<String> tagDTOs) {
        Set<Tag> tags = new HashSet<>();
        for (String tagDTO : tagDTOs) {
            Tag tag = tagRepository.findByName(tagDTO);
            if (tag == null) {
                tag = new Tag(tagDTO);
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

}
