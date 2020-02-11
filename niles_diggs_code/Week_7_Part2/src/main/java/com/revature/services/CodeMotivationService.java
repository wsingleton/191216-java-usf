package com.revature.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("code") // references the bean containing the the qualifier within the parameter list
public class CodeMotivationService implements MotivationService {
    @Override
    public String getMotivation() {
        return null;
    }
}
