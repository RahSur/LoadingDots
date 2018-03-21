package com.example.android.loadingdots;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import steelkiwi.com.library.DotsLoaderView;

public class MainActivity extends AppCompatActivity
{

    DotsLoaderView dlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dlv = (DotsLoaderView) findViewById(R.id.dotsLoaderView);
        demoload();
    }

    private void demoload()
    {
        AsyncTask<String,String,String> demo = new AsyncTask<String, String, String>() {

            @Override
            protected void onPreExecute() {
                dlv.show();
            }

            @Override
            protected String doInBackground(String... voids) {
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Done";
            }

            @Override
            protected void onPostExecute(String s) {
                if(s.equals("Done"))
                    dlv.hide();

            }
        };
        demo.execute();

    }
}
