package com.assignment1.utility;

import java.io.FileInputStream;
import java.lang.reflect.Type; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

import com.assignment1.restAssured.model.Message;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.response.Response;

public class UtilityMethods {
	/**
	 * Open the .properties file
	 * @param filePath
	 * @return
	 */
	public static Properties OpenProperties(String filePath) {
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(filePath);
			prop.load(file);
		} catch (FileNotFoundException e) {
			Reporter.log("FileNotFoundException" + e.getMessage(),true);
		} catch (IOException e) {
			Reporter.log("IOException" + e.getMessage(),true);
		}
		return prop;
	}
	
	public Message getMessages(Response response) {
		String res=response.getBody().asString();
		Gson gson = new Gson();
		Type type = new TypeToken<Message>() {
		}.getType();
		Message message = gson.fromJson(res, type);
		return message;
	}
	
	public double convertKelvinToDegree(double kelvin) {
		double celsius = kelvin - 273.15F;
		return celsius;		
	}
}
