package com.example.administrator.power;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class area extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String url = "";
    String kindOfSoilId;
    String weathersId;

    private RadioButton radioSoidButton;
    private String radioSoidButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.kindOfSoil, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.weathers, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        Display();


//        Button product = (Button)findViewById(R.id.Display);
//        product.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Intent intent = new Intent(area.this,rice_tableDetail.class);
//                //startActivity(intent);
//
//            }
//        });
    }

    private void Display() {
        Button Display = findViewById(R.id.Display);
        final Spinner spinner1 = findViewById(R.id.spinner1);
        final Spinner spinner2 = findViewById(R.id.spinner2);

        final RadioGroup radioSoid = findViewById(R.id.radioSoil);
        final RadioButton radioButton1 = findViewById(R.id.radioButton1);
        final RadioButton radioButton2 = findViewById(R.id.radioButton2);
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kindOfSoil = spinner1.getSelectedItem().toString();
                String weathers = spinner2.getSelectedItem().toString();


                int selectId = radioSoid.getCheckedRadioButtonId();

                radioSoidButton = (RadioButton) findViewById(selectId);


                Toast.makeText(area.this,kindOfSoil,Toast.LENGTH_SHORT).show();
                Toast.makeText(area.this,radioSoidButton.getText(),Toast.LENGTH_SHORT).show();
                Toast.makeText(area.this,weathers,Toast.LENGTH_SHORT).show();



                if (kindOfSoil == "ดินทราย"){
                    kindOfSoilId = "1";
                }else if (kindOfSoil == "ดินเหนียว"){
                    kindOfSoilId = "2";
                }else if (kindOfSoil == "ดินร่วน"){
                    kindOfSoilId = "3";
                }



                if (weathers == "อากาศร้อน" ){
                    weathersId = "1";
                }else if (weathers == "อากาศเย็น"){
                    weathersId = "2";
                }else if (weathers == "อากาศแห้งแล้ง"){
                    weathersId = "3";
                }else if (weathers == "อากาศเย็น+หมอก"){
                    weathersId = "4";
                }else if (weathers == "อากาศร้อน+ฝนตก"){
                    weathersId = "5";
                }


//                if (radioSoidButton == "นอก"){
//                    radioSoidButtonId = "1";
//                }else if (radioSoidButton == "ใน"){
//                    radioSoidButtonId = "2";
//                }

                url = "http://10.0.2.2/Project/data/rice_table.php?soil="+kindOfSoilId+"&irrigation="+radioSoidButtonId+"&weather="+weathersId;
                Toast.makeText(area.this,url, Toast.LENGTH_SHORT).show();


            }
        });

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
