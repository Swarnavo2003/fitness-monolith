package in.swarnavo.fitness.services;

import in.swarnavo.fitness.dtos.RecommendationRequest;
import in.swarnavo.fitness.dtos.RecommendationResponse;

import java.util.List;

public interface RecommendationService {
    RecommendationResponse generateRecommendation(RecommendationRequest request);

    List<RecommendationResponse> getUserRecommendations(String userId);

    List<RecommendationResponse> getActivityRecommendations(String activityId);
}
