package com.revature.service;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.util.IOUtils;
import com.revature.controllers.DownloadFileController;
import com.revature.entities.Picture;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;


@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;


    @Autowired
    DownloadFileController downloadFileController;

    public List<Picture> findAll(){
        return imageRepository.findAll();
    }

    public String findImgById(String id){
        if(id.isEmpty() || Integer.parseInt(id) <=0){
            throw new InvalidInputException();
        }
        Optional<Picture> _pic = imageRepository.findById(id);
        if(!_pic.isPresent()){
            throw new ResourceNotFoundException();
        }
        return imageRepository.findById(id).get().getLink();
    }

    public Picture save (Picture img){
        if(img == null){
            throw new ResourceNotFoundException();
        }
        return imageRepository.save(img);
    }

    public void compareFaces(String idA, String idB){
        ResponseEntity<byte[]> linkA = downloadFileController.downloadFile(findImgById(idA));
        ResponseEntity<byte[]> linkB = downloadFileController.downloadFile(findImgById(idB));
        Float similarity = 70F;
        ByteBuffer sourceImageBytes=null;
        ByteBuffer targetImageBytes=null;

        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();

        try (InputStream inputStream = new FileInputStream(new File(linkA.toString()))) {
            sourceImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        }
        catch(Exception e)
        {
            System.out.println("Failed to load source image " + linkA);
            System.exit(1);
        }
        try (InputStream inputStream = new FileInputStream(new File(linkB.toString()))) {
            targetImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        }
        catch(Exception e)
        {
            System.out.println("Failed to load target images: " + linkB);
            System.exit(1);
        }

        Image source=new Image()
                .withBytes(sourceImageBytes);
        Image target=new Image()
                .withBytes(targetImageBytes);

        CompareFacesRequest request = new CompareFacesRequest()
                .withSourceImage(source)
                .withTargetImage(target)
                .withSimilarityThreshold(similarity);

        CompareFacesResult compareFacesResult=rekognitionClient.compareFaces(request);

        List <CompareFacesMatch> faceDetails = compareFacesResult.getFaceMatches();
        for (CompareFacesMatch match: faceDetails){
            ComparedFace face= match.getFace();
            BoundingBox position = face.getBoundingBox();
            System.out.println("Face at " + position.getLeft().toString()
                    + " " + position.getTop()
                    + " matches with " + match.getSimilarity().toString()
                    + "% confidence.");

        }
        List<ComparedFace> uncompared = compareFacesResult.getUnmatchedFaces();

        System.out.println("There was " + uncompared.size()
                + " face(s) that did not match");

    }
}
