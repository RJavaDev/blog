package uz.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.blog.entity.BlogEntity;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {

    @Query(value = "SELECT b.* FROM blog b WHERE b.status <> 'DELETED'", nativeQuery = true)
    List<BlogEntity> getAllBlog();

    @Query(value = "SELECT b.* FROM blog b WHERE b.id =:blogId AND b.status <> 'DELETED'", nativeQuery = true)
    Optional<BlogEntity> getBlogById(@Param("blogId")Integer blogId);

    @Modifying
    @Query(value = "UPDATE blog SET checked = true WHERE id = :blogId AND status <> 'DELETED'", nativeQuery = true)
    void checkedBlog(@Param("blogId") Integer blogId);

    @Modifying
    @Query(value = "UPDATE blog SET status = 'DELETED' WHERE id = :blogId AND status <> 'DELETED'", nativeQuery = true)
    void deleteBlogById(@Param("blogId") Integer blogId);

    @Modifying
    @Query(value = "UPDATE blog SET number_of_readings = number_of_readings+1 WHERE id = :blogId AND status <> 'DELETED'", nativeQuery = true)
    void incrementNumberReadings(@Param("blogId") Integer blogId);
}
