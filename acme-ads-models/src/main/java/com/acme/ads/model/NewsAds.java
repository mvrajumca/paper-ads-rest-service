/**
 * 
 */
package com.acme.ads.model;

/**
 * Advertisement NewsPaper mapping model.
 * 
 * @author Raju
 */
public class NewsAds {

	private int newsPaperId;

	private int advId;

	public int getNewsPaperId() {
		return newsPaperId;
	}

	public void setNewsPaperId(int newsPaperId) {
		this.newsPaperId = newsPaperId;
	}

	public int getAdvId() {
		return advId;
	}

	public void setAdvId(int advId) {
		this.advId = advId;
	}

	@Override
	public boolean equals(Object object) {
		if (object != null && object instanceof NewsAds) {
			NewsAds obj = (NewsAds) object;
			if (obj.getAdvId() == advId && obj.getNewsPaperId() == newsPaperId) {
				return true;
			}
		}
		return false;
	}
}
