package in.swarnavo.fitness.services;

import in.swarnavo.fitness.dtos.RegisterRequest;
import in.swarnavo.fitness.dtos.UserResponse;
import in.swarnavo.fitness.models.User;

public interface UserService {
    UserResponse register(RegisterRequest request);
}
