package kz.bitlab.techboot.springsecurityboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends BaseModel{

    @Column(name = "category_name", nullable = false)
    private String name;

}