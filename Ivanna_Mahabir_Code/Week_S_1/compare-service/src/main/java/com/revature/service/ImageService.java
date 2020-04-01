package com.revature.service;

import com.revature.entities.Picture;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public String findImgById(String id){
        if(id.isEmpty() || Integer.parseInt(id) <=0){
            throw new InvalidInputException();
        }
        Optional<Picture> _pic = imageRepository.findById(id);
        if(!_pic.isPresent()){
            throw new ResourceNotFoundException();
        }
        return imageRepository.findById(id).get().getLink();
    }

    public Picture save (Picture img){
        if(img == null){
            throw new ResourceNotFoundException();
        }
        return imageRepository.save(img);
    }
}
