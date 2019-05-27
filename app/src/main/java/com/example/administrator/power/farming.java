package com.example.administrator.power;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class farming extends AppCompatActivity {

    TextView tv;
    Button btn;
    Calendar cal;
    DatePickerDialog datePickerDialog;

    private RequestQueue mQueue;
    List<String> farming_lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farming);

        tv = (TextView)findViewById(R.id.tv);
        btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(farming.this, new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet (DatePicker datePicker,int mYear,int mMonth,int mDay){
                        tv.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
                    }
                },day,month,year);

            }
        });
//        ListView listView = findViewById(R.id.farming_list);
        mQueue = Volley.newRequestQueue(this);

//        getJson(listView);

        List<String> list = new ArrayList<String >();
        list.add("กข5");
        list.add("กข6");
        list.add("กข7");
        list.add("กข8");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        Spinner spinner = (Spinner)this.findViewById(R.id.spinner3);
        spinner.setAdapter((dataAdapter));

//        List<String> listView = new ArrayList<String >();
//        listView.add("นาดำ");
//        listView.add("นาหว่าน");
//
//        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
//        Spinner spinnerlist = (Spinner)this.findViewById(R.id.spinner4);
//        spinner.setAdapter((dataAdapter));
    }
//
//    public void getJson(final ListView listView) {
//
//        String url = "http://10.0.2.2/project/data/farming.php";
//
//        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        try {
//                            for (int i = 0; i < response.length(); i++) {
//                                JSONObject rice = response.getJSONObject(i);
//
//                                String  rice_id = rice.getString("rice_id");
//                                String rice_name = rice.getString("rice_name");
//
//                                farming_lists.add(rice_id);
//                            }
//
//                            RiceApdapter adapter = new RiceApdapter();
//                            listView.setAdapter(adapter);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//
//        mQueue.add(request);
//    }

//    class RiceApdapter extends BaseAdapter {
//
//        @Override
//        public int getCount() {
//            return farming_lists.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @SuppressLint("ViewHolder")
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView = getLayoutInflater().inflate(R.layout.farming_row, null);
//
//            Button name_list = convertView.findViewById(R.id.farming);
//
//            name_list.setText(farming_lists.get(position));
//            return convertView;
//        }
//    }
}
