package com.nvk.ungdungdoctho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ChiTietActivity extends AppCompatActivity {
    private TextView mNoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID",-1);
        this.mNoiDung = findViewById(R.id.text_bai_tho);
        new FetchBaiTho(mNoiDung,getActionBar()).execute(id);

    }
}
