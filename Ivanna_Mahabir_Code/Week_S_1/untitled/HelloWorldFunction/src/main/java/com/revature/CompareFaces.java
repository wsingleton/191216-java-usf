package com.revature;


import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.util.IOUtils;
import com.revature.controllers.ImageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

@EnableEurekaClient
@SpringBootApplication
public class CompareFaces {

    @Autowired
    private static ImageController imageController;

    public static void main(String[] args) throws Exception{

        Float similarityThreshold = 70F;
        String imgA = "";
        String imgB = "";
        String imgC = "";
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

        List<CompareFacesMatch> faceDetails = compareFacesResultOne.getFaceMatches();
        for (CompareFacesMatch match: faceDetails){
            ComparedFace face= match.getFace();
            BoundingBox position = face.getBoundingBox();
            System.out.println("Face at " + position.getLeft().toString()
                    + " " + position.getTop()
                    + " matches with " + match.getSimilarity().toString()
                    + "% confidence.");

        }
        List<ComparedFace> uncompared = compareFacesResultOne.getUnmatchedFaces();

        System.out.println("There was " + uncompared.size()
                + " face(s) that did not match");
    }
}
