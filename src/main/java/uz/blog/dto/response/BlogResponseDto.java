package uz.blog.dto.response;

import lombok.Getter;
import lombok.Setter;
import uz.blog.dto.base.BaseServerModifierDto;

@Getter
@Setter
public class BlogResponseDto extends BaseServerModifierDto {

    private String title;

    private String topic;

    private String text;

    private long numberOfReadings;

    private boolean checked;

}
