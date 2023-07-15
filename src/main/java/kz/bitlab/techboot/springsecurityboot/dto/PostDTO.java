package kz.bitlab.techboot.springsecurityboot.dto;

import kz.bitlab.techboot.springsecurityboot.model.Tag;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String category;
    private List<Tag> tags;
    private List<CommentDTO> comments;
    private String imageUrl;
}