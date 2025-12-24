package in.swarnavo.fitness.services;

import in.swarnavo.fitness.dtos.LoginRequest;
import in.swarnavo.fitness.dtos.LoginResponse;
import in.swarnavo.fitness.dtos.RegisterRequest;
import in.swarnavo.fitness.dtos.UserResponse;
import in.swarnavo.fitness.models.User;
import in.swarnavo.fitness.models.UserRole;
import in.swarnavo.fitness.repositories.UserRepository;
import in.swarnavo.fitness.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    @Override
    public UserResponse register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .role(request.getRole() == null ? UserRole.USER : UserRole.valueOf(request.getRole()))
                .build();
        User savedUser =  userRepository.save(user);
        return mapToResponse(savedUser);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            User user = userRepository.findByEmail(loginRequest.getEmail());
            if(user == null) {
                throw new RuntimeException("Invalid Credentials");
            }

            if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                throw new RuntimeException("Invalid Credentials");
            }

            String token = jwtUtils.generateToken(user.getId(), user.getRole().name());

            return new LoginResponse(token, mapToResponse(user));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            throw new RuntimeException("Authentication Error");
        }
    }

    private UserResponse mapToResponse(User savedUser) {
        return UserResponse.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .firstName(savedUser.getFirstname())
                .lastName(savedUser.getLastname())
                .role(savedUser.getRole().name())
                .createdAt(savedUser.getCreatedAt())
                .updatedAt(savedUser.getUpdatedAt())
                .build();
    }
}
