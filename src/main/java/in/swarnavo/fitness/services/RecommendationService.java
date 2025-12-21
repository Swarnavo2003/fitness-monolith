package in.swarnavo.fitness.services;

import in.swarnavo.fitness.dtos.RecommendationRequest;
import in.swarnavo.fitness.dtos.RecommendationResponse;

public interface RecommendationService {
    RecommendationResponse generateRecommendation(RecommendationRequest request);
}
