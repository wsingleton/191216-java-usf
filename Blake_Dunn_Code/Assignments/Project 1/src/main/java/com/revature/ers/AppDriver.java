package com.revature.ers;


import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.User;
import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.repos.UserRepository;

public class AppDriver {



    public static void main(String[] args) {

        UserRepository repo = new UserRepository();
        ReimbursementRepository otherRepo = new ReimbursementRepository();

        System.out.println("find all:");
        for (User u : repo.findAll()) System.out.println(u.toString());
        System.out.println("+----------------------------+");

        System.out.println("find by valid credentials");
        System.out.println(repo.findUserByCredentials("buhlakay", "boatsnhoes"));
        System.out.println("+----------------------------+");

        System.out.println("find all:");
        for (Reimbursement r : otherRepo.findAll()) System.out.println(r.toString());
        System.out.println("+----------------------------+");

    }
}

