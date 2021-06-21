package com.assignment1.WeatherAutomation;

import com.assignment1.library.BaseTest;
import com.assignment1.pages.Weather;
import com.assignment1.pages.WeatherFields;
import com.assignment1.restAssured.model.Message;
import com.assignment1.utility.UtilityMethods;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.page;
import static com.jayway.restassured.RestAssured.given;
import static com.codeborne.selenide.Selenide.open;
import java.util.Properties;

public class WeatherComparisonUI_API extends BaseTest {
	UtilityMethods util = new UtilityMethods();
	String conditionUI;
	String humidityUI;
	String windUI;
	double tempUICelsius;
	double tempUIFah;
	double tempAPICelsius;
	double tempAPIFah;
	String humidAPI;
	Properties prop;
	Weather weatherPage;
	@Test
	public void launchURL() throws InterruptedException {
		prop = new Properties();
		prop = UtilityMethods.OpenProperties("src/test/java/resources/env.properties");
		open(prop.get("URL").toString());
		weatherPage = page(Weather.class);
		weatherPage.clickNavIcon();
	}

	@Test(dependsOnMethods = "launchURL")
	@Parameters({ "city" })
	public void validateWeatherCity(String city) throws InterruptedException {
		weatherPage = page(Weather.class);
		weatherPage.clickNavItem("WEATHER");
		weatherPage.sendCity(city);
		weatherPage.clickCityCheckbox(city);
		Thread.sleep(5000);
		weatherPage.validateWeatherCityOnMap(city);
		weatherPage.clickWeatherCity(city);
		weatherPage.validateWeatherLeaflet(city);
	}

	@Test(dependsOnMethods = "validateWeatherCity")
	@Parameters({ "city" })
	public void getWeatherData(String city) {
		weatherPage = page(Weather.class);
		conditionUI = weatherPage.getWeatherCondition(city);
		humidityUI = weatherPage.getWeatherHumidity(city);
		windUI = weatherPage.getWeatherWind(city);
		tempUICelsius = weatherPage.getWeatherTempDegree(city);
		tempUIFah = weatherPage.getWeatherTempFahrenheit(city);
		Reporter.log(city + " Weather Condition : " + conditionUI, true);
		Reporter.log(city + " Humidity : " + humidityUI, true);
		Reporter.log(city + " Wind : " + windUI, true);
		Reporter.log(city + " Temperature in Fahrenheit : " + tempUIFah, true);
		Reporter.log(city + " Temperature in Celsius from UI :::: " + tempUICelsius, true);
	}

	@Test(dependsOnMethods = "getWeatherData")
	public void closeWeatherLeaflet() {
		weatherPage = page(Weather.class);
		weatherPage.clickLeafletClose();
		Reporter.log("Weather Validation on UI Successful..", true);
	}

	@Test(dependsOnMethods = "closeWeatherLeaflet")
	@Parameters({ "city" })
	public void validateWeatherAPI(String city) {
		String appidValue = "e72c7be33562a4d824862a5e6717d4f9";
		String cityValue = city;
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		String url = "https://api.openweathermap.org/data/2.5/weather";
		Response response = given().that().queryParam("appid", appidValue).and().queryParam("q", cityValue).when()
				.get(url).andReturn();
		String res = response.getBody().asString();
		int resCode = response.getStatusCode();
		Reporter.log("The response Body is " + res, true);
		Assert.assertEquals(resCode, 200);
		Reporter.log("The response Code is " + resCode, true);
		Message message = util.getMessages(response);
		double tempAPIKelvin = message.getMain().getTemp();
		tempAPICelsius = util.convertKelvinToDegree(tempAPIKelvin);
		Reporter.log("Temperature in Celsius from API ::::" + tempAPICelsius, true);
		Reporter.log("Weather Validation from API Successful..", true);
	}

	@Test(dependsOnMethods = "validateWeatherAPI")
	public void compareWeatherUIAPI() {
		WeatherFields weatherUI = new WeatherFields();
		WeatherFields weatherAPI = new WeatherFields();
		weatherUI.setCelsius(tempUICelsius);
		weatherUI.setFahrenheit(tempUIFah);
		weatherUI.setHumidity(humidityUI);
		weatherUI.setWind(windUI);
		weatherAPI.setCelsius(tempAPICelsius);
		String[] tempCelsiusMagnitudes = prop.getProperty("difference").split(",");
		double actualDifference = 0.0;
		for (String ele : tempCelsiusMagnitudes) {
			double diff = Double.parseDouble(ele);
			Reporter.log("difference from prop file : " + ele, true);
			actualDifference = Math.abs(weatherUI.getCelsius() - weatherAPI.getCelsius());
			Assert.assertTrue(actualDifference <= diff, "Actual Difference: " + actualDifference + "************"
					+ " Difference of Temperature in Degree is not within magnitude specified");
		}
		Reporter.log("Actual Difference: " + actualDifference, true);
		Reporter.log("Comparison Validation completed successfully..",true);
	}
}
