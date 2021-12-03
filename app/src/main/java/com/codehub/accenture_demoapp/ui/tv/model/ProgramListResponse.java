package com.codehub.accenture_demoapp.ui.tv.model;

import com.codehub.accenture_demoapp.rest_api.json.JsonChannelResponse;

import java.util.List;

public class ProgramListResponse  {
    private List<JsonChannelResponse> channels;

    public ProgramListResponse() {
    }

    public List<JsonChannelResponse> getChannels() {
        return channels;
    }

    public void setChannels(List<JsonChannelResponse> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "ProgramListResponse{" +
                "channels=" + channels +
                '}';
    }
}
