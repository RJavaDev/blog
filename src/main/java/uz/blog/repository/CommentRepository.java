package uz.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.blog.entity.CommentEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    @Query(value = "SELECT blogc.* FROM blog_comment blogc INNER JOIN blog b ON blogc.blog_id = b.id WHERE b.id=:blogId", nativeQuery = true)
    List<CommentEntity> getCommentByBlogId(@Param("blogId") Integer blogId);

    @Query(value = "SELECT blogc.* FROM blog_comment blogc " +
            "INNER JOIN blog ON blogc.blog_id = blog.id " +
            "WHERE blog.id = :blogId " +
            "AND (:isUnverified IS NULL OR blogc.checked = :isUnverified)",nativeQuery = true)
    List<CommentEntity> getUnverifiedComments(@Param("blogId") Integer blogId, @Param("isUnverified") Boolean isUnverified);

    @Modifying
    @Query(value = "UPDATE blog_comment SET checked = true WHERE id = :commentId AND status <> 'DELETED'", nativeQuery = true)
    void confirmationComment(@Param("commentId") Integer commentId);
}
