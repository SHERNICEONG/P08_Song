package sg.edu.rp.c346.id22017424.p08_song;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SongsActivity extends AppCompatActivity {
    private ListView listView;
    private DBHelper dbHelper;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        listView = findViewById(R.id.listView);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SongsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        dbHelper = new DBHelper(this);

        List<Song> songs = dbHelper.getAllSongs();
        ArrayAdapter<Song> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songs);
        listView.setAdapter(adapter);
    }
}
