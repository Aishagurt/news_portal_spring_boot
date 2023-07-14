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

    @Column(name = "name", nullable = false)
    private String name;
}