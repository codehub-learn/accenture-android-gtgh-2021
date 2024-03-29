package com.codehub.accenture_demoapp.rest_api.json;

import java.util.List;

public class JsonResponse {
    private List<JsonChannelResponse> channels;

    public JsonResponse() {
    }

    public List<JsonChannelResponse> getChannels() {
        return channels;
    }

    public void setChannels(List<JsonChannelResponse> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "channels=" + channels +
                '}';
    }
}
