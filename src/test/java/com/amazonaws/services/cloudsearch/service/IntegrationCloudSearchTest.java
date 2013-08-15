package com.amazonaws.services.cloudsearch.service;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.cloudsearch.model.sdf.Field;
import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentAdd;
import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentFormat;
import com.amazonaws.services.cloudsearch.model.search.SearchResponse;
import com.amazonaws.services.cloudsearch.model.upload.UploadResponse;
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

import static org.junit.Assert.assertNotNull;


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
	 * Find movies matching query.
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

            int start = 20;
            String query = "Star Wars";
            String returnFields = "actor%2Cdirector%2Ctitle%2Cyear%2Ctext_relevance";
            String facet = "genre";
            SearchResponse searchResponse = cloudSearchService.cloudSearchRead(query, returnFields, start, facet);

            System.out.println("Number of searchable documents for " + domainStatus.getDomainName() + " is " + domainStatus.getNumSearchableDocs());
            System.out.println("Found " + searchResponse.getFound().getCount() + " matches for query [" + query + "]");
            System.out.println(searchResponse.getFound().getStart() + " is the start position for query [" + query + "]");
        }

    }

    @Test
    public void cloudSearchActor() {

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

            int start = 0;
            String query = "(and actor:'Carrie Fisher' genre:'Horror')";
            // actor:'-Cushing+Harrison Ford'
            String returnFields = "actor%2Cdirector%2Ctitle%2Cyear%2Ctext_relevance";
            String facet = "genre";
            SearchResponse searchResponse = cloudSearchService.cloudSearchBooleanQuery(query, returnFields, start, facet);

            System.out.println("Number of searchable documents for " + domainStatus.getDomainName() + " is " + domainStatus.getNumSearchableDocs());
            System.out.println("Found " + searchResponse.getFound().getCount() + " matches for query [" + query + "]");
            System.out.println(searchResponse.getFound().getStart() + " is the start position for query [" + query + "]");
        }

    }

    @Test
    public void cloudSearchBooleanQuery() {

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

            int start = 20;
            String query = "(and director:'Lucas|Spielberg' (not actor:'\"Ford, Harrison\"'))";
            String returnFields = "actor%2Cdirector%2Ctitle%2Cyear%2Ctext_relevance";
            String facet = "genre";
            SearchResponse searchResponse = cloudSearchService.cloudSearchBooleanQuery(query, returnFields, start, facet);

            System.out.println("Number of searchable documents for " + domainStatus.getDomainName() + " is " + domainStatus.getNumSearchableDocs());
            System.out.println("Found " + searchResponse.getFound().getCount() + " matches for query [" + query + "]");
            System.out.println(searchResponse.getFound().getStart() + " is the start position for query [" + query + "]");
        }

    }

    @Test
    public void cloudSearchPostSdf() {

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

            SearchDocumentFormat item = new SearchDocumentFormat();
            List<SearchDocumentAdd> documents = new ArrayList<SearchDocumentAdd>();
            List<Field> fields = new ArrayList<Field>();

            Field title = new Field();
            title.setName("title");
            title.setValue("The Seeker: The Dark Is Rising");
            fields.add(title);

            Field director = new Field();
            title.setName("director");
            title.setValue("Cunningham, David L.");
            fields.add(director);

            Field year = new Field();
            title.setName("year");
            title.setValue("2007");
            fields.add(year);

            Field genre = new Field();
            title.setName("year");
            title.setValue("2007");
            fields.add(genre);

            SearchDocumentAdd z = new SearchDocumentAdd();
            z.setId("tt0484562");
            z.setVersion("2");
            z.setFields(fields);
            documents.add(z);

            item.setSearchDocumentAdds(documents);

//            [{
//                "type": "add",
//                        "id": "tt0484562",
//                        "version": 2,
//                        "lang": "en",
//                        "fields": {
//                    "title": "The Seeker: The Dark Is Rising",
//                            "director": "Cunningham, David L.",
//                            "year": 2007,
//                            "genre": ["Adventure", "Drama", "Fantasy", "Thriller"],
//                    "actor": ["McShane, Ian", "Eccleston, Christopher", "Conroy, Frances", "Ludwig, Alexander", "Crewson, Wendy", "Warner, Amelia", "Cosmo, James", "Hickey, John Benjamin", "Piddock, Jim", "Lockhart, Emma"]
//                }
//            }]

            UploadResponse result = cloudSearchService.batch(item);

            assertNotNull(result);
        }
    }

}
