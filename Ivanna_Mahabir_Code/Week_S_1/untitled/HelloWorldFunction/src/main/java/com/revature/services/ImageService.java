package com.revature.services;

import com.revature.entites.Image;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;


    public String getLinkById(String id){
        if(id.isEmpty() || Integer.parseInt(id) <= 0){
            throw new InvalidInputException();
        }
        Optional<Image> _room = imageRepository.findById(id);
        if(!_room.isPresent()){
            throw new ResourceNotFoundException();
        }
        return imageRepository.findById(id).get().getLink();
    }

    public Image save (Image img){
        if(img == null){
            throw new ResourceNotFoundException();
        }
        return imageRepository.save(img);
    }

}
