package com.soul.amazingbox;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class RemoteActivity extends AppCompatActivity {
    ArrayList<String> remoteButtonList;

    GridView gridViewRemoteLayOut;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remote_layout);
        remoteButtonList = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            remoteButtonList.add(i, "button" + i);
        }

        gridViewRemoteLayOut = (GridView) findViewById(R.id.gridViewRemote);
        RemoteAdapter remoteAdapter = new RemoteAdapter();
        gridViewRemoteLayOut.setAdapter(remoteAdapter);
        gridViewRemoteLayOut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            AlertDialog.Builder builder = new AlertDialog.Builder(RemoteActivity.this);

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(RemoteActivity.this, "welcome", Toast.LENGTH_LONG).show();
                builder.setIcon(R.drawable.logo);//设置图标
                builder.setTitle("等待红外信号");//设置对话框的标题
                builder.setMessage("请使用遥控器对准设备按键");//设置对话框的内容
                builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {  //这个是设置取消按钮
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(RemoteActivity.this, "取消成功", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog b = builder.create();
                b.show();
            }

        });
        ;
    }

    public class RemoteAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 30;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            TextView textViewKeyName = null;
            if (convertView == null) {

                LayoutInflater layoutInflater = getLayoutInflater();
                view = layoutInflater.inflate(R.layout.remote_button_layout, null);
                convertView = view;
                textViewKeyName = (TextView) view.findViewById(R.id.textViewKeyName);

            } else {
                textViewKeyName = (TextView) convertView.findViewById(R.id.textViewKeyName);
            }
            textViewKeyName.setText(remoteButtonList.get(position));
            return convertView;
        }
    }
}