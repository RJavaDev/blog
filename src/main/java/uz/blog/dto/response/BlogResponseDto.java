package uz.blog.dto.response;

import lombok.Getter;
import lombok.Setter;
import uz.blog.dto.base.BaseDto;

@Getter
@Setter
public class BlogResponseDto extends BaseDto {

    private String title;

    private String topic;

    private String text;

    private long numberOfReadings;

    private boolean checked;

}
