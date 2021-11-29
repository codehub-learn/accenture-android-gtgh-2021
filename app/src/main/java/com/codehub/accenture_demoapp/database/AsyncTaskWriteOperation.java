package com.codehub.accenture_demoapp.database;

import android.os.AsyncTask;

public class AsyncTaskWriteOperation extends AsyncTask<DatabaseTable, Void, Boolean> {

    interface Listener {
        public void getResponse(Boolean list);
    }

    private DatabaseInstance database;
    private AsyncTaskWriteOperation.Listener callback;

    public AsyncTaskWriteOperation(DatabaseInstance database, AsyncTaskWriteOperation.Listener callback) {
        this.database = database;
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(DatabaseTable... voids) {
        try {
            for (DatabaseTable item : voids) {
                database.getDatabaseTableDao().save(item);
            }
        } catch (Exception exception) {
            return false;
        }


        return true;
    }

    @Override
    protected void onPostExecute(Boolean s) {
        super.onPostExecute(s);
        callback.getResponse(s);
    }
}
