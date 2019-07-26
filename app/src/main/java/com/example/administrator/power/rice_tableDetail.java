package com.example.administrator.power;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rice_tableDetail extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice_table_detail);

        TextView name = findViewById(R.id.name);
        TextView product = findViewById(R.id.product);
        mQueue = Volley.newRequestQueue(this);

        getJson(name, product, savedInstanceState);
    }

    private void getJson(final TextView name, final TextView product, Bundle savedInstanceState) {
        String newString;
        String url = "";
        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                newString = null;
            }else {
                newString = extras.getString("name");
                url = "http://10.0.2.2/project/data/rice_tableDetail.php?id="+newString;
            }

        }else {
            newString = (String) savedInstanceState.getSerializable("name");
            url = "http://10.0.2.2/project/data/rice_tableDetail.php?id="+newString;
        }
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++){
                        JSONObject rice = response.getJSONObject(i);
                        String rice_name = rice.getString("rice_ta_name");
                        String rice_product = rice.getString("product");

                        name.setText(rice_name);
                        product.setText(rice_product);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
       mQueue.add(request);
    }
}
