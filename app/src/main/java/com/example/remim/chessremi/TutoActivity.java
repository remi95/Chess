package com.example.remim.chessremi;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class TutoActivity extends AppCompatActivity {

  private ArrayList<TutoPage> tutoPages;
  private Button btnMenu;

  public void initComponents() {
    btnMenu = findViewById(R.id.btn_menu);
    initTutos();

    ViewPager viewPager = findViewById(R.id.vp_tutos);
    TutoPagerAdapter tutoPagerAdapter = new TutoPagerAdapter(this, tutoPages);
    viewPager.setAdapter(tutoPagerAdapter);

    btnMenu.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        goToMenu();
      }
    });
  }

  public void initTutos() {
    tutoPages = new ArrayList<TutoPage>();
    tutoPages.add(new TutoPage(getString(R.string.shield), R.drawable.shield_move, getString(R.string.shield_move)));
    tutoPages.add(new TutoPage(getString(R.string.shield), R.drawable.shield_life, getString(R.string.shield_life)));
    tutoPages.add(new TutoPage(getString(R.string.sword), R.drawable.sword_move, getString(R.string.sword_move)));
    tutoPages.add(new TutoPage(getString(R.string.sword), R.drawable.sword_action, getString(R.string.sword_action)));
    tutoPages.add(new TutoPage(getString(R.string.bow), R.drawable.bow_move, getString(R.string.bow_move)));
    tutoPages.add(new TutoPage(getString(R.string.bow), R.drawable.bow_action, getString(R.string.bow_action)));
    tutoPages.add(new TutoPage(getString(R.string.catapult), R.drawable.catapult_move, getString(R.string.catapult_move)));
    tutoPages.add(new TutoPage(getString(R.string.catapult), R.drawable.catapult_action, getString(R.string.catapult_action)));
    tutoPages.add(new TutoPage(getString(R.string.spear), R.drawable.spear_move, getString(R.string.spear_move)));
    tutoPages.add(new TutoPage(getString(R.string.spear), R.drawable.spear_action, getString(R.string.spear_action)));
    tutoPages.add(new TutoPage(getString(R.string.spear), R.drawable.spear_action_special_1, getString(R.string.spear_action_special_1)));
    tutoPages.add(new TutoPage(getString(R.string.spear), R.drawable.spear_action_special_2, getString(R.string.spear_action_special_2)));
    tutoPages.add(new TutoPage(getString(R.string.spear), R.drawable.spear_action_special_3, getString(R.string.spear_action_special_3)));
    tutoPages.add(new TutoPage(getString(R.string.queen), R.drawable.queen_move, getString(R.string.queen_move)));
    tutoPages.add(new TutoPage(getString(R.string.queen), R.drawable.queen_action, getString(R.string.queen_action)));
    tutoPages.add(new TutoPage(getString(R.string.king), R.drawable.king_move, getString(R.string.king_move)));
    tutoPages.add(new TutoPage(getString(R.string.king), R.drawable.king_action, getString(R.string.king_action )));
  }

  public void goToMenu() {
    Intent intentStart = new Intent(this, MenuActivity.class);
    startActivity(intentStart);
    finish();
  }

  @Override
  public void onBackPressed() {
    goToMenu();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tuto);
    initComponents();
  }
}
