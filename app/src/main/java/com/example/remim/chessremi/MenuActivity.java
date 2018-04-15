package com.example.remim.chessremi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

  private ImageButton btnSettings;
  private Button btnTwoPlayers, btnTuto;
  private EditText etPlayer1, etPlayer2;

  public void initComponents(){
    btnSettings = findViewById(R.id.settings);
    btnTwoPlayers = findViewById(R.id.btnTwoPlayers);
    btnTuto = findViewById(R.id.btnTuto);
    etPlayer1 = findViewById(R.id.etPlayer1);
    etPlayer2 = findViewById(R.id.etPlayer2);

    btnSettings.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        goToSettings();
      }
    });
    btnTwoPlayers.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        goToChessboard();
      }
    });
    btnTuto.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        goToTuto();
      }
    });

    SharedPreferences preferences = getApplicationContext().getSharedPreferences("chessSettings", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();
    if (preferences.getString("theme", null) == null)
      editor.putString("theme", "CLASSIC");
    if (preferences.getBoolean("backPossibility", true))
      editor.putBoolean("backPossibility", true);
    editor.apply();
  }

  public void goToChessboard(){
    Intent intentStart = new Intent(this, MainActivity.class);
    String player1 = etPlayer1.getText().toString();
    String player2 = etPlayer2.getText().toString();
    intentStart.putExtra("player1", player1);
    intentStart.putExtra("player2", player2);
    startActivity(intentStart);
    finish();
  }

  public void goToTuto(){
    Intent intentStart = new Intent(this, TutoActivity.class);
    startActivity(intentStart);
    finish();
  }

  public void goToSettings() {
    Intent intentStart = new Intent(this, SettingActivity.class);
    startActivity(intentStart);
    finish();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);
    initComponents();
  }
}
