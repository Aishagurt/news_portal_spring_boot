package kz.bitlab.techboot.springsecurityboot.mapper;

import kz.bitlab.techboot.springsecurityboot.dto.CommentDTO;
import kz.bitlab.techboot.springsecurityboot.dto.PostDTO;
import kz.bitlab.techboot.springsecurityboot.dto.TagDTO;
import kz.bitlab.techboot.springsecurityboot.model.Comment;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import kz.bitlab.techboot.springsecurityboot.model.Tag;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = TagMapper.class)
public interface PostMapper {

    @Mapping(source = "category.name", target = "category")
    @Mapping(source = "comments", target = "comments", qualifiedByName = "mapCommentsToCommentDTOs")
    PostDTO toPostDTO(Post post);

    @InheritInverseConfiguration
    @Mapping(source = "category", target = "category.name")
    @Mapping(source = "comments", target = "comments", qualifiedByName = "mapCommentDTOsToComments")
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

    @Named("mapCommentsToCommentDTOs")
    default List<CommentDTO> mapCommentsToCommentDTOs(List<Comment> comments) {
        List<CommentDTO> commentDTOs = new ArrayList<>();
        if (comments != null) {
            for (Comment comment : comments) {
                CommentDTO commentDTO = new CommentDTO();
                commentDTO.setContent(comment.getContent());
                commentDTO.setCommentedAt(comment.getCommentedAt());
                commentDTO.setFullName(comment.getFullName());
                commentDTOs.add(commentDTO);
            }
        }
        return commentDTOs;
    }

    @Named("mapCommentDTOsToComments")
    default List<Comment> mapCommentDTOsToComments(List<CommentDTO> commentDTOs) {
        List<Comment> comments = new ArrayList<>();
        if (commentDTOs != null) {
            for (CommentDTO commentDTO : commentDTOs) {
                Comment comment = new Comment();
                comment.setContent(commentDTO.getContent());
                comment.setCommentedAt(commentDTO.getCommentedAt());
                comment.setFullName(commentDTO.getFullName());
                comments.add(comment);
            }
        }
        return comments;
    }

}
