package kz.bitlab.techboot.springsecurityboot.api;

import kz.bitlab.techboot.springsecurityboot.dto.TagDTO;
import kz.bitlab.techboot.springsecurityboot.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/tag")
public class TagController {

    private final TagService tagService;

    @GetMapping
    public List<TagDTO> getTagList(){
        return tagService.getTags();
    }

    @GetMapping(value = "/get-tag/{id}")
    public TagDTO getTag(@PathVariable(name = "id") Long id){ return tagService.getTag(id); }


    @PostMapping(value = "/add-tag")
    public TagDTO addTag(@RequestBody TagDTO tagDTO){
        return tagService.addTag(tagDTO);
    }

    @PutMapping(value = "/update-tag")
    public TagDTO updateTag(@RequestBody TagDTO tagDTO){ return tagService.updateTag(tagDTO); }

    @DeleteMapping(value = "{id}")
    public void deleteTag(@PathVariable(name="id") Long id){ tagService.deleteTag(id); }
}