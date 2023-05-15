package io.metaloom.filter;

public enum TestFilterKey implements FilterKey {

	USER_USERNAME("username", String.class);

	private final String key;
	private final Class<String> clazz;

	TestFilterKey(String key, Class<String> clazz) {
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
