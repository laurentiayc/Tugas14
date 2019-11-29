package com.example.ujiantengahsemester;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreateDosenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dosen);

        Button btnDaftarKrs = (Button)findViewById(R.id.btnSimpanDosen);
        btnDaftarKrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateDosenActivity.this, HomeAdmin.class);
                startActivity(intent);
            }
        });
    }

//    private void createDosen(){
//        DataDosenService service = RetrofitClient.getRetrofitInstace().create(DataDosenService.class);
//        Call<ArrayList<Dosen>> call = service.getDosenALL("721600012");
//        call.enqueue(new Callback<ArrayList<Dosen>>(){
//            @Override
//            public void onResponse(Call<ArrayList<Dosen>> call, Response<ArrayList<Dosen>> response) {
//                progressDialog.dismiss();
//                recyclerView = findViewById(R.id.rvDosen);
//                dosenAdapter = new DosenAdapter(response.body());
//
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CreateDosenActivity.this);
//                recyclerView.setLayoutManager(layoutManager);
//                recyclerView.setAdapter(dosenAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Dosen>> call, Throwable t) {
//
//                progressDialog.dismiss();
//                Toast.makeText(RecyclerViewDaftarDosen.this,"Coba Lagi",Toast.LENGTH_SHORT);
//
//            }
//        });
}
