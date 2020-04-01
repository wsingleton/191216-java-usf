package com.revature.repositories;

import com.revature.entities.Picture;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Picture, String> {

}
