package io.github.jithset.s3psqldemo.utils;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class S3Utils {

    @Autowired
    private AmazonS3 s3Client;

    @Value("${application.bucket.name}")
    private String bucketName;

    @Value("${cloud.aws.region.static}")
    private String region;

    public String saveFile(String fileName, File fileObj) {
        s3Client.putObject(bucketName, fileName, fileObj);
        fileObj.delete();
        return createPublicUrl(fileName);
    }

    private String createPublicUrl(String fileName) {
        return String.format("https://%s.s3.%s.amazonaws.com/%s",bucketName, region, fileName);
    }
}
