package com.SpringRest.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class S3ServiceTest {

    @Autowired
    private S3Service s3Service;

    @Test
    public void testCreateBucket() {
        s3Service.createBucket();
    }

    @Test
    public void testListBuckets(){
        s3Service.listBuckets();
    }

//    @Test
//    public void testUploadFile(){
//        s3Service.uploadFile();
//    }
    @Test
    public void downloadFile(){
        s3Service.downloadFile();
    }

}