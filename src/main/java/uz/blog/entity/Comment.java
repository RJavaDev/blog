package uz.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import uz.blog.entity.base.BaseServerModifierEntity;

public class Comment extends BaseServerModifierEntity {

    @ManyToOne
    private Blog blog;

    @Column(length = 400)
    private String comment;

    private Integer like;

    private Integer desLike;

    private boolean checked;

}
