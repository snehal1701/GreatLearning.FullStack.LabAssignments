
//API Key to get the Weather info
const api = {
  key: "7e3f21edee540e6110af347b55eb1ab2",
  base: "https://api.openweathermap.org/data/2.5/",
};

let displayMain = document.querySelector("main").style.display;

function getResults(query) {
  document.querySelector("main").style.display = "none";
  console.clear();
  let url = `${api.base}weather?q=${query}&units=metric&appid=${api.key}`;
  fetch(url)
    .then((weather) => weather.json())
    .then((resp) => displayResults(resp))
    .catch((error) => {
      console.log(error);
      alert("City Not Found");
    });
}
function displayResults(weather) {

  if (weather.cod == 404) {
    alert("Invalid City! :- " + weather.message);
    return;
  }
  document.querySelector("main").style.display = "block";
  console.log("displayResults -> ", weather);
  let cityHTML = document.querySelector(".city");
  cityHTML.innerHTML = `${weather.name}`;

  let dateHTML = document.querySelector(".location .date");
  dateHTML.innerHTML = buildDate();

  let temperature = document.querySelector(".current .temp");
  let currentCityTemp = Math.round(weather.main.temp);
  temperature.innerHTML = `${currentCityTemp} <span>&deg;c</span>`;

  //To set the Page gradient depeding on the temperature, as it goes down the Page becomes foggy
  let gradientNum = 1 - ((currentCityTemp - 5) / 10);
  let appWrap = document.querySelector(".app-wrap");
  appWrap.style.backgroundImage = `radial-gradient(circle farthest-corner, rgba(128 , 128, 128, ${gradientNum}) 10%, rgba(0, 0, 0, .5) )`;

  let weather_status = document.querySelector(".current .weather");
  weather_status.innerHTML = weather.weather[0].main;

  let hi_low = document.querySelector(".hi-low");
  let temp_min = Math.round(weather.main.temp_min);
  let temp_max = Math.round(weather.main.temp_max);
  hi_low.innerHTML = `${temp_min} <span>&deg;c</span> / ${temp_max} <span>&deg;c</span>`;
}

function buildDate() {
  let now = new Date();
  let months = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
  ];
  let days = [
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
  ];

  let day = days[now.getDay()];
  let month = months[now.getMonth()];
  let year = now.getFullYear();

  return `${day} ${now.getDate()} ${month} ${year}`;
}

const searchBox = document.querySelector(".search-box");

function checkForEnterAndSubmitQuery(event) {
  //13 -> keycode for ENTER
  if (event.keyCode === 13) {
    getResults(searchBox.value);
  }
}

searchBox.addEventListener("keypress", checkForEnterAndSubmitQuery);