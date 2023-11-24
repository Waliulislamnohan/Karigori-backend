package com.karigori.jobSite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alljobs")
public class jobController {
    @Autowired
    private JobService jobService;
    @GetMapping
    public ResponseEntity<List<job>> getAllJobs(){
        return new ResponseEntity<List<job>>(jobService.allJobs(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchJobsByPositionLocationAndCategory(
            @RequestParam(value = "position", required = false) String position,
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "category", required = false) String category) {

        if ((position == null || position.isEmpty()) && (location == null || location.isEmpty()) && (category == null || category.isEmpty())) {
            return new ResponseEntity<>("Position, location, or category cannot be empty", HttpStatus.BAD_REQUEST);
        }

        List<job> jobs;
        if (position != null && !position.isEmpty() && location != null && !location.isEmpty() && category != null && !category.isEmpty()) {
            jobs = jobService.findByJobPositionAndCategory(position, location, category);
        } else if (position != null && !position.isEmpty() && location != null && !location.isEmpty()) {
            // Existing logic for position and location search
            jobs = jobService.findByPositionAndLocation(position, location);
        } else {
            // Existing logic for position or location search
            jobs = (position != null && !position.isEmpty()) ? jobService.findByPosition(position) : jobService.findByLocation(location);
        }

        if (jobs.isEmpty()) {
            return new ResponseEntity<>("No jobs found with given criteria", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(jobs);
    }
}
