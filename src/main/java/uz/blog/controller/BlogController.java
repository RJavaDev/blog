package uz.blog.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.blog.dto.response.BlogResponseDto;
import uz.blog.entity.BlogEntity;
import uz.blog.service.BlogService;
import uz.blog.dto.request.BlogCreatedRequestDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private final BlogService service;

    @GetMapping("")
    public ModelAndView getAllBlog(ModelAndView view) {

        List<BlogEntity> blogEntityList = service.getAllBlog();
        view.addObject("allBlog", blogEntityList);

        return view;
    }

    @PostMapping("/add")
    public ModelAndView addBlog(@ModelAttribute BlogCreatedRequestDto dto, ModelAndView view) {
        boolean add = service.add(dto);
        view.addObject("isSuccess", add);
        view.setViewName("index");
        return view;
    }

    @GetMapping("/get/{id}")
    public ModelAndView getBlogById(@PathVariable Integer id, ModelAndView view) {
        BlogResponseDto blogResponseDto = service.getObject(id);
        view.addObject("blog", blogResponseDto);
        view.setViewName("blog");

        return view;
    }

    @PostMapping("/checked/{id}")
    public ModelAndView checkedBlog(@PathVariable Integer id, ModelAndView view) {

        service.checkedBlog(id);
        view.setViewName("index");
        return view;
    }

    @DeleteMapping("/deleted/{id}")
    public String deleteBlog(@PathVariable Integer id){

        service.delete(id);
        return "redirect:/blog";
    }

}
