# LHS Bracket Filter for Java

This library provides a basic implementation to generate and parse filter parameters in LHS bracket format.
The filters may be used when parsing query parameters for filter requests ala `?filter=username[eq]=joedoe`.

Example filters:
```
username[eq]=joedoe
price[gte]=22.42
price[lte]=12.26
date[before]=24-12-2022
date[after]=31-12-2022
```

Please note that this implementation will *not* execute any filters and reduce datasets. Instead it provides the filter so that the parameters can be used to construct for example a SQL query that executes a filtered query.

## Status

This library is still in early development.

## Maven

```xml
<dependency>
	<groupId>io.metaloom.filter</groupId>
	<artifactId>lhs-filter</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

## Usage

```java
// Construct a filter
EqualsFilter<StringFilterValue> filter = ExampleFilterKey.USER_USERNAME.eq("joedoe");
assertEquals("username[eq]=joedoe", filter.toString());

// Parse a filter
List<Filter<?>> parsedFilters = Filter.parse("username[eq]=joedoe", ExampleFilterKey::fromKey);
Filter<?> parsedFilter = parsedFilters.get(0);
assertEquals(ExampleFilterKey.USER_USERNAME, parsedFilter.filterKey());
assertEquals("joedoe", parsedFilter.value());
```

The enum which lists all potential keys to filter by must be defined for your domain.

```java
enum ExampleFilterKey implements FilterKey {

  USER_USERNAME("username", String.class);

  private String key;
  private Class<String> clazz;

  ExampleFilterKey(String key, Class<String> clazz) {
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
```

## Release Process

```bash
# Update maven version to next release
mvn versions:set -DgenerateBackupPoms=false

# Now run tests locally or via GitHub actions
mvn clean package

# Deploy to maven central and auto-close staging repo. 
# Adding the property will trigger the profiles in the parent pom to include gpg,javadoc...
mvn clean deploy -Drelease
```
