package kz.bitlab.techboot.springsecurityboot.mapper;

import kz.bitlab.techboot.springsecurityboot.dto.TagDTO;;
import kz.bitlab.techboot.springsecurityboot.model.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagDTO toTagDTO(Tag tag);

    Tag toTag(TagDTO tagDTO);

    List<TagDTO> toDtoList(List<Tag> courseList);
    List<Tag> toModelList(List<TagDTO> courseList);
}