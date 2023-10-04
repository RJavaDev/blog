package uz.blog.service;

import org.junit.jupiter.api.Test;
import uz.blog.entity.BlogEntity;
import uz.blog.repository.BlogRepository;
import uz.blog.utils.SecurityUtils;
import uz.blog.validation.CommonSchemaValidation;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BlogServiceTest {

    @Test
    void add() {

        BlogRepository repository = mock(BlogRepository.class);
        CommonSchemaValidation validation = mock(CommonSchemaValidation.class);

        BlogService blogService = new BlogService(repository,validation);

        BlogEntity newBlog = new BlogEntity();
        newBlog.setTitle("Sample Title");
        newBlog.setTopic("Sample Topic");
        newBlog.setText("Sample Text");

        boolean result = blogService.add(newBlog);

        verify(repository).save(newBlog);
        assertTrue(result);
    }


    @Test
    void testGetObject() {

        BlogRepository repository = mock(BlogRepository.class);
        CommonSchemaValidation validation = mock(CommonSchemaValidation.class);
        BlogService blogService = new BlogService(repository,validation);

        int blogId = 1;
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setId(blogId);

        when(repository.getBlogById(blogId)).thenReturn(Optional.of(blogEntity));

        BlogEntity result = blogService.getObject(blogId);

        verify(repository).incrementNumberReadings(blogId);
        assertNotNull(result);
        assertEquals(blogId, result.getId());
    }
}