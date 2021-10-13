package training.proj.mobilele.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import training.proj.mobilele.models.entities.UserEntity;
import training.proj.mobilele.models.entities.UserRoleEntity;
import training.proj.mobilele.models.entities.enums.UserRoleEnum;
import training.proj.mobilele.models.service.UserRegistrationServiceModel;
import training.proj.mobilele.repositories.UserRepository;
import training.proj.mobilele.repositories.UserRoleRepository;
import training.proj.mobilele.services.UserService;

import java.time.Instant;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public boolean userNameExists(String username) {
       return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public void registerUser(UserRegistrationServiceModel serviceModel) {

        UserEntity user = modelMapper.map(serviceModel, UserEntity.class);
        user.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        UserRoleEntity userRole = userRoleRepository
                .findByRole(UserRoleEnum.USER).orElseThrow(
                        ()->new IllegalStateException("USER role not found. Please seed the roles."));

        user.setUserRoles(List.of(userRole));
        user.setCreated(Instant.now());
        user.setUpdated(Instant.now());
        userRepository.save(user);

    }
}
