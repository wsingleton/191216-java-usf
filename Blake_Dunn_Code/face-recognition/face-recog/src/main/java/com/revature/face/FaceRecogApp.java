package com.revature.face;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FaceRecogApp {

  public static void main(String[] args) {
      SpringApplication.run(FaceRecogApp.class, args);

      String target = "honestAbe.jpg";

  }
}
