package in.swarnavo.fitness.services;

import in.swarnavo.fitness.dtos.ActivityResponse;
import in.swarnavo.fitness.dtos.RecommendationRequest;
import in.swarnavo.fitness.dtos.RecommendationResponse;
import in.swarnavo.fitness.dtos.UserResponse;
import in.swarnavo.fitness.models.Activity;
import in.swarnavo.fitness.models.Recommendation;
import in.swarnavo.fitness.models.User;
import in.swarnavo.fitness.repositories.ActivityRepository;
import in.swarnavo.fitness.repositories.RecommendationRepository;
import in.swarnavo.fitness.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final UserRepository userRepository;

    private final ActivityRepository activityRepository;

    private final RecommendationRepository recommendationRepository;

    @Override
    public RecommendationResponse generateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found : " + request.getUserId() ));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity Not Found : " + request.getActivityId() ));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .type(request.getType())
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();

        Recommendation savedRecommendation = recommendationRepository.save(recommendation);

        UserResponse userResponse = UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(null)
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();

        ActivityResponse activityResponse = ActivityResponse.builder()
                .id(activity.getId())
                .userId(userResponse.getId())
                .type(activity.getType())
                .additionalMetrics(activity.getAdditionalMetrics())
                .duration(activity.getDuration())
                .caloriesBurned(activity.getCaloriesBurned())
                .startTime(activity.getStartTime())
                .createdAt(activity.getCreatedAt())
                .updatedAt(activity.getUpdatedAt())
                .build();

        return RecommendationResponse.builder()
                .id(savedRecommendation.getId())
                .user(userResponse)
                .activity(activityResponse)
                .type(recommendation.getType())
                .recommendations(recommendation.getRecommendations())
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .createdAt(recommendation.getCreatedAt())
                .updatedAt(recommendation.getUpdatedAt())
                .build();
    }
}
