package com.codehub.accenture_demoapp.database;


import android.os.AsyncTask;

import java.util.List;

public class AsyncTaskOperation extends AsyncTask<String, Void, List<DatabaseTable>> {

    interface Listener {
        public void getResponse(List<DatabaseTable> list);
    }

    private DatabaseInstance database;
    private Listener callback;

    public AsyncTaskOperation(DatabaseInstance database, Listener callback) {
        this.database = database;
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<DatabaseTable> doInBackground(String... voids) {
        return database.getDatabaseTableDao().queryGetAll();
    }

    @Override
    protected void onPostExecute(List<DatabaseTable> s) {
        super.onPostExecute(s);
        callback.getResponse(s);
    }
}
