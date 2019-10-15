package com.nvk.ungdungdoctho;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FetchDSBaiTho  extends AsyncTask<Void,String,String> {
    private ArrayList<WeakReference<TextView>> tieude,tacgia;

    public FetchDSBaiTho(ArrayList<TextView> tieuDe, ArrayList<TextView> tacgia){
        this.tieude = new ArrayList<>();
        this.tacgia = new ArrayList<>();

        for (int i = 0; i <tieuDe.size() ; i++) {
            this.tieude.add(new WeakReference<TextView>(tieuDe.get(i)));
            this.tacgia.add(new WeakReference<TextView>(tacgia.get(i)));

        }



    }

    @Override
    protected String doInBackground(Void... voids) {
        return NetworkUtils.getJSONData("api.php","GET");
    }

    @Override
    protected void onPostExecute(String s) {
        try{
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemArray = jsonObject.getJSONArray("tap_tho");
            for (int i = 0; i < 5; i++) {
                this.tieude.get(i).get().setVisibility(View.VISIBLE);
                this.tacgia.get(i).get().setVisibility(View.VISIBLE);

                this.tieude.get(i).get().setText(itemArray.getJSONObject(i).getString("tieu_de"));
                this.tacgia.get(i).get().setText(itemArray.getJSONObject(i).getString("tac_gia"));

            }

        }catch (JSONException e){
            e.printStackTrace();
        }
        super.onPostExecute(s);
    }
}
