package com.codehub.accenture_demoapp.ui.tv;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.codehub.accenture_demoapp.rest_api.json.JsonChannelResponse;
import com.codehub.accenture_demoapp.rest_api.json.JsonResponse;
import com.codehub.accenture_demoapp.ui.tv.model.ProgramItemListUiModel;
import com.codehub.accenture_demoapp.ui.tv.recyclerView.ProgramListAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ProgramListViewModel extends AndroidViewModel {

    @NonNull
    private MutableLiveData<RecyclerView.Adapter> streamAdapter;
    @NonNull
    RequestQueue queue;


    public ProgramListViewModel(@NonNull Application application) {
        super(application);
        streamAdapter = new MutableLiveData<>();
        queue = Volley.newRequestQueue(getApplication());
    }

    public void observeToStreamAdapter(LifecycleOwner owner, Observer<RecyclerView.Adapter> observer) {
        //   if (streamAdapter != null) {
        streamAdapter.observe(owner, observer);
        //        } else {
        //            throw new IllegalStateException("You have to initialise the stream adapter");
        //        }
    }

    public void disableStreams(LifecycleOwner owner) {
        //        if (streamAdapter != null) {
        streamAdapter.removeObservers(owner);
        //        }
    }

    public void fetchDataFromServer() {
        // Instantiate the RequestQueue.
        String url = "https://tv-zapping.herokuapp.com/v2/tv";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JsonResponse jsonResponse = new Gson().fromJson(response, JsonResponse.class);
                        Log.d("REST-API", jsonResponse.toString());
                        transformFromServerToUiModel(jsonResponse);
                        // Display the first 500 characters of the response string.

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("REST-API", error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void transformFromServerToUiModel(JsonResponse data) {
        List<ProgramItemListUiModel> uiModelList = new ArrayList<>();

        for (JsonChannelResponse item: data.getChannels()) {
            ProgramItemListUiModel uiModel = new ProgramItemListUiModel();
            uiModel.setTitle(item.getChannelName());
        }

        ProgramListAdapter adapter = new ProgramListAdapter(uiModelList);
        streamAdapter.postValue(adapter);
    }
}
