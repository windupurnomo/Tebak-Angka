package id.go.lemsaneg.tebakangka;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private EditText txtPlayer;
    private Button btnPlay, btnNewPlayer, btnSelectPlayer;
    private Spinner spnPlayers;
    private SharedPreferences preferences;
    private List<String> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        txtPlayer = (EditText) findViewById(R.id.txtPlayer);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnSelectPlayer = (Button) findViewById(R.id.btnSelectPlayer);
        btnNewPlayer = (Button) findViewById(R.id.btnNewPlayer);
        spnPlayers = (Spinner) findViewById(R.id.spnPlayers);

        preferences = getPreferences(Context.MODE_PRIVATE);
        String s = preferences.getString("PLAYERS", null);//"Amin;Imam;Budi";
        if (s == null) {
            players = new ArrayList<>();
            viewMode(0);
        } else {
            stringToPlayers(s);
            viewMode(1);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                players);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPlayers.setAdapter(adapter);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player = txtPlayer.getText().toString();
                if (player.equals("")) {
                    //ambil player dari spinner
                    player = spnPlayers.getSelectedItem().toString();
                } else {
                    //tambahkan ke players
                    players.add(player);
                    //udpate shared preferences
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("PLAYERS", playersToString());
                    editor.commit();
                }
                //set current user
                //pindah ke Main Activity
                Intent intent = new Intent(UserActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(UserActivity.this, "Selamat Datang " + player, Toast.LENGTH_LONG).show();
            }
        });

        btnNewPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMode(0);
            }
        });

        btnSelectPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMode(1);
            }
        });
    }

    private String playersToString() {
        String temp = "";
        for (int i = 0; i < players.size(); i++) {
            temp += players.get(i) + ";";
        }
        temp.substring(0, temp.length() - 2);
        return temp;// => "Amin;Imam;Budi"
    }

    private void stringToPlayers(String s) {
        String[] temp = s.split(";");
        for (int i = 0; i < temp.length; i++) {
            players.add(temp[i]);
        }
    }

    private void viewMode(int i) {
        if (i == 0) {
            spnPlayers.setVisibility(View.GONE);
            txtPlayer.setVisibility(View.VISIBLE);
            btnNewPlayer.setVisibility(View.GONE);
            btnSelectPlayer.setVisibility(View.VISIBLE);
        } else {
            spnPlayers.setVisibility(View.VISIBLE);
            txtPlayer.setVisibility(View.GONE);
            btnNewPlayer.setVisibility(View.VISIBLE);
            btnSelectPlayer.setVisibility(View.GONE);
        }
    }
}
