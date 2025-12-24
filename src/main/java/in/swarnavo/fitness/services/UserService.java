package in.swarnavo.fitness.services;

import in.swarnavo.fitness.dtos.LoginRequest;
import in.swarnavo.fitness.dtos.LoginResponse;
import in.swarnavo.fitness.dtos.RegisterRequest;
import in.swarnavo.fitness.dtos.UserResponse;
import in.swarnavo.fitness.models.User;
import org.springframework.http.HttpStatusCode;

public interface UserService {
    UserResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest loginRequest);
}
