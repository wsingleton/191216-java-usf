package com.revature;


import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.util.IOUtils;
import com.revature.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

@EnableEurekaClient
@SpringBootApplication
public class CompareFaceApplication implements CommandLineRunner{

    @Autowired
    private ImageService imageService;

    public static void main(String[] args)
    {
        SpringApplication.run(CompareFaceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        com.revature.entites.Image picA = new com.revature.entites.Image("1", "imgA.jpg");
        com.revature.entites.Image picB = new com.revature.entites.Image("2", "imgB.jpg");
        com.revature.entites.Image picC = new com.revature.entites.Image("3", "imgC.jpg");

        imageService.save(picA);
        imageService.save(picB);
        imageService.save(picC);

        Float similarityThreshold = 70F;
        String imgA = imageService.getLinkById("1");
        String imgB = imageService.getLinkById("2");
        String imgC = imageService.getLinkById("3");
        ByteBuffer imgABytes = null;
        ByteBuffer imgBBytes = null;
        ByteBuffer imgCBytes = null;

        AmazonRekognition amazonRekognition = AmazonRekognitionClientBuilder.defaultClient();

        try (InputStream inputStream = new FileInputStream(new File(imgA))) {
            imgABytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        }
        catch(Exception e)
        {
            System.out.println("Failed to load first image " + imgA);
            System.exit(1);
        }
        try (InputStream inputStream = new FileInputStream(new File(imgB))) {
            imgBBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        }
        catch(Exception e)
        {
            System.out.println("Failed to load second images: " + imgB);
            System.exit(1);
        }
        try (InputStream inputStream = new FileInputStream(new File(imgC))) {
            imgCBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        }
        catch(Exception e)
        {
            System.out.println("Failed to load third images: " + imgC);
            System.exit(1);
        }

        Image a = new Image().withBytes(imgABytes);
        Image b = new Image().withBytes(imgBBytes);
        Image c = new Image().withBytes(imgCBytes);

        CompareFacesRequest requestOne = new CompareFacesRequest().withSourceImage(a)
                .withTargetImage(b).withSimilarityThreshold(similarityThreshold);
        CompareFacesResult compareFacesResultOne=amazonRekognition.compareFaces(requestOne);

        CompareFacesRequest requestTwo = new CompareFacesRequest().withSourceImage(a)
                .withTargetImage(c).withSimilarityThreshold(similarityThreshold);
        CompareFacesResult compareFacesResultTwo=amazonRekognition.compareFaces(requestTwo);

        List<CompareFacesMatch> faceDetailsOne = compareFacesResultOne.getFaceMatches();
        for (CompareFacesMatch match: faceDetailsOne){
            ComparedFace faceOne= match.getFace();
            BoundingBox positionOne = faceOne.getBoundingBox();
            System.out.println("Face at " + positionOne.getLeft().toString()
                    + " " + positionOne.getTop()
                    + " matches with " + match.getSimilarity().toString()
                    + "% confidence.");

        }
        List<ComparedFace> uncompared = compareFacesResultOne.getUnmatchedFaces();

        System.out.println("There was " + uncompared.size()
                + " face(s) that did not match");
    }
}
