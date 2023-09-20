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
// Define the filter keys
StringFilterKey USER_USERNAME = new StringFilterKey("username");
LocalTimeFilterKey CREATE_DATE = new LocalTimeFilterKey("created");
SizeFilterKey FILE_SIZE = new SizeFilterKey("size");

// Construct a filter
ValueFilter filter1 = USER_USERNAME.eq("joedoe");
assertEquals("username[eq]=joedoe", filter1.toString());

ValueFilter filter2 = CREATE_DATE.after(LocalTime.parse("13:37"));
assertEquals("created[after]=13:37", filter2.toString());

ValueFilter filter3 = FILE_SIZE.gte("12 GB");
assertEquals("size[gte]=12GB", filter3.toString());

// Register the keys in the parser
LHSFilterParser parser = new LHSFilterParserImpl();
parser.register(USER_USERNAME);
parser.register(CREATE_DATE);
parser.register(FILE_SIZE);

// Parse a filter string
String queryLine = "username[eq]=joedoe,size[range]=1GB_42GB";
List<Filter> parsedFilters = parser.parse(queryLine);
for (Filter filter : parsedFilters) {
  FilterKey key = filter.filterKey();
  if (key == USER_USERNAME) {
    System.out.println("Filter by username: " + filter.valueStr());
  } else if (key == FILE_SIZE && filter instanceof RangeFilter r && r.value() instanceof SizeRangeFilterValue rv) {
    System.out.println("Filter by size range: " + rv.getFrom() + " to " + rv.getTo() + " bytes");
  } else {
    throw new RuntimeException("Unknown filter " + filter.filterKey().id());
  }

  if (filter.matches(USER_USERNAME, Operation.EQUALS)) {
    String result = filter.apply(StringFilterValue.class, sv -> {
      return "blub";
    });
    System.out.println("Result: " + result);
  }
}
Filter parsedFilter = parsedFilters.get(0);
assertEquals(USER_USERNAME, parsedFilter.filterKey());
StringFilterValue value = parsedFilter.value();
assertEquals("joedoe", value.toString());
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
