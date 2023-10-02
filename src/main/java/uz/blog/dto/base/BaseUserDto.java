package uz.blog.dto.base;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import uz.blog.entity.base.BaseServerModifierEntity;


@Data
public class BaseUserDto {

    public <DTO extends BaseUserDto, ENTITY extends BaseServerModifierEntity> ENTITY toEntity(DTO dto, ENTITY entity, String... ignoreProperties){
        BeanUtils.copyProperties(dto, entity, ignoreProperties);
        return entity;
    }
}
