package com.soul.amazingbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dhc.absdk.ABRet;
import com.dhc.absdk.ABSDK;

public class SocketActivity extends AppCompatActivity {

    TextView textViewSockStatus;
    Button buttonSwitch;
    boolean mIsOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);
        findViews();
        //读取设备信息
        SockStatusAsyncTask sockStatus = new SockStatusAsyncTask();
        sockStatus.execute("Acharge");
    }

    private void findViews() {
        buttonSwitch = (Button) findViewById(R.id.buttonSwitch);
    }

    public void onSwitchButtonDown(View view) {
        /******************/
        mIsOn = !mIsOn;
        if (mIsOn == true) {
            buttonSwitch.setBackground(getDrawable
                    (R.drawable.switch_on0));
        } else {
            buttonSwitch.setBackground(getDrawable
                    (R.drawable.switch_off0));
        }
        /****************************/


        SockCtrlAsyncTask sockCtrlAsyncTask = new SockCtrlAsyncTask();
        if (mIsOn == true) {
            sockCtrlAsyncTask.execute("Acharge", "0");
        } else {
            sockCtrlAsyncTask.execute("Acharge", "1");
        }
    }

    public class SockStatusAsyncTask extends AsyncTask<String, Void, ABRet> {
        @Override
        protected ABRet doInBackground(String... params) {
            return ABSDK.getInstance().getSockStatus(params[0]);
        }

        @Override
        protected void onPostExecute(ABRet abRet) {
            super.onPostExecute(abRet);
            if (abRet.getCode().equals("00000")) {
                String isOn_s = abRet.getDicDatas().get("status").toString();
                String isOn_zh;
                if (isOn_s.equals("1")) {
                    mIsOn = true;
                    isOn_zh = "开关状态: on";

                } else {
                    mIsOn = false;
                    isOn_zh = "开关状态: off";
                    buttonSwitch.setBackground(getDrawable
                            (R.drawable.switch_off0));
                }
                textViewSockStatus.setText(isOn_zh);
                Toast.makeText(SocketActivity.this, "sock " + ABoxConstants.keyMaps.get(abRet.getCode()).toString(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SocketActivity.this, ABoxConstants.keyMaps.get(abRet.getCode()).toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class SockCtrlAsyncTask extends AsyncTask<String, Void, ABRet> {
        @Override
        protected ABRet doInBackground(String... params) {
            return ABSDK.getInstance().sockCtrl(params[0], params[1]);
        }

        @Override
        protected void onPostExecute(ABRet abRet) {
            super.onPostExecute(abRet);
            if (abRet.getCode().equals("00000")) {
                //String isOn_s = abRet.getDicDatas().get("status").toString();
                String isOn_zh;
                mIsOn = !mIsOn;
                if (mIsOn == true) {
                    isOn_zh = "开关状态: on";
                    buttonSwitch.setBackground(getDrawable
                            (R.drawable.switch_on0));
                } else {
                    isOn_zh = "开关状态: off";
                    buttonSwitch.setBackground(getDrawable
                            (R.drawable.switch_off0));
                }
                textViewSockStatus.setText(isOn_zh);
                Toast.makeText(SocketActivity.this, "Sock控制" + ABoxConstants.keyMaps.get(abRet.getCode()).toString(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SocketActivity.this, ABoxConstants.keyMaps.get(abRet.getCode()).toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
