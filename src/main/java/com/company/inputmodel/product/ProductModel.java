package com.company.inputmodel.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductModel {

	@JsonProperty(value="UID",required=true)
	private String uid;
	
	@JsonProperty(value="USERNAME",required=true)
	private String username;
	
	@JsonProperty(value="PASSWORD",required=true)
	private String password;
	
	@JsonProperty(value="URL", required=true)
	private String linkUrl;
	
	@JsonProperty(value="PRODUCT-VERSION", required=true)
	private String productVersion;
	
	@JsonProperty(value="Automation-Rest-port")
	private int restPort = -1;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	public int getRestPort() {
		return restPort;
	}

	public void setRestPort(int restPort) {
		this.restPort = restPort;
	}

	
}
