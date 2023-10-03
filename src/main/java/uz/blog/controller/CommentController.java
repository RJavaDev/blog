package uz.blog.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
        view.setViewName("coment-blog");
        view.addObject("commentList", commentEntityList);
        return view;
    }

    @PostMapping("/add-comment/{id}")
    public ModelAndView addBlog(@ModelAttribute @Valid CommentCreatedRequestDto dto, ModelAndView view, @PathVariable Integer id) {
        CommentEntity commentEntity = CommentConvert.convertToEntity(dto);
        boolean add = service.add(id, commentEntity);
        view.addObject("isSuccess", add);
        view.setViewName("index");
        return view;
    }

    @GetMapping("/get-unverified")
    public ModelAndView getUnverifiedCommentList(ModelAndView view) {
        List<CommentEntity> commentEntityList = service.getUnverifiedCommentList();
        view.addObject("commentList", commentEntityList);
        view.setViewName("comment");
        return view;
    }

    @PostMapping("/confirmation/{id}")
    public ModelAndView confirmationComment(@PathVariable Integer id, ModelAndView view){
        service.confirmationComment(id);
        view.setViewName("comment");
        return view;
    }

    @DeleteMapping("delete/{id}")
    public ModelAndView delete(@PathVariable Integer id, ModelAndView view){
        service.delete(id);
        view.setViewName("comment");
        return view;
    }
}
