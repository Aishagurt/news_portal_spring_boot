package kz.bitlab.techboot.springsecurityboot.api;

import kz.bitlab.techboot.springsecurityboot.dto.CategoryDTO;
import kz.bitlab.techboot.springsecurityboot.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getCategoryList(){
        return categoryService.getCategories();
    }

    @GetMapping(value = "/get-category/{id}")
    public CategoryDTO getCategory(@PathVariable(name = "id") Long id){ return categoryService.getCategory(id); }


    @PostMapping(value = "/add-category")
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO){ return categoryService.addCategory(categoryDTO);}

    @PutMapping(value = "/update-category")
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO){ return categoryService.updateCategory(categoryDTO); }

    @DeleteMapping(value = "{id}")
    public void deleteTag(@PathVariable(name="id") Long id){ categoryService.deleteCategory(id); }
}