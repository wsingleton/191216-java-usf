package com.revature.service;

import org.springframework.stereotype.Service;

@Service
public class QueueService {

    private AWSCredentials cred;
    private AmazonSQS sqs;
    private String accessKey;
    private String secretKey;
    private String url;

    public void buildQueue(){
        cred = new BasicAWSCredentials(accessKey, secretKey);
        sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(cred))
                .withRegion(Region.US_EAST_2)
                .build();
    }
    public String sendMessage(String message){
        SendMessageRequest request = new SendMessageRequest()
                .withQueueUrl(url)
                .withMessageBody(message);
        sqs.sendMessage(request);
        return message;
    }

    public String getMessage(){

    }
}
