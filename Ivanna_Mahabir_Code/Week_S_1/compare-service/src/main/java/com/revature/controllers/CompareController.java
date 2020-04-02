package com.revature.controllers;

import com.revature.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comp")
public class CompareController {


    private ImageService imageService;

    @Autowired
    CompareController(ImageService imageService){this.imageService = imageService;}

    @GetMapping(value = "/{idA}/{idB}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void compareFacePics(@PathVariable String idA, @PathVariable String idB){
        imageService.compareFaces(idA, idB);
        System.out.println("comparator");
    }
}
