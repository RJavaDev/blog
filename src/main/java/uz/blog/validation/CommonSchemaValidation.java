package uz.blog.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.blog.entity.BlogEntity;
import uz.blog.repository.BlogRepository;
import uz.blog.repository.CommentRepository;
import uz.blog.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class CommonSchemaValidation {

    private final BlogRepository blogRepository;

    private final UserRepository userRepository;

    private final CommentRepository commentRepository;

    public void existsBlogById(Integer id) {

       getBlogById(id);

    }

    public BlogEntity getBlogById(Integer id) {

       return blogRepository.getBlogById(id).orElseThrow(() -> {
            throw new NullPointerException(id + " not found");
        });

    }

    public void existsCommentById(Integer id){
        commentRepository.findById(id).orElseThrow(()->{
            throw new NullPointerException();
        });
    }






}
