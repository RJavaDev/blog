package uz.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.blog.dto.request.UserRequestDto;
import uz.blog.dto.request.UserLoginDto;
import uz.blog.service.UserService;


@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

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
        userService.add(userRequestDto);
        modelAndView.addObject("userLogin", true);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute UserLoginDto userLoginDto, Model model) {
        model.addAttribute("userLogin", true);
        return "login";
    }

}
