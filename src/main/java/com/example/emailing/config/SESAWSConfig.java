package com.example.emailing.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SESAWSConfig {

    @Value("${aws.SESAccesskey}")
    private String awsId;

    @Value("${aws.SESSecretkey}")
    private String awsKey;

    @Bean
    public AWSCredentials credential() {
        return new BasicAWSCredentials(awsId, awsKey);
    }

    @Bean
    public AWSCredentialsProvider getAWSCredentialsProvider() {
        return new AWSStaticCredentialsProvider(credential());
    }

    @Bean
    public AmazonSimpleEmailService amazonSES() {
        AmazonSimpleEmailService amazonSimpleEmailService = AmazonSimpleEmailServiceClient.builder()
                .withCredentials(getAWSCredentialsProvider())
                .withRegion(Regions.EU_WEST_1)
                .build();
        return amazonSimpleEmailService;
    }

}