package br.com.fiap.techchallenge.frameworks.configs;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import lombok.RequiredArgsConstructor;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;

@Configuration
@EnableDynamoDBRepositories(basePackages = "br.com.fiap.techchallenge")
@RequiredArgsConstructor
public class DynamoDBConfig {

    @Value("${aws.dynamodb.endpoint}")
    private final String endpoint;

    @Value("${aws.region}")
    private final String region;

    @Value("${aws.accessKey}")
    private final String accessKey;

    @Value("${aws.secretKey}")
    private final String secretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);


        return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .build();
    }
}
