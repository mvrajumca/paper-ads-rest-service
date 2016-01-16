package com.acme.ads;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.acme.ads.dao.AcmeAdsDao;
import com.acme.ads.model.Advertisement;
import com.acme.ads.model.NewsAds;
import com.acme.ads.model.NewsPaper;

/**
 * This class is the REST service component. It accepts the JSON requests and
 * responds with JSON / XML response.
 * 
 * @author Raju
 */
@Named
@Path("/api")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AcmeAdsResource {
	@Inject
	AcmeAdsDao acmeAdsDaoImpl;

	/**
	 * This resource creates news paper.
	 * 
	 * @param newsPaper
	 * @return int
	 * @throws Exception
	 */
	@POST
	@Path("/createnewspaper")
	public int createNewsPaper(NewsPaper newsPaper) throws Exception {
		return acmeAdsDaoImpl.createNewsPaper(newsPaper);
	}

	/**
	 * This resource retrieves the existing newspapers.
	 * 
	 * @return List<NewsPaper>
	 * @throws Exception
	 */
	@GET
	@Path("/newspapers")
	public List<NewsPaper> getNewsPapers() throws Exception {
		return acmeAdsDaoImpl.getNewsPapers();
	}

	/**
	 * This resource creates the advertisement.
	 * 
	 * @param advertisement
	 * @return int
	 * @throws Exception
	 */
	@POST
	@Path("/createadvertisement")
	public int createAdvertisement(Advertisement advertisement)
			throws Exception {
		return acmeAdsDaoImpl.createAdvertisement(advertisement);
	}

	/**
	 * This resource retrieves the advertisements.
	 * 
	 * @return List<Advertisement>
	 * @throws Exception
	 */
	@GET
	@Path("/advertisements")
	public List<Advertisement> getAdvertisements() throws Exception {
		return acmeAdsDaoImpl.getAdvertisements();
	}

	/**
	 * This resource creates the newspaper and advertisment mapping.
	 * 
	 * @param newsAd
	 * @return int
	 * @throws Exception
	 */
	@POST
	@Path("/createnewspaperadvertisment")
	public int createNewsAdvertisement(NewsAds newsAd) throws Exception {
		return acmeAdsDaoImpl.createNewsAds(newsAd);
	}

	/**
	 * This resource retrieves the advertisement and newspaper mappings.
	 * 
	 * @return List<NewsAds>
	 * @throws Exception
	 */
	@GET
	@Path("/newspapersads")
	public List<NewsAds> getNewsPaperAdvertisement() throws Exception {
		return acmeAdsDaoImpl.getNewsAds();
	}
}
