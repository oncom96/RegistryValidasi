package com.example.register_validasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {
    //Initialize Variable
    EditText etName,etMobile,etEmail,etwebsite,etpassword,etconfirmpassword;
    Button btsubmit;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asign Variable
        etName = findViewById(R.id.et_name);
        etMobile = findViewById(R.id.et_mobile);
        etEmail = findViewById(R.id.et_email);
        etwebsite = findViewById(R.id.et_website);
        etpassword = findViewById(R.id.et_password);
        etconfirmpassword = findViewById(R.id.et_confirm_password);
        btsubmit = findViewById(R.id.bt_submit);

        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Add Validation For Name
        awesomeValidation.addValidation(this,R.id.et_name,
                RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        //For Mobile Number
        awesomeValidation.addValidation(this,R.id.et_mobile,
                "[5-9]{1}[0-9]{9}$",R.string.invalid_mobile);
        //For Email
        awesomeValidation.addValidation(this,R.id.et_email,
                Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        //For Website
        awesomeValidation.addValidation(this,R.id.et_website,
                Patterns.WEB_URL,R.string.invalid_website);
        //For Password
        awesomeValidation.addValidation(this,R.id.et_password,
                ".{6,}",R.string.invalid_password);
        //For Confirm Password
        awesomeValidation.addValidation(this,R.id.et_confirm_password,
                R.id.et_password,R.string.invalid_confirm_password);
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check Validation
                if (awesomeValidation.validate()) {
                    //On Success
                    Toast.makeText(getApplicationContext(),
                            "Succefully...",Toast.LENGTH_SHORT) .show();
                }else {
                    Toast.makeText(getApplicationContext(),
                            "Failed Data",Toast.LENGTH_SHORT) .show();
                }

            }
        });

    }
}
