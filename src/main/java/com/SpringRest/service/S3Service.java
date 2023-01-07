package com.SpringRest.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@Service
//@RequiredArgsConstructor
public class S3Service {
    @Autowired
    private final AmazonS3 s3client;


    public S3Service(AmazonS3 s3client) {
        this.s3client = s3client;
    }

    public void createBucket() {
        String bucketName = "avvakumovailona2";
        if (s3client.doesBucketExistV2(bucketName)) {
            // log.info("Bucket {} already exists, use a different name", bucketName);
            return;
        }
        s3client.createBucket(bucketName);
    }
/*
    public void listBuckets(){
        List<Bucket> buckets = s3client.listBuckets();
    //    log.info("buckets: {}", buckets);
    }

    @SneakyThrows
    public void uploadFile() {
        String bucketName = "avvakumovailona";
        ClassLoader loader = S3Service.class.getClassLoader();
        File file = new File(loader.getResource("7777.drawio").getFile());
        s3client.putObject(
                bucketName,
                "7777.drawio",
                file);
    }

    public void listFiles() {
        String bucketName = "avvakumovailona";

        ObjectListing objects = s3client.listObjects(bucketName);
        for(S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
            log.info("File name: {}", objectSummary.getKey());
        }
    }

    @SneakyThrows
    public void downloadFile() {
        String bucketName = "avvakumovailona";

        S3Object s3object = s3client.getObject(bucketName, "7777.drawio");
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        File file = new File("<com/SpringRest/7777.drawio>");

        FileCopyUtils.copy(inputStream, new FileOutputStream(file));
    }*/
}
