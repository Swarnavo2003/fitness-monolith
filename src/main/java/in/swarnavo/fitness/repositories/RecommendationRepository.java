package in.swarnavo.fitness.repositories;

import in.swarnavo.fitness.models.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, String> {
}
