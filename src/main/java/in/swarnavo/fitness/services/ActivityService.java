package in.swarnavo.fitness.services;

import in.swarnavo.fitness.dtos.ActivityRequest;
import in.swarnavo.fitness.dtos.ActivityResponse;

public interface ActivityService {
    ActivityResponse trackActivity(ActivityRequest activityRequest);
}
