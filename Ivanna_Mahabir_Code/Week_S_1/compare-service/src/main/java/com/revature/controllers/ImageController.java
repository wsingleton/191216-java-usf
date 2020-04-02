package com.revature.controllers;

import com.revature.entities.Picture;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/img")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){this.imageService = imageService;}

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getImgById(@PathVariable String id){
        if(id.isEmpty() || Integer.parseInt(id) <= 0){
            throw new InvalidInputException();
        }
        return imageService.findImgById(id);
    }

 /*   @GetMapping(value = "/{idA}/{idB}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void compareFacePics(@PathVariable String idA, @PathVariable String idB){
        imageService.compareFaces(idA, idB);
    }*/

    @GetMapping
    public List<Picture> getAll(){
        return imageService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Picture saveImg(@RequestBody Picture img){
        if(img == null){
            throw new ResourceNotFoundException();
        }
        return imageService.save(img);
    }

}