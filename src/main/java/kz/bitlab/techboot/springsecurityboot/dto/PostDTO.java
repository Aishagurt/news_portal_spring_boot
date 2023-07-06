package kz.bitlab.techboot.springsecurityboot.dto;

import kz.bitlab.techboot.springsecurityboot.model.Category;
import kz.bitlab.techboot.springsecurityboot.model.Tag;
import kz.bitlab.techboot.springsecurityboot.model.User;
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
    private String authorname;
    private Category category;
    private List<Tag> tags;
    private String imageUrl;
    private boolean published;

}