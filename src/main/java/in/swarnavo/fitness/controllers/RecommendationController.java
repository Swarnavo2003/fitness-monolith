package in.swarnavo.fitness.controllers;

import in.swarnavo.fitness.dtos.RecommendationRequest;
import in.swarnavo.fitness.dtos.RecommendationResponse;
import in.swarnavo.fitness.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecommendationResponse>> getUserRecommendations(@PathVariable String userId) {
        List<RecommendationResponse> recommendationList = recommendationService.getUserRecommendations(userId);
        return ResponseEntity.ok(recommendationList);
    }
}
