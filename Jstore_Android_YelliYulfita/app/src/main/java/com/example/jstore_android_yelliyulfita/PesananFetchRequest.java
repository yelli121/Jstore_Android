package com.example.jstore_android_yelliyulfita;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class PesananFetchRequest extends StringRequest {
    private static final String FETCH_URL = "http://192.168.43.229:8080/invoicecustomer";
    public PesananFetchRequest(int id, Response.Listener<String> listener) {
        super(Method.GET, FETCH_URL.concat("/"+id), listener, null);
        Log.d("url", "PesananFetchRequest: "+ FETCH_URL.concat("/"+id));
    }
}
