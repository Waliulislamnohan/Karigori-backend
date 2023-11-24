package com.karigori.jobSite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    public List<job> allJobs(){
        return jobRepository.findAll();
    }
    public List<job> findByPositionAndLocation(String position, String location) {
        // Implement logic to find jobs by both position and location
        // Using your JobRepository, perform queries to find jobs based on the provided criteria
        return jobRepository.findByPositionAndLocation(position, location);
    }
    public List<job> findByJobPositionAndCategory(String position, String location, String category) {
        return jobRepository.findByPositionAndLocationAndCategory(position, location, category);
    }
    public List<job> findByPosition(String position) {
        // Implement logic to find jobs by position
        return jobRepository.findByPosition(position);
    }

    public List<job> findByLocation(String location) {
        // Implement logic to find jobs by location
        return jobRepository.findByLocation(location);
    }
}
