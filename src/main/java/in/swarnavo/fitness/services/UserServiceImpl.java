package in.swarnavo.fitness.services;

import in.swarnavo.fitness.dtos.RegisterRequest;
import in.swarnavo.fitness.dtos.UserResponse;
import in.swarnavo.fitness.models.User;
import in.swarnavo.fitness.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .build();
        User savedUser =  userRepository.save(user);
        return mapToResponse(savedUser);
    }

    private UserResponse mapToResponse(User savedUser) {
        return UserResponse.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .firstName(savedUser.getFirstname())
                .lastName(savedUser.getLastname())
                .createdAt(savedUser.getCreatedAt())
                .updatedAt(savedUser.getUpdatedAt())
                .build();
    }
}
