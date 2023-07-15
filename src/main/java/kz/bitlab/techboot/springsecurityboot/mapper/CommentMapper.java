package kz.bitlab.techboot.springsecurityboot.mapper;

import kz.bitlab.techboot.springsecurityboot.dto.CommentDTO;
import kz.bitlab.techboot.springsecurityboot.model.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDTO toCommentDTO(Comment comment);
    Comment toComment(CommentDTO commentDTO);

    List<CommentDTO> toDtoList(List<Comment> comments);
    List<Comment> toModelList(List<CommentDTO> commentDTOS);
}