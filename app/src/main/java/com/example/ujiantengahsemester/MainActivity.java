package com.example.ujiantengahsemester;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        Button btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeAdmin.class);
                startActivity(intent);
            }
       });

        Button btnSignDosen = (Button)findViewById(R.id.btnSignInDosen);
        btnSignDosen.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeDosen.class);
                startActivity(intent);
            }
        });
     }

    private View.OnClickListener myBtnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences prefs = MainActivity.this.getSharedPreferences("prefs_file", MODE_PRIVATE);

            String statusLogin = prefs.getString("isLogin", null);
            SharedPreferences.Editor edit = prefs.edit();

            TextView emailText = findViewById(R.id.editText3);
            if (emailText.getText().toString().contains("@si.ukdw.ac.id")) {
                edit.putString("isLogin", "Dosen");
                edit.commit();
                Intent intent = new Intent(MainActivity.this, HomeDosen.class);
                startActivity(intent);
            } else if (emailText.getText().toString().contains("@staff.ukdw.ac.id")) {
                edit.putString("isLogin", "Admin");
                edit.commit();
                Intent intent = new Intent(MainActivity.this, HomeAdmin.class);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Bukan Email UKDW", Toast.LENGTH_SHORT);
                toast.setMargin(100, 100);
                toast.show();
            }
        }
    };

//    private void insertDosen(){
//        DataDosenService service = RetrofitClient.getRetrofitInstace().create(DataDosenService.class);
//        Call<DefaultResult> call = service.insertDosen("Laurent","72170170","Pontianak",
//                "laurent@ukdw.com","uhuy","laurent.jpg","21");
//        call.enqueue(new Callback<DefaultResult>(){
//            @Override
//            public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
//                System.out.println(response.body().getStatus());
//            }
//
//            @Override
//            public void onFailure(Call<DefaultResult> call, Throwable t) {
//                System.out.println("message :" +t.getMessage());
//                Toast.makeText(MainActivity.this,"Coba Lagi",Toast.LENGTH_SHORT);
//            }
//        });
//
//    }
}