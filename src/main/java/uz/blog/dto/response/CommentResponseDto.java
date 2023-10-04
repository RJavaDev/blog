package uz.blog.dto.response;

import lombok.Getter;
import lombok.Setter;
import uz.blog.dto.base.BaseServerModifierDto;

@Getter
@Setter
public class CommentResponseDto extends BaseServerModifierDto {

    private BlogResponseDto blog;

    private String comment;

    private long useful;

    private long notUseful;

    private boolean checked;

}
