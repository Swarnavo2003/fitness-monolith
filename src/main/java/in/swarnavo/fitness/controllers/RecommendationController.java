package in.swarnavo.fitness.controllers;

import in.swarnavo.fitness.dtos.RecommendationRequest;
import in.swarnavo.fitness.dtos.RecommendationResponse;
import in.swarnavo.fitness.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<RecommendationResponse> generateRecommendation(
            @RequestBody RecommendationRequest request
    ) {
        RecommendationResponse recommendation = recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }
}
