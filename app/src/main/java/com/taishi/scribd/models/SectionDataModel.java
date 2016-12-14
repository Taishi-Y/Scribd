package com.taishi.scribd.models;

import com.taishi.scribd.models.book.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yamasakitaishi on 2016/11/24.
 */

public class SectionDataModel {

	private String headerTitle;
	private List<Item> allItemsInSection;


	public SectionDataModel() {

	}
	public SectionDataModel(String headerTitle, List<Item> allItemsInSection) {
		this.headerTitle = headerTitle;
		this.allItemsInSection = allItemsInSection;
	}



	public String getHeaderTitle() {
		return headerTitle;
	}

	public void setHeaderTitle(String headerTitle) {
		this.headerTitle = headerTitle;
	}


	public List<Item> getAllItemsInSection() {
		return allItemsInSection;
	}

	public void setAllItemsInSection(List<Item> allItemsInSection) {
		this.allItemsInSection = allItemsInSection;
	}


}