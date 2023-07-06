package kz.bitlab.techboot.springsecurityboot.service;

import kz.bitlab.techboot.springsecurityboot.dto.CategoryDTO;
import kz.bitlab.techboot.springsecurityboot.mapper.CategoryMapper;
import kz.bitlab.techboot.springsecurityboot.model.Category;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import kz.bitlab.techboot.springsecurityboot.repository.CategoryRepository;
import kz.bitlab.techboot.springsecurityboot.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final PostRepository postRepository;

    public List<CategoryDTO> getCategories(){
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO){
        return categoryMapper.toCategoryDTO(categoryRepository.save(categoryMapper.toCategory(categoryDTO)));
    }

    public CategoryDTO getCategory(Long id){
        return categoryMapper.toCategoryDTO(categoryRepository.findById(id).orElse(new Category()));
    }

    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            List<Post> posts = new ArrayList<>();

            List<Post> affectedPosts = postRepository.findByCategory(category);
            for (Post post : affectedPosts) {
                post.removeCategory(category);
                postRepository.save(post);
            }
            categoryRepository.deleteById(id);
        }
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO){ return categoryMapper.toCategoryDTO(categoryRepository.save(categoryMapper.toCategory(categoryDTO))); }

}
