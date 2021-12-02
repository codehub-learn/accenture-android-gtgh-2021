package com.codehub.accenture_demoapp.rest_api.json;

import java.util.List;

public class JsonChannelResponse {
    private String channelName;
    private List<JsonShowResponse> shows;

    public JsonChannelResponse() {
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public List<JsonShowResponse> getShows() {
        return shows;
    }

    public void setShows(List<JsonShowResponse> shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "JsonChannelResponse{" +
                "channelName='" + channelName + '\'' +
                ", shows=" + shows +
                '}';
    }
}
