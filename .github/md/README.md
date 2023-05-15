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
	<version>${project.version}</version>
</dependency>
```

## Usage

```java
%{snippet|id=example|file=src/test/java/io/metaloom/filter/BasicUsageExampleTest.java}
```

The enum which lists all potential keys to filter by must be defined for your domain.

```java
%{snippet|id=key|file=src/test/java/io/metaloom/filter/BasicUsageExampleTest.java}
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