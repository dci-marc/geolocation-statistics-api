# Geolocation Statistics API

## Overview

The Geolocation Statistics API is a Spring Boot application designed to manage and provide geolocation statistics. The project is structured into several packages, each responsible for different aspects of the application.

## Project Structure

### `src/main/java/org/dcistudent/geolocationstatisticsapi`

- **factories/model**: Contains factory classes for serializing data models into response models.
  - `SerializerResponseFactory`: Provides methods to serialize `AsnDataModel` and `LogDataModel` into their respective response models.

- **models/data**: Contains data model classes representing the core entities of the application.
  - `AsnDataModel`: Represents an Autonomous System Number (ASN) with associated IP blocks.
  - `IpBlockDataModel`: Represents a range of IP addresses.
  - `LogDataModel`: Represents log data with details such as level, datetime, and message.

- **models/response**: Contains response model classes used for API responses.
  - `AsnResponse`: Represents the response model for ASN data.
  - `LogResponse`: Represents the response model for log data.

### `src/test/java/org/dcistudent/geolocationstatisticsapi`

- **factories/model**: Contains test classes for the factory classes.
  - `SerializerResponseFactoryTest`: Tests the serialization methods of `SerializerResponseFactory`.

- **managers**: Contains test classes for the manager classes.
  - `AsnManagerTest`: Tests the methods of `AsnManager` using mock data.

## Testing

The project uses JUnit 5 for testing, with tests located under the `src/test/java` directory. The tests ensure the correctness of the serialization methods and the functionality of the manager classes.

## Dependencies

The project uses Maven for dependency management. Key dependencies include:
- Spring Boot
- JUnit 5
- AssertJ
- Mockito
- Jackson

## Getting Started

To build and run the project, use the following Maven commands:

```sh
mvn clean install
mvn spring-boot:run
```

To run the tests, use:

```sh
mvn test
```

## License

This project is licensed under the MIT License.
