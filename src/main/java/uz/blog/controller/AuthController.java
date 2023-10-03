package uz.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.blog.dto.UserRequestDto;
import uz.blog.dto.request.UserLoginDto;
import uz.blog.service.UserService;


@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(
            @ModelAttribute UserRequestDto userRequestDto,
            ModelAndView modelAndView
    ) {
        modelAndView.addObject("user", userService.add(userRequestDto));
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute UserLoginDto userLoginDto) {
        return "login";
    }

}
