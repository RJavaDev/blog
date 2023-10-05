package uz.blog.dto.response;

import lombok.Getter;
import lombok.Setter;
import uz.blog.dto.base.BaseDto;

@Getter
@Setter
public class CommentResponseDto extends BaseDto {

    private BlogResponseDto blog;

    private String comment;

    private long useful;

    private long notUseful;

    private boolean checked;

}
