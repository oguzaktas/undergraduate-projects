package com.example.advertisementmanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Yazilim Laboratuvari II Proje 3
 * @author Oguz Aktas & Mert Var
 */
public class DashBoard extends AppCompatActivity implements View.OnClickListener {

    private TextView txtWelcome;
    private EditText input_new_password;
    private Button btnChangePass,btnLogout, btnDatabase, btnReklam;
    private RelativeLayout activity_dashboard;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //View
        txtWelcome = (TextView)findViewById(R.id.dashboard_welcome);
        input_new_password = (EditText)findViewById(R.id.dashboard_new_password);
        btnChangePass = (Button)findViewById(R.id.dashboard_btn_change_pass);
        btnLogout = (Button)findViewById(R.id.dashboard_btn_logout);
        btnDatabase = (Button)findViewById(R.id.dashboard_btn_database);
        btnReklam = (Button)findViewById(R.id.dashboard_btn_reklam);
        activity_dashboard = (RelativeLayout)findViewById(R.id.activity_dash_board);

        btnChangePass.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
        btnDatabase.setOnClickListener(this);
        btnReklam.setOnClickListener(this);

        //Init Firebase
        auth = FirebaseAuth.getInstance();

        //Session check
        if(auth.getCurrentUser() != null)
            txtWelcome.setText("Hosgeldiniz, " + auth.getCurrentUser().getEmail());

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.dashboard_btn_change_pass) {
            if(input_new_password.length() < 6)
            {
                Snackbar snackBar = Snackbar.make(activity_dashboard, "Sifre uzunlugu 6 karakterden buyuk olmalidir",Snackbar.LENGTH_LONG);
                snackBar.show();
            } else {
                changePassword(input_new_password.getText().toString());
            }
        }
        else if(view.getId() == R.id.dashboard_btn_logout) {
            logoutUser();
        }
        else if(view.getId() == R.id.dashboard_btn_database) {
            openDatabase();
        }
        else if(view.getId() == R.id.dashboard_btn_reklam) {
            openReklam();
        }
    }

    private void logoutUser() {
        auth.signOut();
        if(auth.getCurrentUser() == null)
        {
            startActivity(new Intent(DashBoard.this, MainActivity.class));
            finish();
        }
    }

    private void changePassword(String newPassword) {
        FirebaseUser user = auth.getCurrentUser();
        user.updatePassword(newPassword).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Snackbar snackBar = Snackbar.make(activity_dashboard,"Sifreniz degistirildi.",Snackbar.LENGTH_LONG);
                    snackBar.show();
                }
            }
        });
    }

    private void openDatabase() {
        startActivity(new Intent(DashBoard.this, Database.class));
        finish();
    }

    private void openReklam() {
        startActivity(new Intent(DashBoard.this, FindAdvertisement.class));
        finish();
    }
}
