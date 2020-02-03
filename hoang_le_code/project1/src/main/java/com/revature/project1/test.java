package com.revature.project1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.Status;
import com.revature.project1.models.Type;
import com.revature.project1.models.User;
import com.revature.project1.repos.ReimbursementRepository;
import com.revature.project1.repos.UserRepository;
import com.revature.project1.services.UserService;

import java.util.Set;

public class test {
    public static void main(String[] args) throws JsonProcessingException {
        UserService a = new UserService(new UserRepository());
        User b;
        b= a.authenticate("hle","pass");
        System.out.println("dsadas " + b.getFirstName());

        System.out.println("dasdasdasdasdasdasd");
        System.out.println("check");
        ReimbursementRepository re = new ReimbursementRepository();
        Set<Reimbursement> d = re.findAllById(43);
        ObjectMapper mapper = new ObjectMapper();
        String reimbJSON = mapper.writeValueAsString(d);
        System.out.println("dasdasd   "   + reimbJSON);
        Status st = Status.PENDING;
        Type ty = Type.FOOD;
        Set<Reimbursement> aaa = re.findAll();
        String reimbJSON1 = mapper.writeValueAsString(aaa);

        for(Reimbursement stock : aaa){
            System.out.println(stock.toString());
        }
        Reimbursement up = new Reimbursement(0,"qwe",null,null,"dasd",null,1,1,st,ty);

        System.out.println("update : " + re.update(up));
        System.out.println("hoang " + reimbJSON1);
    }
}
