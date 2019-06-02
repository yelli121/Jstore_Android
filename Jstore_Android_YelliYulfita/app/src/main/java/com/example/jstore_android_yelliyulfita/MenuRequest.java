package com.example.jstore_android_yelliyulfita;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MenuRequest extends StringRequest {
    private static final String Menu_URL = "http://192.168.43.229:8080/items";

    public MenuRequest(Response.Listener<String> listener) {
        super(Method.GET, Menu_URL, listener, null);
    }
}
