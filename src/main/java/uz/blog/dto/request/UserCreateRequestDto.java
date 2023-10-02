package uz.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.blog.dto.base.BaseServerModifierDto;
import uz.blog.entity.UserEntity;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto extends BaseServerModifierDto {

    @NotBlank(message = "firstname must not be null!!!")
    private String firstname;

    @NotBlank(message = "phoneNumber must not be null!!!")
    private String phoneNumber;

    @NotBlank(message = "username must not be null!!!")
    private String username;

    @NotBlank(message = "password must not be null!!!")
    private String password;

    public UserEntity toEntity(String... ignoreProperties) {
        return super.toEntity(this, new UserEntity(), ignoreProperties);
    }

}
