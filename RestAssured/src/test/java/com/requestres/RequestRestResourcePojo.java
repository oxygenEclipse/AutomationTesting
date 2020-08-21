package com.requestres;

import java.util.List;

public class RequestRestResourcePojo {
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<RequestRestData> data;
	private RequestRestAd ad;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public List<RequestRestData> getData() {
		return data;
	}
	public void setData(List<RequestRestData> data) {
		this.data = data;
	}
	public RequestRestAd getAd() {
		return ad;
	}
	public void setAd(RequestRestAd ad) {
		this.ad = ad;
	}
	
	

}
