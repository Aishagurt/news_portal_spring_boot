package kz.bitlab.techboot.springsecurityboot.dto;

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
    private String authorName;
//    private String categoryName;
    private List<String> tagNames;
    private String imageUrl;
    private boolean published;

}