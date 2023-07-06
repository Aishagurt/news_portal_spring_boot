package kz.bitlab.techboot.springsecurityboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends BaseModel{

    @Column(name = "category_name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Post> posts;

    public void removePost(Post post){
        if(post != null){
            posts.remove(post);
        }
    }
}