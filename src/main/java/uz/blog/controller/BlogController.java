package uz.blog.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.blog.controller.convert.BlogConvert;
import uz.blog.dto.response.BlogResponseDto;
import uz.blog.entity.BlogEntity;
import uz.blog.service.BlogService;
import uz.blog.dto.request.BlogCreatedRequestDto;

import java.util.List;


@Controller
@RequiredArgsConstructor
@EnableMethodSecurity
@RequestMapping("/blog")
public class BlogController {

    private final BlogService service;

    @GetMapping()
    public String getAllBlog(Model model) {

        List<BlogEntity> blogEntityList = service.getAllBlog();
        List<BlogResponseDto> blogResponseDtoList = BlogConvert.from(blogEntityList);
        model.addAttribute("blogs", blogResponseDtoList);
        return "index";
    }

    @GetMapping("/add")
    public String add() {
        return "add-blog";
    }

//    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping("/add")
    public String addBlog(@ModelAttribute @Validated BlogCreatedRequestDto dto, Model model) {
        BlogEntity blogEntity = BlogConvert.convertToEntity(dto);
        boolean add = service.add(blogEntity);
        model.addAttribute("isSuccess", add);
        return "redirect:/blog";
    }

    @GetMapping("/get/{id}")
    public ModelAndView getBlogById(@PathVariable Integer id, ModelAndView view) {

        BlogEntity blogDB = service.getObject(id);
        BlogResponseDto blogResponseDto = BlogConvert.from(blogDB);
        view.addObject("blog", blogResponseDto);
        view.setViewName("blog-show");

        return view;
    }

    @GetMapping("/checked/{id}")
    public ModelAndView checkedBlog(@PathVariable Integer id, ModelAndView view) {

        service.checkedBlog(id);
        view.setViewName("redirect:/blog/get/"+id);
        return view;
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id){

        service.delete(id);
        return "redirect:/blog";
    }

}
