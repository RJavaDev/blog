package uz.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import uz.blog.constants.TableNames;
import uz.blog.dto.response.CommentResponseDto;
import uz.blog.entity.base.BaseEntity;


@Getter
@Setter
@Entity
@Table(name = TableNames.BLOG_COMMENT)
public class CommentEntity extends BaseEntity {

    @ManyToOne
    private BlogEntity blog;

    @Column(length = 400)
    private String comment;

    private long useful;

    private long notUseful;

    private boolean checked;

    public CommentResponseDto toDto(String... ignoreProperties){
        return toDto(this, new CommentResponseDto(), ignoreProperties);
    }

}
