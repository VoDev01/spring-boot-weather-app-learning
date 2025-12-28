import IndexLayout from "./layout";
import moment from 'moment';
import Image from "next/image";

export default async function Index() {

  let response = await fetch("http://backend:8080/api/weather/fetch");
  let weatherData = await response.json();

  return (
    <IndexLayout>
      <h1>Current weather as of {moment().format("MMMM D")}</h1>
      <p>{weatherData.city}</p>
      <div className="d-flex flex-row">
        <div className="mx-3">
          {weatherData.weather && (
            <Image src={"https://yastatic.net/weather/i/icons/funky/dark/" + weatherData.weather.icon + ".svg"} width={100} height={100} alt="Weather icon" />
          )}
          {weatherData.weather && (
            <p>{weatherData.weather.temp} Celcius</p>
          )}
          {weatherData.weather && (
            <p>Feels like {weatherData.weather.feels_like}</p>
          )}
        </div>
        <div className="mx-3">
          {weatherData.weather && (
            <p>Wind speed {weatherData.weather.wind_speed} m/s</p>
          )}
          {weatherData.weather && (
            <p>Wind direction {weatherData.weather.wind_dir}</p>
          )}
        </div>
        <div className="mx-3">
          {weatherData.weather && (
             <Image src={"https://yastatic.net/weather/i/icons/funky/dark/" + weatherData.weather.phenom_icon + ".svg"} width={100} height={100} alt="Condition icon" />
          )}
          {weatherData.weather && (
            <p>Condition {weatherData.weather.phenom_condition}</p>
          )}
        </div>
      </div>
    </IndexLayout>
  );
}
