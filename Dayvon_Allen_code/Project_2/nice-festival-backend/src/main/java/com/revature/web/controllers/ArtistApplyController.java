package com.revature.web.controllers;

import com.revature.models.ApplicationStatus;
import com.revature.models.Artist;
import com.revature.models.StageType;
import com.revature.services.ManagerService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistApplyController {

    private ManagerService managerService;
    private UserService userService;

    @Autowired
    public ArtistApplyController(ManagerService service, UserService uService) {
        super();
        this.managerService = service;
        this.userService = uService;
    }

    @PostMapping(value="/apply", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Artist registerArtist(@RequestBody Artist newArtist) {
        newArtist.setStatus(ApplicationStatus.PENDING);
        return userService.registerArtist(newArtist);
    }
    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Artist> getAll() { return  managerService.getAllArtists();}






}
