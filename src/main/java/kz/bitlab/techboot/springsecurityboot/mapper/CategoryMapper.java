package kz.bitlab.techboot.springsecurityboot.mapper;

import kz.bitlab.techboot.springsecurityboot.dto.CategoryDTO;
import kz.bitlab.techboot.springsecurityboot.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryDTO toCategoryDTO(Category category);

    Category toCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> toDtoList(List<Category> courseList);
    List<Category> toModelList(List<CategoryDTO> courseList);
}
