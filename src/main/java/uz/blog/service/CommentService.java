package uz.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.blog.entity.BlogEntity;
import uz.blog.entity.CommentEntity;
import uz.blog.repository.CommentRepository;
import uz.blog.utils.SecurityUtils;
import uz.blog.validation.CommonSchemaValidation;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;

    private final CommonSchemaValidation validation;

    public List<CommentEntity> getCommentListByBlogId(Integer id) {
        return repository.getCommentByBlogId(id);
    }

    public boolean add(Integer id, CommentEntity comment) {

        BlogEntity blogById = validation.getBlogById(id);
        comment.setBlog(blogById);
        comment.forCreate(SecurityUtils.getUserId());
        repository.save(comment);

        return true;
    }

    public List<CommentEntity> getUnverifiedCommentList(Integer id, Boolean isUnverified) {
       return repository.getUnverifiedComments(id, isUnverified);
    }

    @Transactional
    public void confirmationComment(Integer commentId) {
        validation.existsCommentById(commentId);
        repository.confirmationComment(commentId);
    }

    @Transactional
    public void delete(Integer id) {
        validation.existsCommentById(id);
        repository.deleteById(id);
    }

    @Transactional
    public void usefulIncrement(Integer id) {
        validation.existsCommentById(id);
        repository.usefulIncrement(id);
    }

    @Transactional
    public void notUsefulIncrement(Integer id) {
        validation.existsCommentById(id);
        repository.notUsefulIncrement(id);
    }
}
