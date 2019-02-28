package com.soul.amazingbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.dhc.absdk.ABRet;
import com.dhc.absdk.ABSDK;

public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView AutoCompleteTextViewUser_name;
    private EditText EditTextUser_password;
    private CheckBox CheckBoxAutoLogn;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
        SharedPreferences sp = getSharedPreferences(ABoxConstants.AUTOLOGINFILE, Context.MODE_PRIVATE);
        if (sp.getBoolean(ABoxConstants.AutologinClass.AUTOLOGIN_FLAG, false) == true) {
            username = sp.getString(ABoxConstants.AutologinClass.AUTOLOGIN_USERNAME, "wrongName");
            password = sp.getString(ABoxConstants.AutologinClass.AUTOLOGIN_USERPSW, "wrongName");
            AutoCompleteTextViewUser_name.setText(username);
            EditTextUser_password.setText(password);
            CheckBoxAutoLogn.setChecked(true);
        }
    }

    private void findViews() {
        AutoCompleteTextViewUser_name = (AutoCompleteTextView) findViewById(R.id.AutoCompleteTextViewUser_name);
        EditTextUser_password = (EditText) findViewById(R.id.EditTextUser_password);
        CheckBoxAutoLogn = (CheckBox) findViewById(R.id.CheckBoxAutoLogn);
    }

    public void onLoginButtonDown(View view) {
        /***********************************************/
        Intent i = new Intent(LoginActivity.this, SelectActivity.class);
        startActivity(i);
        /****************************/

        Toast.makeText(LoginActivity.this, "Hello", Toast.LENGTH_SHORT).show();
        username = AutoCompleteTextViewUser_name.getText().toString();
        password = EditTextUser_password.getText().toString();

        LoginAsyncTask loginAsyncTask = new LoginAsyncTask();
        String[] userArray = {username, password};
        loginAsyncTask.execute(userArray);
    }

    public class LoginAsyncTask extends AsyncTask<String, Void, ABRet> {
        @Override
        protected ABRet doInBackground(String... params) {
            return ABSDK.getInstance().loginWithUsername(params[0], params[1]);
        }

        @Override
        protected void onPostExecute(ABRet abRet) {
            super.onPostExecute(abRet);
            if (abRet.getCode().equals("00000")) {
                if (CheckBoxAutoLogn.isChecked()) {
                    Toast.makeText(LoginActivity.this, "checked", Toast.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences(ABoxConstants.AUTOLOGINFILE, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString(ABoxConstants.AutologinClass.AUTOLOGIN_USERNAME, username.trim());
                    editor.putString(ABoxConstants.AutologinClass.AUTOLOGIN_USERPSW, password.trim());
                    editor.putBoolean(ABoxConstants.AutologinClass.AUTOLOGIN_FLAG, true);
                    editor.commit();
                }
                Toast.makeText(LoginActivity.this, ABoxConstants.keyMaps.get(abRet.getCode()).toString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginActivity.this, SelectActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(LoginActivity.this, ABoxConstants.keyMaps.get(abRet.getCode()).toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
