package com.revature.services;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Reimburstment;
import com.revature.models.User;
import com.revature.repos.ReimburstRepository;

import java.util.Set;

public class ReimburstService {

    private ReimburstRepository reimbRepo;

    public ReimburstService(ReimburstRepository repo){
        super();
        this.reimbRepo = repo;
    }

    public Reimburstment getReimbById(int id){
        return reimbRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Set<Reimburstment> getAllReimByAuthor(Integer id){
        Set<Reimburstment> reimbs;
        if(id == null){
            throw new InvalidRequestException();
        }
        reimbs = reimbRepo.findAllByAuthor(id);

        if(reimbs.isEmpty()){
            throw new ResourceNotFoundException();
        }
        return reimbs;
    }

    public Set<Reimburstment> getAllByStatus(Integer status){
        Set<Reimburstment> reimbs;
        if(status == null) {
            throw new InvalidRequestException();
        }
        reimbs = reimbRepo.findByStatus(status);

        if(reimbs.isEmpty()){
            throw new ResourceNotFoundException();
        }
        return reimbs;
    }

    public Set<Reimburstment> getAllByType(Integer type){
        Set<Reimburstment> reimbs;
        if(type == null) {
            throw new InvalidRequestException();
        }
        reimbs = reimbRepo.findByType(type);

        if(reimbs.isEmpty()){
            throw new ResourceNotFoundException();
        }
        return reimbs;
    }

    public void createReimb(Reimburstment newReimb) {
        if(!isReimbValid(newReimb)) throw new InvalidRequestException();

        reimbRepo.save(newReimb);
    }


    public Boolean isReimbValid(Reimburstment reimb){
        if(reimb == null) return false;
        if(reimb.getAmount() == null || reimb.getAmount() <= 0) return false;
        if(reimb.getSubmitted() == null || reimb.getSubmitted().toString().equals("")) return false;
        if(reimb.getDescription() == null || reimb.getDescription().trim().equals("")) return false;
        if(reimb.getAuthor() == null || reimb.getAuthor().equals(0)) return false;
        if(reimb.getStatus() == null || reimb.getStatus().equals(0)) return false;
        if(reimb.getType() == null || reimb.getType().equals(0)) return false;
        return true;
    }

}
