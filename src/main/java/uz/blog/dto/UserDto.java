package uz.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.blog.dto.base.BaseServerModifierDto;
import uz.blog.entity.UserEntity;
import uz.blog.entity.role.RoleEnum;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseServerModifierDto {

    private String firstname;

    private String phoneNumber;

    private String username;

    private List<RoleEnum> roleEnumList;
    public UserEntity toEntity( String... ignoreProperties) {
        return super.toEntity(this, new UserEntity(), ignoreProperties);
    }

}
