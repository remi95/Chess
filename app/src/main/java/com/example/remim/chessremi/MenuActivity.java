package com.example.remim.chessremi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuActivity extends AppCompatActivity {

  private Button btnTwoPlayers, btnTuto;
  private EditText etPlayer1, etPlayer2;

  public void initComponents(){
    btnTwoPlayers = findViewById(R.id.btnTwoPlayers);
    btnTuto = findViewById(R.id.btnTuto);
    etPlayer1 = findViewById(R.id.etPlayer1);
    etPlayer2 = findViewById(R.id.etPlayer2);

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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);
    initComponents();
  }
}
