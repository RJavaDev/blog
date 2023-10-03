package uz.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.blog.dto.request.CommentCreatedRequestDto;
import uz.blog.entity.Comment;
import uz.blog.service.CommentService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService service;

    @GetMapping("/get-blog-comments/{id}")
    public ModelAndView getCommentList(@PathVariable Integer id, ModelAndView view) {
        List<Comment> commentList = service.getCommentListByBlogId(id);
        view.setViewName("coment-blog");
        view.addObject("commentList", commentList);
        return view;
    }

    @PostMapping("/add-comment/{id}")
    public ModelAndView addBlog(@ModelAttribute CommentCreatedRequestDto dto, ModelAndView view, @PathVariable Integer id) {
        boolean add = service.add(id, dto);
        view.addObject("isSuccess", add);
        view.setViewName("index");
        return view;
    }

    @GetMapping("/get-unverified")
    public ModelAndView getUnverifiedCommentList(ModelAndView view) {
        List<Comment> commentList = service.getUnverifiedCommentList();
        view.addObject("commentList", commentList);
        view.setViewName("comment");
        return view;
    }

    @PostMapping("/confirmation/{id}")
    public ModelAndView confirmationComment(@PathVariable Integer id, ModelAndView view){
        service.confirmationComment();
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
