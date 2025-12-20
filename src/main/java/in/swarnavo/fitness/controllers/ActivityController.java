package in.swarnavo.fitness.controllers;

import in.swarnavo.fitness.dtos.ActivityRequest;
import in.swarnavo.fitness.dtos.ActivityResponse;
import in.swarnavo.fitness.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest activityRequest) {
        return new ResponseEntity<>(activityService.trackActivity(activityRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(
            @RequestHeader(value = "X-User-ID") String userId
    ) {
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
}
