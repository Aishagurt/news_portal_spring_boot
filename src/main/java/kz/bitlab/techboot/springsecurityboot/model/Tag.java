package kz.bitlab.techboot.springsecurityboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tags")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends BaseModel{
    @Column(name = "tag_name", nullable = false)
    private String name;
    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts;

    public Tag(String name) {
        this.name = name;
    }
}
