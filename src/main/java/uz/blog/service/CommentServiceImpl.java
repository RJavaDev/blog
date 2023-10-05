package uz.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.blog.entity.BlogEntity;
import uz.blog.entity.CommentEntity;
import uz.blog.repository.CommentRepository;
import uz.blog.service.Base.CommentService;
import uz.blog.utils.SecurityUtils;
import uz.blog.validation.CommonSchemaValidation;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    private final CommonSchemaValidation validation;

    @Override
    public List<CommentEntity> getCommentListByBlogId(Integer id) {
        return repository.getCommentByBlogId(id);
    }

    public boolean addCommentByBlogId(Integer id, CommentEntity comment) {

        BlogEntity blogById = validation.getBlogById(id);
        comment.setBlog(blogById);
        comment.forCreate(SecurityUtils.getUserId());
        repository.save(comment);

        return true;
    }

    @Override
    public List<CommentEntity> getUnverifiedCommentList(Integer id, Boolean isUnverified) {
       return repository.getUnverifiedComments(id, isUnverified);
    }

    @Override
    @Transactional
    public void confirmationComment(Integer commentId) {
        validation.existsCommentById(commentId);
        repository.confirmationComment(commentId);
    }

    @Override
    public boolean add(CommentEntity entity) {
        return false;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        validation.existsCommentById(id);
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void usefulIncrement(Integer id) {
        validation.existsCommentById(id);
        repository.usefulIncrement(id);
    }

    @Override
    @Transactional
    public void notUsefulIncrement(Integer id) {
        validation.existsCommentById(id);
        repository.notUsefulIncrement(id);
    }
}
