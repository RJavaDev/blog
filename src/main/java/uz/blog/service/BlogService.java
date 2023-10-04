package uz.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.blog.entity.BlogEntity;
import uz.blog.repository.BlogRepository;
import uz.blog.utils.SecurityUtils;
import uz.blog.validation.CommonSchemaValidation;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {


    private final BlogRepository repository;

    private final CommonSchemaValidation validation;

    public boolean add(BlogEntity newBlog) {
        Integer userId = SecurityUtils.getUserId();
        newBlog.forCreate(userId);
        repository.save(newBlog);
        return true;
    }

    @Transactional
    public BlogEntity getObject(Integer id) {

        repository.incrementNumberReadings(id);
        return repository.getBlogById(id).orElseThrow(() -> {
            throw new NullPointerException(id + " not found");
        });

    }

    @Transactional
    public boolean delete(Integer id) {
        validation.existsBlogById(id);
        repository.deleteBlogById(id);
        return false;
    }

    public List<BlogEntity> getAllBlog() {
        return repository.getAllBlog();
    }

    @Transactional
    public void checkedBlog(Integer id) {
        validation.existsBlogById(id);
        repository.checkedBlog(id);
    }
}
