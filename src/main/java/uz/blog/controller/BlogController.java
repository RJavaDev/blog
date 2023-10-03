package uz.blog.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.blog.entity.Blog;
import uz.blog.service.BlogService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    @GetMapping("")
    public ModelAndView getAllBlog(ModelAndView view){

        List<Blog> blogList = blogService.getAllBlog();
        view.addObject("allBlog", blogList);

        return view;
    }


}
