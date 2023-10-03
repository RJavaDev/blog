package uz.blog.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogCreatedRequestDto {

    @NotBlank(message = "title must not be null!!!")
    private String title;
    @NotBlank(message = "topic must not be null!!!")
    private String topic;
    @NotBlank(message = "text must not be null!!!")
    private String text;
}
