package kz.bitlab.techboot.springsecurityboot.mapper;

import kz.bitlab.techboot.springsecurityboot.dto.PostDTO;
import kz.bitlab.techboot.springsecurityboot.dto.TagDTO;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import kz.bitlab.techboot.springsecurityboot.model.Tag;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = TagMapper.class)
public interface PostMapper {
    PostDTO toPostDTO(Post post);

    @InheritInverseConfiguration
    Post toPost(PostDTO postDTO);

    List<PostDTO> toDtoList(List<Post> courseList);
    List<Post> toModelList(List<PostDTO> courseList);

    default List<TagDTO> mapTags(Set<Tag> tags) {
        List<TagDTO> tagDTOs = new ArrayList<>();
        for (Tag tag : tags) {
            tagDTOs.add(new TagDTO(tag.getId(), tag.getName()));
        }
        return tagDTOs;
    }

    default Set<Tag> mapTagDTOs(List<TagDTO> tagDTOs) {
        Set<Tag> tags = new HashSet<>();
        for (TagDTO tagDTO : tagDTOs) {
            tags.add(new Tag(tagDTO.getName()));
        }
        return tags;
    }
}
