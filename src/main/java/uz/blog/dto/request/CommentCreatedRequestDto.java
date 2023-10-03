package uz.blog.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import uz.blog.dto.base.BaseServerModifierDto;

@Getter
@Setter
public class CommentCreatedRequestDto extends BaseServerModifierDto {

    @NotBlank(message = "comment must not be null!!!")
    private String comment;

}
