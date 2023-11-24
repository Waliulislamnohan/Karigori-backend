package com.karigori.jobSite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "job")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class job {
    @Id
    private ObjectId id;
    private String position;
    private String location;
    private String category;
    private List<String> requirements;
    private List<String> backdrops;
}
