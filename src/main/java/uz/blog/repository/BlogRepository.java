package uz.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.blog.entity.BlogEntity;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {

    @Query(value = "SELECT b.* FROM blog b WHERE b.status <> 'DELETED'", nativeQuery = true)
    List<BlogEntity> getAllBlog();
}
