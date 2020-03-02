package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        if(!sharedPreferences.getString(usernameKey, "").equals("")) {
            gotoActivity2(sharedPreferences.getString(usernameKey,""));
            setContentView(R.layout.activity_main2);


        }else {
            setContentView(R.layout.activity_main);
        }
    }

    public void clickFunc(View view) {

        Log.i( "Info","Button pressed");

        EditText myTextField = (EditText) findViewById(R.id.enterName);

        String str = myTextField.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("username", str).apply();

        gotoActivity2(str);
    }

    public void gotoActivity2(String s){
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }
}
