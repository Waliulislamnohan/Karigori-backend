package com.karigori.jobSite;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends MongoRepository<job, ObjectId> {

    List<job> findByPositionAndLocation(String position, String location);
    List<job> findByPositionAndLocationAndCategory(String position, String location, String category);

    List<job> findByPosition(String position);

    List<job> findByLocation(String location);
}
