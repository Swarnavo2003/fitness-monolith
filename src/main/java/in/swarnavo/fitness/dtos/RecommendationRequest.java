package in.swarnavo.fitness.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationRequest {
    private String activityId;
    private String type;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
}
