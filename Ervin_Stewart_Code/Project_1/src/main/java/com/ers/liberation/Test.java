package com.ers.liberation;

import com.ers.liberation.repos.UserRepository;

public class Test {
    public static void main(String[] args) {
        UserRepository   userRepository = new UserRepository();
        System.out.println( userRepository.findUserByCredentials("Spacemvn","liberation"));
    }
}
