package uz.blog.entity.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.blog.constants.EntityStatus;
import uz.blog.dto.base.BaseDto;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

    @Column(name = "createdBy")
    private Integer createdBy;

    @Column(name = "modifiedBy")
    private Integer modifiedBy;

    @Column(name = "status", length = 32, columnDefinition = "varchar(32) default 'CREATED'")
    @Enumerated(value = EnumType.STRING)
    private EntityStatus status = EntityStatus.CREATED;

    public void forCreate(){
        forCreate(null);
    }
    public void forCreate(Integer creatorId){
        this.setCreatedBy(creatorId);
        this.setCreatedDate(new Date());
        this.setStatus(EntityStatus.CREATED);
    }

    public void forUpdate(){
        forUpdate(null);
    }

    public void forUpdate(Integer modifierId){
        this.setModifiedBy(modifierId);
        this.setUpdatedDate(new Date());
        this.setStatus(EntityStatus.UPDATED);
    }
    public <ENTITY extends BaseEntity, DTO extends BaseDto> DTO toDto(ENTITY entity, DTO dto, String... ignoreProperties){
        BeanUtils.copyProperties(entity, dto, ignoreProperties);
        return dto;
    }

}
