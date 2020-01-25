package com.revature.mockERS;

import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.repositories.UserRepository;
import com.revature.mockERS.services.UserService;
import com.revature.mockERS.util.RequestViewHelper;
import com.revature.mockERS.util.UserSession;

import java.util.Optional;

import static com.revature.mockERS.util.ConnectionFactory.getCon;

public class MockERSDriver {
    public static void main(String[] args) {
        UserRepository ur = new UserRepository();
        UserService service = new UserService(ur);
        ERS_Users user = service.login("spiteria","password");
        UserSession us = new UserSession(user,getCon());
        RequestViewHelper rvh = new RequestViewHelper();
        rvh.process("/ers-app/dashboard.view");
    }
}
