package com.awsbasics.simpleapp.configuration;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.lambda.AWSLambdaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class AwsConfiguration {

    private final S3ClientProperties s3ClientProperties;
    private final SNSClientProperties snsClientProperties;
    private final SQSClientProperties sqsClientProperties;
    private final LambdaClientProperties lambdaClientProperties;

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(s3ClientProperties.getRegion())
                .build();
    }

    @Bean
    public AmazonSNS snsClient(){
        return AmazonSNSClient.builder()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(snsClientProperties.getRegion())
                .build();
    }

    @Bean
    public AmazonSQS sqsClient(){
        return AmazonSQSClient.builder()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(sqsClientProperties.getRegion())
                .build();
    }

    @Bean
    public AWSLambda lambdaClient() {
        AWSLambdaClient client = new AWSLambdaClient();
        client.withRegion(Regions.fromName(lambdaClientProperties.getRegion()));

        return client;
    }
}
