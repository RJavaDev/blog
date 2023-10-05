package uz.blog.controller.convert;

import lombok.experimental.UtilityClass;
import uz.blog.dto.request.BlogCreatedRequestDto;
import uz.blog.dto.response.BlogResponseDto;
import uz.blog.entity.BlogEntity;

import java.util.List;

@UtilityClass
public class BlogConvert {

    public BlogEntity convertToEntity(BlogCreatedRequestDto dto) {
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setTitle(dto.getTitle());
        blogEntity.setTopic(dto.getTopic());
        blogEntity.setText(dto.getText());
        return blogEntity;
    }

    public BlogResponseDto from(BlogEntity entity) {
        return entity.toDto();
    }

    public List<BlogResponseDto> from(List<BlogEntity> blogEntityList) {
        return blogEntityList.stream().map(BlogConvert::from).toList();
    }
}
