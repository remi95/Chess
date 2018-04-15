package com.example.remim.chessremi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class SettingActivity extends AppCompatActivity {

  private ImageButton btnMenu;
  private Button btnSave;
  private Switch switchBack;
  private RadioGroup radioGroup;
  private RadioButton radioClassic, radioCustom;
  private SharedPreferences preferences;
  private String theme;
  private boolean switchBackState;

  public void initComponents() {
    btnMenu = findViewById(R.id.btn_menu);
    btnSave = findViewById(R.id.btn_save);
    switchBack = findViewById(R.id.switch_back);
    radioGroup = findViewById(R.id.radio_group);
    radioClassic = findViewById(R.id.radio_classic);
    radioCustom = findViewById(R.id.radio_custom);
    preferences = getApplicationContext().getSharedPreferences("chessSettings", Context.MODE_PRIVATE);
    theme = preferences.getString("theme", null);
    switchBackState = preferences.getBoolean("backPossibility", true);

    if (theme.equals("CUSTOM"))
      radioCustom.setChecked(true);
    else
      radioClassic.setChecked(true);

    if (switchBackState)
      switchBack.setChecked(true);

    btnMenu.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        goToMenu();
      }
    });
    btnSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        saveDatas();
      }
    });
  }

  public void saveDatas() {
    String theme = getSelectedTheme();
    boolean switchBackState = switchBack.isChecked();

    SharedPreferences preferences = getApplicationContext().getSharedPreferences("chessSettings", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putString("theme", theme);
    editor.putBoolean("backPossibility", switchBackState);
    editor.apply();
    goToMenu();
  }

  public String getSelectedTheme() {
    int selectedId = radioGroup.getCheckedRadioButtonId();
    RadioButton selectedButton = findViewById(selectedId);
    String selectedTheme = selectedButton.getTag().toString();
    return selectedTheme;
  }

  public void goToMenu() {
    Intent intentStart = new Intent(this, MenuActivity.class);
    startActivity(intentStart);
    finish();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_setting);

    initComponents();
  }
}
