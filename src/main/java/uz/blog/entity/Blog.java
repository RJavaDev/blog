package uz.blog.entity;

import jakarta.persistence.Column;
import uz.blog.entity.base.BaseServerModifierEntity;

public class Blog extends BaseServerModifierEntity {

    private String title;

    private String topic;

    @Column(columnDefinition = "TEXT")
    private String text;

    private Integer numberOfReadings;

    private boolean checked;

}
