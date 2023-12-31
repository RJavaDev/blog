package uz.blog.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class UserRequestDto {


    private String firstname;
    private String username;
    private String password;
    private String phoneNumber;
    private String roles;

}
