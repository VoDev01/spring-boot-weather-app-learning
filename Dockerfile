# syntax=docker/dockerfile:1

FROM amazoncorretto:25-alpine

WORKDIR /weather_app

COPY ./build/libs/weather_app-0.0.1-SNAPSHOT.jar .
ENV YANDEX_WEATHER_API_KEY=02defa46-571a-44bb-a781-04d77eb75d9a

CMD ["java", "-jar", "/weather_app/weather_app-0.0.1-SNAPSHOT.jar", "-DYANDEX_WEATHER_API_KEY", "=", "${YANDEX_WEATHER_API_KEY}"]