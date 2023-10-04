package uz.blog.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.blog.controller.convert.CommentConvert;
import uz.blog.dto.request.CommentCreatedRequestDto;
import uz.blog.entity.CommentEntity;
import uz.blog.service.CommentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService service;

    @GetMapping("/get-blog-comments/{id}")
    public ModelAndView getCommentList(@PathVariable Integer id, ModelAndView view) {
        List<CommentEntity> commentEntityList = service.getCommentListByBlogId(id);
        view.setViewName("show-comment");
        view.addObject("commentList", commentEntityList);
        view.addObject("blogId", id);
        return view;
    }

    @PostMapping("/add/{id}")
    public String addBlog(@ModelAttribute @Valid CommentCreatedRequestDto dto, Model model, @PathVariable Integer id) {
        CommentEntity commentEntity = CommentConvert.convertToEntity(dto);
        boolean add = service.add(id, commentEntity);
        model.addAttribute("isSuccess", add);
        return "redirect:/comment/get-blog-comments/" + id;
    }

    @GetMapping("/get-unverified/{id}")
    public ModelAndView getUnverifiedCommentList(ModelAndView view,@RequestParam("isUnverified") Boolean isUnverified, @PathVariable Integer id) {
        List<CommentEntity> commentEntityList = service.getUnverifiedCommentList(id, isUnverified);
        view.addObject("commentList", commentEntityList);
        view.addObject("isUnverified", isUnverified);
        view.addObject("blogId", id);
        view.setViewName("show-comment");
        return view;
    }

    @PostMapping("/confirmation/{id}")
    public ModelAndView confirmationComment(@PathVariable Integer id, ModelAndView view) {
        service.confirmationComment(id);
        view.setViewName("comment");
        return view;
    }

    @DeleteMapping("delete/{id}")
    public ModelAndView delete(@PathVariable Integer id, ModelAndView view) {
        service.delete(id);
        view.setViewName("comment");
        return view;
    }
}
