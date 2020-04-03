package com.example.tugasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Button showDialogButton;

    Button btnKeluar, btnOk;

    private void showDialogButton() {
        final Dialog dialog = new Dialog(this);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //Mengeset Judul Dialog
        alertDialogBuilder
                .setTitle("Detail Pendaftaran")
                .setIcon(R.mipmap.ic_launcher);

        //Mengeset Layout
        dialog.setContentView(R.layout.activity_main2);

        //Membuat Agar Dialog Tak Hilang
        dialog.setCanceledOnTouchOutside(false);

        //Membuat Dialog Agar Berukuran Responsive
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        dialog.getWindow().setLayout((3 * width) / 3, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button OKButton = (Button) dialog.findViewById(R.id.btnOk);
        Button OutButton = (Button) dialog.findViewById(R.id.btnKeluar);

        //Button untuk OK
        OKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
                Toast.makeText(MainActivity2.this,"Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        //Button untuk Keluar Activity
        OutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivity();
            }
        });

        //Menampilkan Custom Dialog
        dialog.show();
    }

    public void openActivity1(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void closeActivity(){
        finish();
        System.exit(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        showDialogButton = (Button) findViewById(R.id.btnOk);

        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogButton();
            }
        });
    }
}
