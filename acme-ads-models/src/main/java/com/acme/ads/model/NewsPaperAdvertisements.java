/**
 * 
 */
package com.acme.ads.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A wrapper class for NewsPaper and Advertisement mappings.
 * 
 * @author Raju
 */
@XmlRootElement(name = "NewsPaperAdvertisements")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsPaperAdvertisements {

	@XmlElement(name = "NewsPaperAdvertisement")
	private List<NewsAds> newsPaperAds = new ArrayList<NewsAds>();

	public List<NewsAds> getNewsPaperAds() {
		return newsPaperAds;
	}

	public void setNewsPaperAds(List<NewsAds> newsPaperAds) {
		this.newsPaperAds = newsPaperAds;
	}
}
