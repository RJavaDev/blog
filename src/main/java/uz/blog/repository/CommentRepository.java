package uz.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.blog.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> getCommentByBlogId(Integer id);

    List<Comment> getUnverifiedComments();

    void confirmationComment();
}
