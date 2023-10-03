package uz.blog.dto.response;

import lombok.Getter;
import lombok.Setter;
import uz.blog.dto.base.BaseServerModifierDto;

@Getter
@Setter
public class CommentResponseDto extends BaseServerModifierDto {

    private BlogResponseDto blog;

    private String comment;

    private Integer useful;

    private Integer notUseful;

    private boolean checked;

}
