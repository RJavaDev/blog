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
public class UserService implements BaseService<UserEntity, UserRequestDto> {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
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

    @Override
    public UserEntity getObject(Integer id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new RecordNotFountException(id + " no user found for this ID")
        );
        userRepository.save(user);
        return true;
    }


    @Override
    public boolean update(int id, UserRequestDto userRequestDto) {
        UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new RecordNotFountException(id + " no user found for this id")
        );
        user.setFirstname(userRequestDto.getFirstname());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setPhoneNumber(userRequestDto.getPhoneNumber());
        user.forUpdate();
        userRepository.save(user);
        return true;
    }

    public UserEntity info(int id) {
        return userRepository.findAll().get(id);
    }
}
