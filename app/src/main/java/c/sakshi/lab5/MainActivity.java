package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickFunc(View view) {

        Log.i( "Info","Button pressed");

        EditText myTextField = (EditText) findViewById(R.id.enterName);

        //Toast.makeText(MainActivity.this, myTextField.getText().toString(), Toast.LENGTH_LONG).show();

        String str = myTextField.getText().toString();

        gotoActivity2(str);
    }

    public void gotoActivity2(String s){
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }
}
