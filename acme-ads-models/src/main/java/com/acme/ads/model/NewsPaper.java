/**
 * 
 */
package com.acme.ads.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * NewsPaper model class.
 * 
 * @author Raju
 */
@XmlRootElement
public class NewsPaper {

	private int newsPaperId;

	private String newsPaperName;

	private String contactNbr;

	public String getContactNbr() {
		return contactNbr;
	}

	public void setContactNbr(String contactNbr) {
		this.contactNbr = contactNbr;
	}

	public int getNewsPaperId() {
		return newsPaperId;
	}

	public void setNewsPaperId(int newsPaperId) {
		this.newsPaperId = newsPaperId;
	}

	public String getNewsPaperName() {
		return newsPaperName;
	}

	public void setNewsPaperName(String newsPaperName) {
		this.newsPaperName = newsPaperName;
	}

	@Override
	public boolean equals(Object object) {
		if (object != null && object instanceof NewsPaper) {
			NewsPaper obj = (NewsPaper) object;
			if (obj.getNewsPaperName().equalsIgnoreCase(newsPaperName)) {
				return true;
			}
		}
		return false;
	}

}
