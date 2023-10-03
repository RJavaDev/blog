package uz.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import uz.blog.constants.TableNames;
import uz.blog.entity.base.BaseServerModifierEntity;


@Getter
@Setter
@Entity
@Table(name = TableNames.BLOG)
public class Blog extends BaseServerModifierEntity {

    private String title;

    private String topic;

    @Column(columnDefinition = "TEXT")
    private String text;

    private Integer numberOfReadings;

    private boolean checked;

}
