package uz.blog.service.Base;

import uz.blog.entity.CommentEntity;

import java.util.List;

public interface CommentService extends CrudService<CommentEntity>{

    List<CommentEntity> getCommentListByBlogId(Integer id);

    boolean addCommentByBlogId(Integer id, CommentEntity comment);

    List<CommentEntity> getUnverifiedCommentList(Integer id, Boolean isUnverified);

    void confirmationComment(Integer commentId);

    void usefulIncrement(Integer id);

    void notUsefulIncrement(Integer id);
}
