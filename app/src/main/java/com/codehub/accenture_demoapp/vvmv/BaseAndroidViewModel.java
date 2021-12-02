package com.codehub.accenture_demoapp.vvmv;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class BaseAndroidViewModel extends AndroidViewModel {

    private MutableLiveData<String> streamMessages = new MutableLiveData<>();

    public BaseAndroidViewModel(@NonNull Application application) {
        super(application);
    }

    public void listenToStream(LifecycleOwner owner, Observer<String> observer) {
        streamMessages.observe(owner, observer);
    }

    public void removeFromStream(LifecycleOwner owner) {
        streamMessages.removeObservers(owner);
    }

    public void sendMessage(String message) {
        streamMessages.postValue(message);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
