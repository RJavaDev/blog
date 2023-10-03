package uz.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.blog.dto.request.CommentCreatedRequestDto;
import uz.blog.entity.Comment;
import uz.blog.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;

    public List<Comment> getCommentListByBlogId(Integer id) {
        return repository.getCommentByBlogId(id);
    }

    public boolean add(Integer id, CommentCreatedRequestDto dto) {
        return false;
    }

    public List<Comment> getUnverifiedCommentList() {
       return repository.getUnverifiedComments();
    }

    public void confirmationComment() {
        repository.confirmationComment();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
