package kz.bitlab.techboot.springsecurityboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends BaseModel{

    @Column(name = "name", nullable = false)
    private String name;
}