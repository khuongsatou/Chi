package com.nvk.ungdungdoctho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<TextView> tieude;
    private ArrayList<TextView> tacgia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tieude = new ArrayList<>();
        this.tacgia = new ArrayList<>();

        this.tieude.add((TextView) findViewById(R.id.text_tieu_de_1));
        this.tieude.add((TextView) findViewById(R.id.text_tieu_de_2));
        this.tieude.add((TextView) findViewById(R.id.text_tieu_de_3));
        this.tieude.add((TextView) findViewById(R.id.text_tieu_de_4));
        this.tieude.add((TextView) findViewById(R.id.text_tieu_de_5));


        this.tacgia.add((TextView) findViewById(R.id.text_tac_gia_1));
        this.tacgia.add((TextView) findViewById(R.id.text_tac_gia_2));
        this.tacgia.add((TextView) findViewById(R.id.text_tac_gia_3));
        this.tacgia.add((TextView) findViewById(R.id.text_tac_gia_4));
        this.tacgia.add((TextView) findViewById(R.id.text_tac_gia_5));


        new FetchDSBaiTho(this.tieude,this.tacgia).execute();



    }

    public void ChiTiet(View view) {
        String tag = (String) view.getTag();
        Intent intent = new Intent(this,ChiTietActivity.class);
        intent.putExtra("ID",Integer.parseInt(tag));
        startActivity(intent);
    }
}
