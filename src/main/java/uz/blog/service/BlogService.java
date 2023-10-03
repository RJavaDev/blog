package uz.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.blog.entity.Blog;
import uz.blog.repository.BlogRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService implements BaseService<Blog,Integer>{


    private final BlogRepository repository;

    @Override
    public Blog add(Integer integer) {
        return null;
    }

    @Override
    public Blog getObject(Integer id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(int id, Integer integer) {
        return false;
    }

    public List<Blog> getAllBlog() {
        return repository.getAllBlog();
    }
}
