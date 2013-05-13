package com.amazonaws.services.cloudsearch.service;

import java.util.List;

import com.amazonaws.services.cloudsearch.model.search.SearchResponse;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.cloudsearch.AmazonCloudSearchClient;
import com.amazonaws.services.cloudsearch.model.DescribeDomainsResult;
import com.amazonaws.services.cloudsearch.model.DomainStatus;

/**
 * A suite of tests for calling the TIA REST endpoint.
 * 
 * @author Phillip Read
 */
@ActiveProfiles("development")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:META-INF/spring/root-context.xml",
		"classpath*:META-INF/spring/applicationContext*.xml" })
public class IntegrationCloudSearchTest {

    @Autowired(required=true)
    @Qualifier("cloudSearchClient")
    private AmazonCloudSearchClient cloudSearch;

    @Autowired(required=true)
    @Qualifier("cloudSearchService")
    private CloudSearchService cloudSearchService;

    private static final String DOMAIN_MOVIES = "imdb-movies";

	/**
	 * Find brands.
	 */
	@Test
    public void cloudSearch() {

        DescribeDomainsResult domains = cloudSearch.describeDomains();
        List<DomainStatus> list = domains.getDomainStatusList();

        DomainStatus domainStatus = null;
        for(DomainStatus i : list) {
            if (StringUtils.equals(DOMAIN_MOVIES, i.getDomainName())) {
                domainStatus = i;
                break;
            }
        }

        if (null != domainStatus) {

            String query = "Star Wars";
            String returnFields = "actor%2Cdirector%2Ctitle%2Cyear%2Ctext_relevance";
            String facet = "genre";
            SearchResponse searchResponse = cloudSearchService.cloudSearchRead(query, returnFields, facet);

            System.out.println("Number of searchable documents for " + domainStatus.getDomainName() + " is " + domainStatus.getNumSearchableDocs());
            System.out.println("Found " + searchResponse.getFound().getCount() + " matches for query [" + query + "]");
        }

    }

}
