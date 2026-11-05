# sample-sb-3-5-with-twilio-12

Sends a text message over REST.

## Stack

- Spring Boot 3.5.16
- Java 21
- Gradle 8.14.5
- Twilio 12.1.1

## Build

```
./gradlew build
```

## Run

```
./gradlew bootRun
```

Set `TWILIO_ACCOUNT_SID`, `TWILIO_AUTH_TOKEN` and `TWILIO_FROM_NUMBER` first.

```
curl -X POST localhost:8080/texts -d to=+15550002222 -d body=hello
```
