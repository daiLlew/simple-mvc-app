package com.example.common;

/**
 * Created by daiLlew on 13/10/2015.
 */
public enum SearchType {

	DEFAUL_SEARCH("default.search"),

	SEARCH_BY_BAND_NAME("search.band.name"),

	SEARCH_BY_VENUE_NAME("search.venue.name"),

	SEARCH_BY_CITY_NAME("search.city.name");

	private final String type;

	SearchType(String value) {
		this.type = value;
	}

	public String getType() {
		return this.type;
	}

	public String getName() {
		return this.name();
	}

	public static SearchType toSearchType(String value) {
		for (SearchType st : values()) {
			if (value.equals(st.getName())) {
				return st;
			}
		}
		// TODO fix this.
		return null;
	}

}
