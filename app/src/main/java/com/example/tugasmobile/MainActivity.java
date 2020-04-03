package com.example.tugasmobile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button getBtnDaftar;
    private Button showDialogButton;

    Calendar myCalendar;
    Button btnDaftar, btnKembali;
    DatePickerDialog.OnDateSetListener date;
    EditText textInputNamaDepan,
            textInputNamaBelakang,
            textInputTempatLahir,
            textInputTglLahir,
            textInputAlamat,
            textInputTelepon,
            textInputEmail,
            textInputPassword,
            textInputRepassword;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputNamaDepan = findViewById(R.id.textInputNamaDepan);
        textInputNamaBelakang = findViewById(R.id.textInputNamaBelakang);
        textInputTempatLahir = findViewById(R.id.textInputTempatLahir);
        textInputAlamat = findViewById(R.id.textInputAlamat);
        textInputTelepon = findViewById(R.id.textInputTelepon);
        textInputTglLahir = findViewById(R.id.textInputTglLahir);
        textInputEmail = findViewById(R.id.textInputEmail);
        textInputPassword = findViewById(R.id.textInputPassword);
        textInputRepassword = findViewById(R.id.textInputRepassword);

        btnDaftar = findViewById(R.id.btnDaftar);
        btnKembali = findViewById(R.id.btnKembali);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //NamaDepan
        awesomeValidation.addValidation(this, R.id.textInputNamaDepan,
                RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        //NamaBelakang
        awesomeValidation.addValidation(this, R.id.textInputNamaBelakang,
                RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        //TempatLahir
        awesomeValidation.addValidation(this, R.id.textInputTempatLahir,
                RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        //Alamat
        awesomeValidation.addValidation(this, R.id.textInputAlamat,
                RegexTemplate.NOT_EMPTY, R.string.invalid_name);

        //NoTelp
        awesomeValidation.addValidation(this, R.id.textInputTelepon,
                ".{12,}", R.string.invalid_number);

        //Email
        awesomeValidation.addValidation(this, R.id.textInputEmail,
                Patterns.EMAIL_ADDRESS, R.string.invalid_email);

        //Password
        awesomeValidation.addValidation(this, R.id.textInputPassword,
                ".{9,}", R.string.invalid_pass);

        //Repasword
        awesomeValidation.addValidation(this, R.id.textInputRepassword,
                R.id.textInputPassword, R.string.invalid_confirm);


    }
}
