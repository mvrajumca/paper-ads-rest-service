/**
 * 
 */
package com.acme.ads.model;

/**
 * Advertisement model class.
 * 
 * @author Raju
 */
public class Advertisement {

	private int advId;

	private String advName;

	private String advDetails;

	private String advContactNbr;

	public String getAdvContactNbr() {
		return advContactNbr;
	}

	public void setAdvContactNbr(String advContactNbr) {
		this.advContactNbr = advContactNbr;
	}

	public int getAdvId() {
		return advId;
	}

	public void setAdvId(int advId) {
		this.advId = advId;
	}

	public String getAdvName() {
		return advName;
	}

	public void setAdvName(String advName) {
		this.advName = advName;
	}

	public String getAdvDetails() {
		return advDetails;
	}

	public void setAdvDetails(String advDetails) {
		this.advDetails = advDetails;
	}

	@Override
	public boolean equals(Object object) {
		if (object != null && object instanceof Advertisement) {
			Advertisement obj = (Advertisement) object;
			if (obj.getAdvName().equalsIgnoreCase(advName)) {
				return true;
			}
		}
		return false;
	}
}
