package com.nvk.ungdungdoctho;

import android.app.ActionBar;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FetchBaiTho extends AsyncTask<Integer,Void,String> {
    private WeakReference<TextView> mBaiTho;
    private WeakReference<ActionBar> mActionBar;

    public FetchBaiTho(TextView mBaiTho, ActionBar mActionBar) {
        this.mBaiTho = new WeakReference<>(mBaiTho);
        this.mActionBar = new WeakReference<>(mActionBar);
    }


    @Override
    protected String doInBackground(Integer... integers) {
        ArrayList<String> nameParams = new ArrayList<>();
        nameParams.add("id");
        ArrayList<String> valueParams = new ArrayList<>();
        valueParams.add(Integer.toString(integers[0]-1));

        return NetworkUtils.getJSONData1("api.php","GET",nameParams.toArray(),valueParams.toArray());
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONObject baiThoObject = jsonObject.getJSONObject("bai_tho");
            if (baiThoObject != null){
                //this.mActionBar.get().setTitle(baiThoObject.getString("tieu_de"));
                //this.mActionBar.get().setSubtitle(baiThoObject.getString("tac_gia"));
                this.mBaiTho.get().setText(baiThoObject.getString("noi_dung"));

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }



        super.onPostExecute(s);
    }
}
