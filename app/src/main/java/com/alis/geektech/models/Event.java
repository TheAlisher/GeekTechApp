package com.alis.geektech.models;

import java.io.Serializable;

public class Event implements Serializable {

    private int eventPhoto;
    private String eventName;
    private String eventDescription;
    private String eventData;
    private String eventTime;

    public Event(int eventPhoto, String eventName, String eventDescription, String eventData, String eventTime) {
        this.eventPhoto = eventPhoto;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventData = eventData;
        this.eventTime = eventTime;
    }

    public int getEventPhoto() {
        return eventPhoto;
    }

    public void setEventPhoto(int eventPhoto) {
        this.eventPhoto = eventPhoto;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventData() {
        return eventData;
    }

    public void setEventData(String eventData) {
        this.eventData = eventData;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }
}
