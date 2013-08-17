package com.amazonaws.services.cloudsearch.service;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.cloudsearch.common.json.JsonUtils;
import com.amazonaws.services.cloudsearch.model.sdf.Field;
import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentAdd;
import com.amazonaws.services.cloudsearch.model.sdf.SearchDocumentFormat;
import com.amazonaws.services.cloudsearch.model.search.SearchResponse;
import com.amazonaws.services.cloudsearch.model.upload.UploadResponse;
import com.google.common.collect.ImmutableList;
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

import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    private static Logger LOG = Logger.getLogger(IntegrationCloudSearchTest.class);

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

            String query = "Star Wars";
            String returnFields = "actor%2Cdirector%2Ctitle%2Cyear%2Ctext_relevance";
            String facet = "genre";

            System.out.println("Number of searchable documents for " + domainStatus.getDomainName() + " is " + domainStatus.getNumSearchableDocs());
            for(int start = 0; start < 10000; start=start+10) {

                SearchResponse searchResponse = cloudSearchService.cloudSearchRead(query, returnFields, start, facet);

                int count = searchResponse.getFound().getCount();
                int hits = searchResponse.getFound().getHits().size();
                System.out.println("Start position " + start + ". Found " + hits + " of " + count + " matches for query [" + query + "]");
                if ((start + 10) > count || hits == 0) {
                    break;
                }

            }

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

            System.out.println("Number of searchable documents for " + domainStatus.getDomainName() + " is " + domainStatus.getNumSearchableDocs());
            int start = 0;
            String query = "(and actor:'Carrie Fisher' genre:'Horror')";
            // actor:'-Cushing+Harrison Ford'
            String returnFields = "actor%2Cdirector%2Ctitle%2Cyear%2Ctext_relevance";
            String facet = "genre";
            SearchResponse searchResponse = cloudSearchService.cloudSearchBooleanQuery(query, returnFields, start, facet);

            int count = searchResponse.getFound().getCount();
            int hits = searchResponse.getFound().getHits().size();
            System.out.println("Start position " + start + ". Found " + hits + " of " + count + " matches for query [" + query + "]");
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

            String query = "(and director:'Lucas|Spielberg' (not actor:'\"Ford, Harrison\"'))";
            String returnFields = "actor%2Cdirector%2Ctitle%2Cyear%2Ctext_relevance";
            String facet = "genre";

            System.out.println("Number of searchable documents for " + domainStatus.getDomainName() + " is " + domainStatus.getNumSearchableDocs());
            for(int start = 0; start < 10000; start=start+10) {
                SearchResponse searchResponse = cloudSearchService.cloudSearchBooleanQuery(query, returnFields, start, facet);
                int count = searchResponse.getFound().getCount();
                int hits = searchResponse.getFound().getHits().size();
                System.out.println("Start position " + start + ". Found " + hits + " of " + count + " matches for query [" + query + "]");

                if ((start + 10) > count || hits == 0) {
                    break;
                }
            }
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

            Field fields = new Field();
            fields.setTitle("The Seeker: The Dark Is Rising");
            fields.setDirector("Cunningham, David L.");
            fields.setYear(Integer.valueOf(2007));
            fields.setGenre(ImmutableList.of("Adventure","Drama","Fantasy","Thriller"));
            fields.setActor(ImmutableList.of("McShane, Ian","Eccleston, Christopher","Conroy, Frances","Ludwig, Alexander","Crewson, Wendy","Warner, Amelia","Cosmo, James","Hickey, John Benjamin","Piddock, Jim","Lockhart, Emma"));

            Field fields2 = new Field();
            fields2.setTitle("Emma");
            fields2.setDirector("McGrath, Douglas");
            fields2.setYear(Integer.valueOf(1996));
            fields2.setGenre(ImmutableList.of("Comedy","Romance"));
            fields2.setActor(ImmutableList.of("Paltrow, Gwyneth","Cumming, Alan","Collette, Toni","Northam, Jeremy","Scacchi, Greta","Cosmo, James","Thompson, Sophie","Law, Phyllida","Boardman, Lee","Byron, Kathleen","Hawthorne, Denys"));

            SearchDocumentAdd z = new SearchDocumentAdd();
            z.setId("tt0484562");
            z.setVersion("2");
            z.setLang("en");
            z.setFields(fields);

            SearchDocumentAdd z2 = new SearchDocumentAdd();
            z2.setId("tt0116191");
            z2.setVersion("2");
            z2.setLang("en");
            z2.setFields(fields2);

            documents.add(z);
            documents.add(z2);

            item.setSearchDocumentAdds(documents);

            LOG.debug("SDF Batch Upload Request : " + JsonUtils.marshal(item.getSearchDocumentAdds()));

            UploadResponse result = cloudSearchService.batch(item);

            LOG.debug("SDF Batch Upload Response : " + JsonUtils.marshal(result));

            assertNotNull(result);
            assertEquals("success", result.getStatus());
            assertTrue(result.getAdds() == 2);
            assertTrue(result.getDeletes() == 0);
            assertTrue(result.getErrors().size() == 0);
            assertTrue(result.getWarnings().size() == 0);

        }
    }

}
