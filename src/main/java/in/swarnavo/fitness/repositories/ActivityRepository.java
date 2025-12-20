package in.swarnavo.fitness.repositories;

import in.swarnavo.fitness.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, String> {
}
