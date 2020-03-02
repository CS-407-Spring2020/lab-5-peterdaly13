package c.sakshi.lab5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;


public class Main2Activity extends AppCompatActivity {


    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        String str = sharedPreferences.getString(usernameKey, "");
        textView2 = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        //String str =intent.getStringExtra("message");


        textView2.setText("Hello "+ str);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
                sharedPreferences.edit().remove("username").apply();
                gotoActivity1();
                return true;
            case R.id.item2:

                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    public void gotoActivity1(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}

