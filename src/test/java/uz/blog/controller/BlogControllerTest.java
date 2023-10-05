package uz.blog.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import uz.blog.controller.convert.BlogConvert;
import uz.blog.dto.request.BlogCreatedRequestDto;
import uz.blog.dto.response.BlogResponseDto;
import uz.blog.entity.BlogEntity;
import uz.blog.service.Base.BlogService;
import uz.blog.service.BlogServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BlogControllerTest {



    @Test
    void addBlog() {
        BlogService blogService = mock(BlogService.class);

        BlogController blogController = new BlogController(blogService);

        Model model = mock(Model.class);

        BlogCreatedRequestDto dto = new BlogCreatedRequestDto();
        dto.setTitle("Sample Title");
        dto.setTopic("Sample Topic");
        dto.setText("Sample Text");

        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setTitle(dto.getTitle());
        blogEntity.setTopic(dto.getTopic());
        blogEntity.setText(dto.getText());

        when(blogService.add(blogEntity)).thenReturn(true);

        String result = blogController.addBlog(dto, model);

        assertEquals("redirect:/blog", result);
    }

    @Test
    void getBlogById() {
        BlogService blogServiceImpl = mock(BlogService.class);

        BlogController blogController = new BlogController(blogServiceImpl);

        ModelAndView modelAndView = new ModelAndView();

        int blogId = 1;
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setId(blogId);
        blogEntity.setTitle("Sample Title");
        blogEntity.setTopic("Sample Topic");
        blogEntity.setText("Sample Text");

        when(blogServiceImpl.getObject(blogId)).thenReturn(blogEntity);

        ModelAndView result = blogController.getBlogById(blogId, modelAndView);

        verify(blogServiceImpl).getObject(blogId);
        assertEquals("blog-show", result.getViewName());

        BlogResponseDto blogResponseDto = (BlogResponseDto) result.getModel().get("blog");

        assertNotNull(blogResponseDto);
        assertEquals(blogEntity.getTitle(), blogResponseDto.getTitle());
        assertEquals(blogEntity.getTopic(), blogResponseDto.getTopic());
        assertEquals(blogEntity.getText(), blogResponseDto.getText());
    }
}