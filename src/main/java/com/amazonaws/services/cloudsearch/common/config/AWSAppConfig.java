package com.amazonaws.services.cloudsearch.common.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudsearch.AmazonCloudSearchClient;
import com.amazonaws.services.cloudsearch.common.json.JsonObjectMapper;
import com.amazonaws.services.cloudsearch.rest.CloudSearchReadResource;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.rds.AmazonRDSClient;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.amazonaws.services.sns.AmazonSNSClient;
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.Collections;
import java.util.List;

/**
 * The Class AppConfig.
 */
@Configuration
@ImportResource({"classpath*:META-INF/spring/root-context.xml",
                "classpath*:META-INF/spring/applicationContext*.xml"})
public class AWSAppConfig {

	/** The key. */
	@Value("${access.key}") private String key;
	
	/** The secret. */
	@Value("${secret.key}") private String secret;
	
	/** The ec2 endpoint. */
	@Value("${ec2.endpoint}") private String ec2Endpoint;
	
	/** The sns endpoint. */
	@Value("${sns.endpoint}") private String snsEndpoint;
	
	/** The sdb endpoint. */
	@Value("${sdb.endpoint}") private String sdbEndpoint;
	
	/** The s3 endpoint. */
	@Value("${s3.endpoint}") private String s3Endpoint;
	
	/** The rds endpoint. */
	@Value("${rds.endpoint}") private String rdsEndpoint;

    @Value("${dynamodb.endpoint}") private String dynamoDBEndpoint;

    @Value("${cloudsearch.endpoint}") private String cloudSearchEndpoint;

	/** The proxy port. */
	@Value("${aws.proxyPort}") private String proxyPort;

	/** The proxy host. */
	@Value("${aws.proxyHost}") private String proxyHost;

	/** The proxy username. */
	@Value("${aws.proxyUsername}") private String proxyUsername;

	/** The proxy password. */
	@Value("${aws.proxyPassword}") private String proxyPassword;

	/** The proxy domain. */
	@Value("${aws.proxyDomain}") private String proxyDomain;

	/** The proxy workstation. */
	@Value("${aws.proxyWorkstation}") private String proxyWorkstation;

    @Value("${cloudsearch.search.endpoint}") private String searchEndpoint;

    @Value("${cloudsearch.document.endpoint}") private String documentEndpoint;

    @Value("${cloudsearch.version}")  private String cloudsearchVersion;

    /** The Constant JACKSON_PROVIDER. */
    private static final List<JacksonJsonProvider> JACKSON_PROVIDER = Collections.singletonList(new JacksonJsonProvider(new JsonObjectMapper()));

    public @Bean
    CloudSearchReadResource ProxyCloudSearchReadClient() {
        return JAXRSClientFactory.create(searchEndpoint, CloudSearchReadResource.class, JACKSON_PROVIDER);
    }

    /**
     * Ec2 client.
     *
     * @return the amazon e c2
     */
    public @Bean AmazonEC2 ec2Client() {
    	AmazonEC2Client ec2 = new AmazonEC2Client(awsCredentials(), clientConfiguration());
        ec2.setEndpoint(ec2Endpoint);
        return ec2;
    }
    
    /**
     * Sns client.
     *
     * @return the amazon sns client
     */
    public @Bean AmazonSNSClient snsClient() {
    	AmazonSNSClient sns = new AmazonSNSClient(awsCredentials(), clientConfiguration());
        sns.setEndpoint(snsEndpoint);
        return sns;
    }
    
    /**
     * Sdb client.
     *
     * @return the amazon simple db client
     */
    public @Bean AmazonSimpleDBClient sdbClient() {
    	AmazonSimpleDBClient sdb = new AmazonSimpleDBClient(awsCredentials(), clientConfiguration());
        sdb.setEndpoint(sdbEndpoint);
        return sdb;
    }
    
    /**
     * S3 client.
     *
     * @return the amazon s3 client
     */
    public @Bean AmazonS3Client s3Client() {
    	AmazonS3Client s3 = new AmazonS3Client(awsCredentials(), clientConfiguration());
        s3.setEndpoint(s3Endpoint);
        return s3;
    }

    /**
     * Rds client.
     *
     * @return the amazon rds client
     */
    public @Bean AmazonRDSClient rdsClient() {
    	AmazonRDSClient rds = new AmazonRDSClient(awsCredentials(), clientConfiguration());
        rds.setEndpoint(rdsEndpoint);
        return rds;
    }

    public @Bean
    AmazonDynamoDBClient dynamoDBClient() {
        AmazonDynamoDBClient dynamoDB = new AmazonDynamoDBClient(awsCredentials(), clientConfiguration());
        dynamoDB.setEndpoint(dynamoDBEndpoint);
        return dynamoDB;
    }

    public @Bean
    AmazonCloudSearchClient cloudSearchClient() {
        AmazonCloudSearchClient cloudSearch = new AmazonCloudSearchClient(awsCredentials(), clientConfiguration());
        cloudSearch.setEndpoint(cloudSearchEndpoint);
        return cloudSearch;
    }

    /**
     * Aws credentials.
     *
     * @return the basic aws credentials
     */
    private BasicAWSCredentials awsCredentials() {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(secret)) {
            return new BasicAWSCredentials(System.getenv("AWS_ACCESS_KEY_ID"), System.getenv("AWS_SECRET_ACCESS_KEY"));
        }
        return new BasicAWSCredentials(key, secret);
    }

    /**
     * Client configuration.
     *
     * @return the client configuration
     */
    private ClientConfiguration clientConfiguration() {

        int proxyPortInt = StringUtils.isEmpty(proxyPort) ? 0 : Integer.valueOf(proxyPort);
        return  (new ClientConfiguration())
                .withProxyHost(proxyHost)
                .withProxyPort(proxyPortInt)
                .withProxyUsername(proxyUsername)
                .withProxyPassword(proxyPassword)
                .withProxyWorkstation(proxyWorkstation)
                .withProxyDomain(proxyDomain);
    }

}
