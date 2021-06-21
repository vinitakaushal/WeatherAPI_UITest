
package com.assignment1.restAssured.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "feels_like",
    "temp_min",
    "temp_max",
    "pressure",
    "humidity"
})
@Generated("jsonschema2pojo")
public class Main
{
    private double temp;

    private double feels_like;

    private double temp_min;

    private double temp_max;

    private int pressure;

    private int humidity;

    private int sea_level;

    private int grnd_level;

    public void setTemp(double temp){
        this.temp = temp;
    }
    public double getTemp(){
        return this.temp;
    }
    public void setFeels_like(double feels_like){
        this.feels_like = feels_like;
    }
    public double getFeels_like(){
        return this.feels_like;
    }
    public void setTemp_min(double temp_min){
        this.temp_min = temp_min;
    }
    public double getTemp_min(){
        return this.temp_min;
    }
    public void setTemp_max(double temp_max){
        this.temp_max = temp_max;
    }
    public double getTemp_max(){
        return this.temp_max;
    }
    public void setPressure(int pressure){
        this.pressure = pressure;
    }
    public int getPressure(){
        return this.pressure;
    }
    public void setHumidity(int humidity){
        this.humidity = humidity;
    }
    public int getHumidity(){
        return this.humidity;
    }
    public void setSea_level(int sea_level){
        this.sea_level = sea_level;
    }
    public int getSea_level(){
        return this.sea_level;
    }
    public void setGrnd_level(int grnd_level){
        this.grnd_level = grnd_level;
    }
    public int getGrnd_level(){
        return this.grnd_level;
    }
}
