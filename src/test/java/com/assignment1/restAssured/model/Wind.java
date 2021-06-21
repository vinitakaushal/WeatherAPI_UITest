
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
    "speed",
    "deg"
})
@Generated("jsonschema2pojo")
public class Wind
{
    private double speed;

    private int deg;

    private double gust;

    public void setSpeed(double speed){
        this.speed = speed;
    }
    public double getSpeed(){
        return this.speed;
    }
    public void setDeg(int deg){
        this.deg = deg;
    }
    public int getDeg(){
        return this.deg;
    }
    public void setGust(double gust){
        this.gust = gust;
    }
    public double getGust(){
        return this.gust;
    }
}