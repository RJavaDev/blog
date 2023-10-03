package uz.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.blog.dto.request.BlogCreatedRequestDto;
import uz.blog.dto.response.BlogResponseDto;
import uz.blog.entity.BlogEntity;
import uz.blog.repository.BlogRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService{


    private final BlogRepository repository;

    public boolean add(BlogCreatedRequestDto integer) {
        return false;
    }

    public BlogResponseDto getObject(Integer id) {
        return null;
    }

    public boolean delete(int id) {
        return false;
    }

    public boolean update(int id, BlogEntity blogEntity) {
        return false;
    }

    public List<BlogEntity> getAllBlog() {
        return repository.getAllBlog();
    }

    public void checkedBlog(Integer id) {

    }
}
