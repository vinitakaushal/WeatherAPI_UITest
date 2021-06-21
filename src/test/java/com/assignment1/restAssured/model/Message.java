
package com.assignment1.restAssured.model;

import java.util.HashMap;
import java.util.List;
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
    "coord",
    "weather",
    "base",
    "main",
    "visibility",
    "wind",
    "clouds",
    "dt",
    "sys",
    "timezone",
    "id",
    "name",
    "cod"
})
@Generated("jsonschema2pojo")
public class Message {

	private Coord coord;

    private List<Weather> weather;

    private String base;

    private Main main;

    private int visibility;

    private Wind wind;

    private Clouds clouds;

    private int dt;

    private Sys sys;

    private int timezone;

    private int id;

    private String name;

    private int cod;

    public void setCoord(Coord coord){
        this.coord = coord;
    }
    public Coord getCoord(){
        return this.coord;
    }
    public void setWeather(List<Weather> weather){
        this.weather = weather;
    }
    public List<Weather> getWeather(){
        return this.weather;
    }
    public void setBase(String base){
        this.base = base;
    }
    public String getBase(){
        return this.base;
    }
    public void setMain(Main main){
        this.main = main;
    }
    public Main getMain(){
        return this.main;
    }
    public void setVisibility(int visibility){
        this.visibility = visibility;
    }
    public int getVisibility(){
        return this.visibility;
    }
    public void setWind(Wind wind){
        this.wind = wind;
    }
    public Wind getWind(){
        return this.wind;
    }
    public void setClouds(Clouds clouds){
        this.clouds = clouds;
    }
    public Clouds getClouds(){
        return this.clouds;
    }
    public void setDt(int dt){
        this.dt = dt;
    }
    public int getDt(){
        return this.dt;
    }
    public void setSys(Sys sys){
        this.sys = sys;
    }
    public Sys getSys(){
        return this.sys;
    }
    public void setTimezone(int timezone){
        this.timezone = timezone;
    }
    public int getTimezone(){
        return this.timezone;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setCod(int cod){
        this.cod = cod;
    }
    public int getCod(){
        return this.cod;
    }
}
