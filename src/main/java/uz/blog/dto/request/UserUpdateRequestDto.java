package uz.blog.dto.request;

import lombok.*;
import uz.blog.dto.base.BaseUserDto;
import uz.blog.entity.UserEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateRequestDto extends BaseUserDto {

    private String firstname;

    private String phoneNumber;

    private String username;

    private String password;

}
