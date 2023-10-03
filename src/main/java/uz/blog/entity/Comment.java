package uz.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import uz.blog.constants.TableNames;
import uz.blog.entity.base.BaseServerModifierEntity;


@Getter
@Setter
@Entity
@Table(name = TableNames.BLOG_COMMENT)
public class Comment extends BaseServerModifierEntity {

    @ManyToOne
    private Blog blog;

    @Column(length = 400)
    private String comment;

    private Integer useful;

    private Integer notUseful;

    private boolean checked;

}
