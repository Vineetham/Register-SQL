package com.example.vineetha.sqllogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // Creating EditText.
    EditText username1, password1,usnno1,gender1,dob1,email1,phoneno1,confirm1;

    // Creating button;
    Button LoginButton;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Create string variable to hold the EditText Value.
    String NameHolder, PasswordHolder;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String HttpUrl = "http://10.0.2.2:80/test3/log.php";

    Boolean CheckEditText;

    //String ServerResponse = null ;

    String TempServerResponseMatchedValue = "Data Matched" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username1 = (EditText) findViewById(R.id.user);
        usnno1 = (EditText) findViewById(R.id.usnno);
        dob1=(EditText)findViewById(R.id.dob);
        email1=(EditText)findViewById(R.id.email);
        gender1 = (EditText) findViewById(R.id.gender);
        phoneno1=(EditText)findViewById(R.id.phno);
        password1= (EditText) findViewById(R.id.password);
        confirm1=(EditText)findViewById(R.id.confirm);


        // Assigning ID's to Button.
        LoginButton = (Button) findViewById(R.id.button);

       /* // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(LoginActivity.this);

        // Assigning Activity this to progress dialog.
        progressDialog = new ProgressDialog(LoginActivity.this);*/

        // Adding click listener to button.
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username1.getText().toString();
                String usn = usnno1.getText().toString();
                String db=dob1.getText().toString();
                String em=email1.getText().toString();
                String gen = gender1.getText().toString();
                String ph=phoneno1.getText().toString();
                String pass = password1.getText().toString();
                String con=confirm1.getText().toString();


                if(username1.getText().toString().length()==0)
                {
                    username1.setError("Field is not be empty");
                    return;
                }
                if(usnno1.getText().toString().length()==0)
                {
                    usnno1.setError("Field is not be empty");
                    return;
                }
                if(gender1.getText().toString().length()==0)
                {
                    gender1.setError("Field is not be empty");
                    return;
                }

                if(password1.getText().toString().length()==0)
                {
                    password1.setError("Field is not be empty");
                    return;
                }
                if(dob1.getText().toString().length()==0)
                {
                    dob1.setError("Field is not be empty");
                    return;
                }
                if(email1.getText().toString().length()==0)
                {
                    email1.setError("Field is not be empty");
                    return;
                }
                if(phoneno1.getText().toString().length()==0)
                {
                    phoneno1.setError("Field is not be empty");
                    return;
                }
                if(confirm1.getText().toString().length()==0)
                {
                    confirm1.setError("Field is not be empty");
                    return;
                }


                Validating(name,usn,db,em,gen,ph,pass,con);

            }
        });

    }

    private void Validating(final String name,final String usno,final String dab,final String ema,final String gend,final String ph,final String pwd,final String co){
        //    Toast.makeText(login_activity.this, name, Toast.LENGTH_SHORT).show();
        //  progressDialog=new ProgressDialog(this);
        //progressDialog.setTitle("Validating...");
        //progressDialog.setMax(3000);
        // progressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, HttpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String val=jsonObject.getString("message");
                    if(val.equals("LogIn Success")){
                        Intent intent=new Intent(MainActivity.this,SuccessActivity.class);
                        startActivity(intent);
                        username1.setText("");
                        usnno1.setText("");
                        dob1.setText("");
                        email1.setText("");
                        gender1.setText("");
                        phoneno1.setText("");
                        password1.setText("");
                        confirm1.setText("");

                        //  progressDialog.hide();
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Enter Valid Details", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map <String,String> map=new HashMap<>();
                map.put("username1",name);
                map.put("usnno1",usno);
                map.put("dob1",dab);
                map.put("email1",ema);
                map.put("gender1",gend);
                map.put("phoneno1",ph);
                map.put("password1",pwd);
                map.put("confirm1",co);
                return  map;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}