package com.assignment1.pages;

import static com.codeborne.selenide.Selenide.actions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import java.util.HashMap;
import java.util.Map;

public class Weather {
	@FindBy(xpath = "//a[@class='topnavmore']")
	private SelenideElement NavMenuIcon;

	@FindBy(id = "map_canvas")
	private SelenideElement WeatherPage;

	@FindBy(xpath = "//input[@id='searchBox']")
	private SelenideElement WeatherPageSearchBox;

	@FindBy(xpath = "//div[@class='leaflet-popup-content']")
	private SelenideElement CityWeatherLeaflet;

	@FindBy(xpath = "//a[@class='leaflet-popup-close-button']")
	private SelenideElement CityWeatherLeafletCloseIcon;

	@FindBy(xpath = "//div[@class='leaflet-popup-content']//b[contains(text(),'Wind')]")
	private SelenideElement WeatherWindInfo;

	@FindBy(xpath = "//div[@class='leaflet-popup-content']//b[contains(text(),'Condition')]")
	private SelenideElement WeatherConditionInfo;

	@FindBy(xpath = "//div[@class='leaflet-popup-content']//b[contains(text(),'Humidity')]")
	private SelenideElement WeatherHumidityInfo;

	@FindBy(xpath = "//div[@class='leaflet-popup-content']//b[contains(text(),'Degrees')]")
	private SelenideElement WeatherTempInDegrees;

	@FindBy(xpath = "//div[@class='leaflet-popup-content']//b[contains(text(),'Fahrenheit')]")
	private SelenideElement WeatherTempInFahrenheit;

	String[] fahrenheit;
	String[] degree;
	String[] humid;
	String[] condition;
	String[] wind;

	public void clickNavIcon() {
		NavMenuIcon.shouldBe(Condition.visible).click();
	}

	public void clickNavItem(String item) {
		$(By.xpath("//a[text()='" + item + "']")).shouldBe(Condition.visible).click();
		Assert.assertTrue("Weather Page not displayed", WeatherPage.shouldBe(Condition.visible).isDisplayed());
	}

	public void sendCity(String city) {
		WeatherPageSearchBox.shouldBe(Condition.visible).sendKeys(city);
	}

	public void clickCityCheckbox(String city) {
		SelenideElement ele = $(By.xpath("//input[@id='" + city + "']"));
		if (ele.isSelected() != true) {
			ele.shouldBe(Condition.visible).click();
		} else
			Reporter.log(city + " already selected..", true);
	}

	public void validateWeatherCityOnMap(String city) {
		SelenideElement weatherCityName = $(
				By.xpath("//div[@class='outerContainer']//div[@class='cityText' and text()='" + city + "']"));
		Assert.assertEquals(city, weatherCityName.getText());
		Reporter.log("Expected City: " + city + "Actual City: " + weatherCityName.getText(), true);
	}

	public void clickWeatherCity(String city) {
		SelenideElement weatherCityName = $(
				By.xpath("//div[@class='outerContainer']//div[@class='cityText' and text()='" + city + "']"));
		weatherCityName.click();
	}

	public void validateWeatherLeaflet(String city) {
		SelenideElement leafletPlace = $(
				By.xpath("//div[@class='leaflet-popup-content']//span[contains(text(),'" + city + "')]"));
		Assert.assertTrue("Expected :" + city + "******* Actual :" + leafletPlace.getText(),
				leafletPlace.getText().contains(city));
	}

	public String getWeatherCondition(String city) {
		SelenideElement cityWeatherLeaflet = $(
				By.xpath("//span[contains(text(),'" + city + "')]/ancestor::div[@class='leaflet-popup-content']"));
		if (cityWeatherLeaflet.isDisplayed()) {
			Assert.assertTrue("Condition Info not displayed",
					WeatherConditionInfo.shouldBe(Condition.visible).isDisplayed());
		}
		condition = WeatherConditionInfo.getText().split(":");
		return condition[1];
	}

	public String getWeatherWind(String city) {
		SelenideElement cityWeatherLeaflet = $(
				By.xpath("//span[contains(text(),'" + city + "')]/ancestor::div[@class='leaflet-popup-content']"));
		if (cityWeatherLeaflet.isDisplayed()) {
			Assert.assertTrue("Wind Info not displayed", WeatherWindInfo.shouldBe(Condition.visible).isDisplayed());
		}
		wind = WeatherWindInfo.getText().split(":");
		return wind[1];
	}

	public String getWeatherHumidity(String city) {
		SelenideElement cityWeatherLeaflet = $(
				By.xpath("//span[contains(text(),'" + city + "')]/ancestor::div[@class='leaflet-popup-content']"));
		if (cityWeatherLeaflet.isDisplayed()) {
			Assert.assertTrue("Humidity Info not displayed",
					WeatherHumidityInfo.shouldBe(Condition.visible).isDisplayed());
		}
		humid = WeatherHumidityInfo.getText().split(":");
		String[] humidvalue = humid[1].split("%");
		return humidvalue[0];
	}

	public double getWeatherTempDegree(String city) {
		SelenideElement cityWeatherLeaflet = $(
				By.xpath("//span[contains(text(),'" + city + "')]/ancestor::div[@class='leaflet-popup-content']"));
		if (cityWeatherLeaflet.isDisplayed()) {
			Assert.assertTrue("Humidity Info not displayed",
					WeatherTempInDegrees.shouldBe(Condition.visible).isDisplayed());
		}
		degree = WeatherTempInDegrees.getText().split(":");
		String TempDegreevalue = degree[1];
		double i = Double.parseDouble(TempDegreevalue);
		return i;
	}

	public double getWeatherTempFahrenheit(String city) {
		SelenideElement cityWeatherLeaflet = $(
				By.xpath("//span[contains(text(),'" + city + "')]/ancestor::div[@class='leaflet-popup-content']"));
		if (cityWeatherLeaflet.isDisplayed()) {
			Assert.assertTrue("Humidity Info not displayed",
					WeatherTempInFahrenheit.shouldBe(Condition.visible).isDisplayed());
		}
		fahrenheit = WeatherTempInFahrenheit.getText().split(":");
		Reporter.log(fahrenheit[1], true);
		String value = fahrenheit[1];
		double i = Double.parseDouble(value);
		return i;
	}

	public void clickLeafletClose() {
		CityWeatherLeafletCloseIcon.shouldBe(Condition.visible).click();
	}

}
