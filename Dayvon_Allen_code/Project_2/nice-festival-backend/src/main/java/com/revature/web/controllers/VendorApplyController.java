package com.revature.web.controllers;

import com.revature.models.*;
import com.revature.services.ManagerService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorApplyController {

    private ManagerService managerService;
    private UserService userService;

    @Autowired
    public VendorApplyController(ManagerService service, UserService userService1) {
        super();
        this.managerService = service;
        this.userService = userService1;
    }

    @PostMapping(value="/apply", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Vendor registerArtist(@RequestBody Vendor newVendor) {
        newVendor.setStatus(ApplicationStatus.PENDING);
        return userService.registerVendor(newVendor);
    }

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Vendor> getAll() {
        return managerService.getAllVendors();
    }

}
