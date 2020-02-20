package com.revature.web.controllers;

import com.revature.models.ApplicationStatus;
import com.revature.models.Artist;
import com.revature.models.Vendor;
import com.revature.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService service) {
        super();
        this.managerService = service;
    }

    @PostMapping(value="/approve-art", produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Artist approveArtist(@RequestBody Artist assnArtist) {
        assnArtist.setStatus(ApplicationStatus.APPROVED);
        return managerService.updateArtist(assnArtist);
    }

    @PostMapping(value="/deny-art", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Artist denyArtist(@RequestBody Artist assnArtist) {
        assnArtist.setStatus(ApplicationStatus.DENIED);
        return managerService.updateArtist(assnArtist);
    }

    @PostMapping(value="/approve-ven", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Vendor approveVendor(@RequestBody Vendor assnVendor) {
        assnVendor.setStatus(ApplicationStatus.APPROVED);
        return managerService.updateVendor(assnVendor);
    }

    @PostMapping(value="/deny-ven", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Vendor denyVendor(@RequestBody Vendor assnVendor) {
        assnVendor.setStatus(ApplicationStatus.DENIED);
        return managerService.updateVendor(assnVendor);
    }

}
