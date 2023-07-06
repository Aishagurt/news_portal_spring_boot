package kz.bitlab.techboot.springsecurityboot.service;

import kz.bitlab.techboot.springsecurityboot.dto.TagDTO;
import kz.bitlab.techboot.springsecurityboot.mapper.TagMapper;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import kz.bitlab.techboot.springsecurityboot.model.Tag;
import kz.bitlab.techboot.springsecurityboot.repository.PostRepository;
import kz.bitlab.techboot.springsecurityboot.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;
    private final PostRepository postRepository;

    public List<TagDTO> getTags(){
        return tagMapper.toDtoList(tagRepository.findAll());
    }

    public TagDTO addTag(TagDTO tagDTO){
        return tagMapper.toTagDTO(tagRepository.save(tagMapper.toTag(tagDTO)));
    }

    public TagDTO getTag(Long id){
        return tagMapper.toTagDTO(tagRepository.findById(id).orElse(new Tag()));
    }

    public void deleteTag(Long id) {
        Tag tag = tagRepository.findById(id).orElse(null);
        if (tag != null) {
            List<Tag> tags = new ArrayList<>();
            tags.add(tag);

            List<Post> affectedPosts = postRepository.findByTagsIn(tags);
            for (Post post : affectedPosts) {
                post.removeTag(tag);
                postRepository.save(post);
            }
            tagRepository.deleteById(id);
        }
    }

    public TagDTO updateTag(TagDTO tagDTO){ return tagMapper.toTagDTO(tagRepository.save(tagMapper.toTag(tagDTO))); }

}
