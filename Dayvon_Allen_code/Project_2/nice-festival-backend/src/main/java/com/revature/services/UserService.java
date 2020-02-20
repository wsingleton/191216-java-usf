package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.BadRequestException;
import com.revature.models.*;
import com.revature.repositories.ArtistRepository;
import com.revature.repositories.CustomerRepository;
import com.revature.repositories.UserRepository;
import com.revature.repositories.VendorRepository;
import com.revature.web.dtos.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepo;
    private ArtistRepository artistRepo;
    private CustomerRepository customerRepo;
    private VendorRepository vendorRepo;

    @Autowired
    public UserService(UserRepository ur, ArtistRepository ar, CustomerRepository cr, VendorRepository vr) {
        super();
        this.userRepo = ur;
        this.artistRepo = ar;
        this.customerRepo = cr;
        this.vendorRepo = vr;
    }

    @Transactional
    public User registerUser(User newUser) {

        // TODO: VALIDATION


        return userRepo.save(newUser);
    }

    @Transactional
    public Artist registerArtist(Artist newArtist) {

        if (newArtist == null || newArtist.getUser() == null || newArtist.getDetails() == null || newArtist.equals("")) {
            throw new BadRequestException("Artist object invalid!");
        }

        return artistRepo.save(newArtist);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Transactional
    public Customer registerCustomer(Customer newCustomer) {

        if (newCustomer == null || newCustomer.getAddress() == null || newCustomer.getCity() == null ||
        newCustomer.getUser() == null || newCustomer.getState() == null || newCustomer.getState().equals("")
        || newCustomer.getCity().equals("") || newCustomer.getCity().equals(""))
        {
            throw new BadRequestException("Customer object invalid!");
        }

        return customerRepo.save(newCustomer);
    }

    @Transactional
    public Vendor registerVendor(Vendor newVendor) {

        if (newVendor == null || newVendor.getUser() == null || newVendor.getDetails() == null
        || newVendor.getTent() == null || newVendor.getDetails().equals(""))
        {
            throw new BadRequestException("Vendor object invalid!");
        }

        return vendorRepo.save(newVendor);
    }


    @Transactional(readOnly=true)
    public User authenticate(Credentials creds) {

        if (creds == null || creds.getUsername() == null || creds.getPassword() == null
        || creds.getUsername().equals("") || creds.getPassword().equals(""))
        {
            throw new BadRequestException("Invalid credentials object provided!");
        }

        User retrievedUser = userRepo.findUserByCredentials(creds);

        if (retrievedUser == null) {
            throw new AuthenticationException();
        }

        return  retrievedUser;

    }

}
