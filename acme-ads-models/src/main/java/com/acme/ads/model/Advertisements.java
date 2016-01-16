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
 * A wrapper class to create/retrieve list of Advertisement objects.
 * 
 * @author Raju
 */
@XmlRootElement(name = "Advertisements")
@XmlAccessorType(XmlAccessType.FIELD)
public class Advertisements {

	@XmlElement(name = "Advertisement")
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}
}
