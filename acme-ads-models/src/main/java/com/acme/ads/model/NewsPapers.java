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
 * A wrapper class for NewsPaper model.
 * 
 * @author Raju
 */
@XmlRootElement(name = "NewsPapers")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsPapers {

	@XmlElement(name = "NewsPaper")
	private List<NewsPaper> newsPapers = new ArrayList<NewsPaper>();

	public List<NewsPaper> getNewsPaper() {
		return newsPapers;
	}

	public void setNewsPaper(List<NewsPaper> newsPapers) {
		this.newsPapers = newsPapers;
	}
}
