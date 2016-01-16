/**
 * 
 */
package com.acme.ads;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.acme.ads.model.Advertisement;
import com.acme.ads.model.NewsPaper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Raju
 * 
 */
@SuppressWarnings("unchecked")
public class AcmeAdsResourceIT {

	private static final String basePath = "http://localhost:7001/acme-ads-service/api/";
	
	@Before
	public void setUp() {
		
	}

	@Test
	public void testCreateNewsPaper() {
		given().contentType(MediaType.APPLICATION_JSON).body(createJsonNewsPaper())
				.expect().statusCode(200).body(equalTo("1")).when().post(basePath+"createnewspaper");
	}
	
	@Test
	public void testCreateExistNewsPaper() {
		given().contentType(MediaType.APPLICATION_JSON).body(createJsonNewsPaper())
				.expect().statusCode(200).body(equalTo("2")).when().post(basePath+"createnewspaper");
	}

	@Test
	public void testCreateAdvertisment() {
		given().contentType(MediaType.APPLICATION_JSON).body(createJsonAdvertisement())
				.expect().statusCode(200).body(equalTo("1")).when().post(basePath+"createadvertisement");
	}
	
	@Test
	public void testCreateExistAdvertisment() {
		given().contentType(MediaType.APPLICATION_JSON).body(createJsonAdvertisement())
				.expect().statusCode(200).body(equalTo("2")).when().post(basePath+"createadvertisement");
	}
	
	@Test
	public void testPublishAdvertisementinNewsPaper(){
		given().contentType(MediaType.APPLICATION_JSON).body(createJsonNewsAdvertisement())
		.expect().statusCode(200).body(equalTo("1")).when().post(basePath+"createnewspaperadvertisment");
	}
	
	@Test
	public void testPublishExistAdvertisementinNewsPaper(){
		given().contentType(MediaType.APPLICATION_JSON).body(createJsonNewsAdvertisement())
		.expect().statusCode(200).body(equalTo("2")).when().post(basePath+"createnewspaperadvertisment");
	}
	
	private int getNewsPaperId() {
		int newsId = 0;
		ClientResponse responseListNews = invokeRestService("newspapers");
		List<NewsPaper> newsPapers = responseListNews.getEntity(new GenericType<List<NewsPaper>>() {
		});
		NewsPaper newsPaper = new NewsPaper();
		newsPaper.setNewsPaperName(TestData.NEWS_PAPER_NAME);
		newsPaper.setContactNbr(TestData.NEWS_PAPER_CONTACT_NBR);
		for(NewsPaper news : newsPapers) {
			if(news.getNewsPaperName().equalsIgnoreCase(newsPaper.getNewsPaperName())) {
				newsId = news.getNewsPaperId();
			}
		}
		return newsId;
	}
	
	private int getAdvId() {
		int advId = 0;
		ClientResponse responseListAdvs = invokeRestService("advertisements");
		List<Advertisement> newsAdvs = responseListAdvs.getEntity(new GenericType<List<Advertisement>>() {
		});
		Advertisement advt = new Advertisement();
		advt.setAdvName(TestData.ADVERTISEMENT_NAME);
		advt.setAdvContactNbr(TestData.ADVERTISEMENT_CONTACT_NBR);
		advt.setAdvDetails(TestData.ADVERTISEMENT_DETAILS);
		for(Advertisement adv : newsAdvs){
			if(adv.getAdvName().equalsIgnoreCase(advt.getAdvName())){
				advId = adv.getAdvId();
			}
		}
		return advId;
	}
	private String createJsonNewsPaper() {
		JSONObject newsObj = new JSONObject();
		newsObj.put("newsPaperName", TestData.NEWS_PAPER_NAME);
		newsObj.put("contactNbr", TestData.NEWS_PAPER_CONTACT_NBR);
		String jsonObj =  newsObj.toJSONString();
		System.out.println(jsonObj);
		return jsonObj;
	}
	
	private String createJsonAdvertisement() {
		JSONObject advObj = new JSONObject();
		advObj.put("advName", TestData.ADVERTISEMENT_NAME);
		advObj.put("advContactNbr", TestData.ADVERTISEMENT_CONTACT_NBR);
		advObj.put("advDetails", TestData.ADVERTISEMENT_DETAILS);
		String jsonObj =  advObj.toJSONString();
		return jsonObj;
	}
	
	private String createJsonNewsAdvertisement() {
		JSONObject newsAdvObj = new JSONObject();
		newsAdvObj.put("newsPaperId", getNewsPaperId());
		newsAdvObj.put("advId", getAdvId());
		String jsonObj =  newsAdvObj.toJSONString();
		return jsonObj;
	}
	private ClientResponse invokeRestService(String resourceName){
		Client client = Client.create();
		WebResource webResource = client.resource(basePath+resourceName);
		ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
		return response;
	}
}
