package uz.blog.controller.convert;

import lombok.experimental.UtilityClass;
import uz.blog.dto.request.CommentCreatedRequestDto;
import uz.blog.entity.CommentEntity;
import uz.blog.dto.response.CommentResponseDto;

import java.util.List;

@UtilityClass
public class CommentConvert {

    public CommentEntity convertToEntity(CommentCreatedRequestDto dto){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment(dto.getComment());
        return commentEntity;
    }

    public CommentResponseDto from(CommentEntity entity){
        CommentResponseDto blogDto = entity.toDto("blog");
        blogDto.setBlog(BlogConvert.from(entity.getBlog()));
        return blogDto;
    }

    public List<CommentResponseDto> from(List<CommentEntity> entityList){
        return entityList.stream().map(CommentConvert::from).toList();
    }
}
