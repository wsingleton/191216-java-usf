package com.revature.services;

import com.revature.entites.Image;
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

    public Optional<Image> findById(String id){
        if(id.isEmpty() || (Integer.parseInt(id) <=0)){
            throw new InvalidInputException();
        }
        Optional<Image> _img = imageRepository.findById(id);
        if(!_img.isPresent()){
            throw new ResourceNotFoundException();
        }
        return _img;
    }


    public Image save (Image img){
        if(img == null){
            throw new ResourceNotFoundException();
        }
        return imageRepository.save(img);
    }

}
