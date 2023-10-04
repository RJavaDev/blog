package uz.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.blog.entity.UserEntity;
import uz.blog.common.exception.RecordNotFountException;
import uz.blog.dto.UserRequestDto;
import uz.blog.repository.UserRepository;
import uz.blog.service.Base.BaseService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

  
    public boolean add(UserRequestDto userRequestDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(userRequestDto.getUsername());
        if (optionalUserEntity.isPresent()) {
            throw new RecordNotFountException(userRequestDto.getUsername() + " there is a user at this username");
        }
        UserEntity user = UserEntity.of(userRequestDto);
        user.forCreate();
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        userRepository.save(user);
        return true;
    }
    
}
