package com.br.app4all;

public class Event {

    private String EventName;
    private String ImageUrl;
    private String EventDesc;
    private String DataEvent;

    public Event(String eventName, String imageUrl, String eventDesc, String dataEvent) {
        EventName   = eventName;
        ImageUrl    = imageUrl;
        EventDesc   = eventDesc;
        DataEvent   = dataEvent;
    }

    public Event() {
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getEventDesc() {
        return EventDesc;
    }

    public void setEventDesc(String eventDesc) {
        EventDesc = eventDesc;
    }

    public String getDataEvent() {
        return DataEvent;
    }

    public void setDataEvent(String dataEvent) {
        DataEvent = dataEvent;
    }

}
