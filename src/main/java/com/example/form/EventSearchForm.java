package com.example.form;

import com.example.common.SearchType;

import java.util.Arrays;

/**
 * Created by daiLlew on 13/10/2015.
 */
public class EventSearchForm {

	private String searchType;
	private String searchValue;
	private SearchType[] searchTypes = SearchType.values();

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public SearchType[] getSearchTypes() {
		return searchTypes;
	}

	public void setSearchTypes(SearchType[] searchTypes) {
		this.searchTypes = searchTypes;
	}

	@Override
	public String toString() {
		return "EventSearchForm{" +
				"searchType=" + searchType +
				", searchValue='" + searchValue + '\'' +
				", searchTypes=" + Arrays.toString(searchTypes) +
				'}';
	}
}
