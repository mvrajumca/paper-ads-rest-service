package com.acme.ads.dao;

import java.util.List;

import com.acme.ads.model.Advertisement;
import com.acme.ads.model.NewsAds;
import com.acme.ads.model.NewsPaper;

public interface AcmeAdsDao {

	/**
	 * This method is used to create the newspaper.
	 * 
	 * @param newsPaper
	 * @return int
	 * @throws Exception
	 */
	public int createNewsPaper(NewsPaper newsPaper) throws Exception;

	/**
	 * This method is used to retrieve the NewsPapers.
	 * 
	 * @return List<NewsPaper>
	 * @throws Exception
	 */
	public List<NewsPaper> getNewsPapers() throws Exception;

	/**
	 * This method is used to create the advertisement.
	 * 
	 * @param advertisement
	 * @return int
	 * @throws Exception
	 */
	public int createAdvertisement(Advertisement advertisement)
			throws Exception;

	/**
	 * This method is used to retrieve the available advertisements.
	 * 
	 * @return List<Advertisement>
	 * @throws Exception
	 */
	public List<Advertisement> getAdvertisements() throws Exception;

	/**
	 * This method creates the newspaper and advertisement mapping.
	 * 
	 * @param newsAd
	 * @return int
	 * @throws Exception
	 */
	public int createNewsAds(NewsAds newsAd) throws Exception;

	/**
	 * This method retrieves the newspaper and advertisement mappings.
	 * 
	 * @return List<NewsAds>
	 * @throws Exception
	 */
	public List<NewsAds> getNewsAds() throws Exception;
}
