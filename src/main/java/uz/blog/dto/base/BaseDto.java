package uz.blog.dto.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.blog.constants.EntityStatus;
import uz.blog.entity.base.BaseEntity;

import java.util.Date;


@Getter
@Setter
public class BaseDto {

    private Integer id;

    private EntityStatus status;

    private Date createdDate;

    private Data updatedDate;

    private Integer createdBy;

    private Integer modifiedBy;

    public <DTO extends BaseDto, ENTITY extends BaseEntity> ENTITY toEntity(DTO dto, ENTITY entity, String... ignoreProperties){
        BeanUtils.copyProperties(dto, entity, ignoreProperties);
        return entity;
    }
}
