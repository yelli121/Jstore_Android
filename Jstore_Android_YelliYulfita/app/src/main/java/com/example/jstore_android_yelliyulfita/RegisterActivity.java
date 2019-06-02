package com.example.jstore_android_yelliyulfita;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.jstore_android_yelliyulfita.R.layout.activity_register);
        final EditText nameInput = findViewById(com.example.jstore_android_yelliyulfita.R.id.nameInput);
        final EditText userInput = findViewById(com.example.jstore_android_yelliyulfita.R.id.userInput);
        final EditText emailInput = findViewById(com.example.jstore_android_yelliyulfita.R.id.emailInput);
        final EditText passInput = findViewById(com.example.jstore_android_yelliyulfita.R.id.passInput);
        final Button registerButton = findViewById(com.example.jstore_android_yelliyulfita.R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = nameInput.getText().toString();
                final String username = userInput.getText().toString();
                final String email = emailInput.getText().toString();
                final String password = passInput.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject !=null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Success!").create().show();
                                finish();
                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                            builder.setMessage("Register Failed!").create().show();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(name, username, email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}
