package in.swarnavo.fitness.services;

import in.swarnavo.fitness.dtos.ActivityRequest;
import in.swarnavo.fitness.dtos.ActivityResponse;

import java.util.List;

public interface ActivityService {
    ActivityResponse trackActivity(ActivityRequest activityRequest);

    List<ActivityResponse> getUserActivities();

    List<ActivityResponse> getAllActivities();
}
