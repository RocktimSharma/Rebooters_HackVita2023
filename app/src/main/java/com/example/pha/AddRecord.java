package com.example.pha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class AddRecord extends AppCompatActivity {
    private ImageView photo_imgVw;
    private EditText docName_et,phone_et,specialist_et,disease_et,medicine_et;
    private ListView medicine_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);


        photo_imgVw=findViewById(R.id.addrecA_photo_imgVw);
        docName_et=findViewById(R.id.addrecA_docname_edtTxt);
        phone_et=findViewById(R.id.addrecA_phnno_edtTxt);
        specialist_et=findViewById(R.id.addrecA_specialist_edtTxt);
        disease_et=findViewById(R.id.addrecA_disease_edtTxt);
        medicine_et=findViewById(R.id.addrecA_med_edtTxt);
        medicine_lv=findViewById(R.id.addrecA_med_listVw);




    }
}