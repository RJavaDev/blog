package uz.blog.dto.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.blog.constants.EntityStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseServerDto {
    private Integer id;
    private EntityStatus status;
}