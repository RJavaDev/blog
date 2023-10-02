package uz.blog.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public ModelAndView get(ModelAndView modelAndView){
        modelAndView.setViewName("city");
        return modelAndView;
    }
}
