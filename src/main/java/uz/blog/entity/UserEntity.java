package uz.blog.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.blog.constants.TableNames;
import uz.blog.dto.UserRequestDto;
import uz.blog.entity.base.BaseServerModifierEntity;
import uz.blog.entity.role.RoleEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TableNames.DEPARTMENT_USER)
public class UserEntity extends BaseServerModifierEntity implements UserDetails {

    private String firstname;

    @Column(unique = true, nullable = false)
    private String phoneNumber;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private List<RoleEnum> roleEnumList;

    public static UserEntity of(UserRequestDto userRequestDto) {

        return UserEntity.builder()
                .firstname(userRequestDto.getFirstname())
                .username(userRequestDto.getUsername())
                .phoneNumber(userRequestDto.getPhoneNumber())
                .roleEnumList(List.of(RoleEnum.USER))
                .build();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roleEnumList.forEach((rol) -> {
            roles.add(new SimpleGrantedAuthority("ROLE_" + rol.name()));
        });

        return roles;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
