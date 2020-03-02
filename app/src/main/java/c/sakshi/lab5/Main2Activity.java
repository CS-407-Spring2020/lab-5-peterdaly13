package c.sakshi.lab5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


public class Main2Activity extends AppCompatActivity {


    TextView textView2;
    public static ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        String str = sharedPreferences.getString(usernameKey, "");
        textView2 = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        textView2.setText("Hello "+ str);

        DBHelper dbHelper;
        Context context = getApplicationContext();
        SQLiteDatabase myDataBase = context.openOrCreateDatabase("notes", Context.MODE_PRIVATE, null);
        dbHelper = new DBHelper(myDataBase);
        notes= dbHelper.readNotes(str);

        ArrayList<String> displayNotes = new ArrayList<>();
        for(Note note: notes){
            displayNotes.add(String.format("Title:%s\nDate:%s",note.getTitle(), note.getDate()));
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, displayNotes);
        ListView listView = (ListView) findViewById(R.id.notesListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                intent.putExtra("noteid", position);
                startActivity(intent);
            }
        });

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
                gotoActivity3();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    public void gotoActivity1(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void gotoActivity3(){
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

}

