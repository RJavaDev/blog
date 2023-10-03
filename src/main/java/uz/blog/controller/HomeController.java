package uz.blog.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.blog.entity.UserEntity;
import uz.blog.utils.SecurityUtils;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.setViewName("home");
        return modelAndView;
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/account")
    public ModelAndView get(ModelAndView modelAndView){
        UserEntity user = SecurityUtils.getUser();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("account");
        return modelAndView;
    }
}
