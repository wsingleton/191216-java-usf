package com.revature.ers;

import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Status;
import com.revature.ers.repositories.ReimbursementRepository;
import com.revature.ers.repositories.UserRepository;
import com.revature.ers.services.ReimbursementService;
import com.revature.ers.services.UserService;

class Driver{

    public static void main(String[] args) {
        /*
        UserRepository repo = new UserRepository();
        UserService serv = new UserService(repo);


        System.out.println("find all: ");
        System.out.println(repo.findAll());

        System.out.println("find by id");
        System.out.println(repo.findById(1));

        System.out.println("find by username");
        System.out.println(repo.findUserByUsername("ehsi"));

        System.out.println("find by credentials");
        System.out.println(repo.findUserByCredentials("ehsi", "password"));

        System.out.println("find by invalid credentials");
        System.out.println(repo.findUserByCredentials("ehsi", "asdf"));

        System.out.println("find by creds service");
        System.out.println(serv.authenticate("ehsi", "password"));

         */
        /*
        ReimbursementRepository reimbRepo = new ReimbursementRepository();
        ReimbursementService reimbServ = new ReimbursementService(reimbRepo);

        System.out.println("find all:");
        System.out.println(reimbServ.getAllReimbursements());

        System.out.println("find by id");
        System.out.println(reimbServ.getById(1));

        System.out.println("find by Author");
        System.out.println(reimbServ.getByAuthorId(1));

        System.out.println("update id 21 to approved and 1 to denied");
        reimbServ.update(new Reimbursement(1, Status.DENIED));
        reimbServ.update(new Reimbursement(21, Status.APPROVED));

        System.out.println(reimbServ.getAllReimbursements());
        */

    }
}

