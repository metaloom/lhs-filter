package io.metaloom.filter;

public enum TestFilterKey implements FilterKey {

	USER_USERNAME("username", String.class),

	ARTICLE_PRICE("price", Double.class);

	private final String key;
	private final Class<?> clazz;

	TestFilterKey(String key, Class<?> clazz) {
		this.key = key;
		this.clazz = clazz;
	}

	@Override
	public String key() {
		return key;
	}

	static FilterKey fromKey(String key) {
		for (FilterKey v : values()) {
			if (v.key().equals(key)) {
				return v;
			}
		}
		return null;
	}
}
