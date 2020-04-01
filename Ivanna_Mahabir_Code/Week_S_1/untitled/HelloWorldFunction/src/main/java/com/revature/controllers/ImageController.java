package com.revature.controllers;

import com.revature.entites.Image;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/img")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){this.imageService = imageService;}

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLinkById(@PathVariable String id){
        if(id.isEmpty() || Integer.parseInt(id) <= 0){
            throw new InvalidInputException();
        }
        Optional<Image> _room = imageService.findById(id);
        if(!_room.isPresent()){
            throw new ResourceNotFoundException();
        }
        return imageService.findById(id).get().getLink();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Image saveImg(@RequestBody Image img){
        if(img == null){
            throw new ResourceNotFoundException();
        }
        return imageService.save(img);
    }
}
