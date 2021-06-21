
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
    "type",
    "id",
    "country",
    "sunrise",
    "sunset"
})
@Generated("jsonschema2pojo")
public class Sys
{
    private int type;

    private int id;

    private String country;

    private int sunrise;

    private int sunset;

    public void setType(int type){
        this.type = type;
    }
    public int getType(){
        return this.type;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setSunrise(int sunrise){
        this.sunrise = sunrise;
    }
    public int getSunrise(){
        return this.sunrise;
    }
    public void setSunset(int sunset){
        this.sunset = sunset;
    }
    public int getSunset(){
        return this.sunset;
    }
}