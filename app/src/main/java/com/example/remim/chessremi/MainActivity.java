package com.example.remim.chessremi;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by remim on 29/11/2017.
 */

public class MainActivity extends Activity {

  private LinearLayout llContent;
  private GridLayout glBoard;
  private TextView tvBlackPlayer;
  private TextView tvWhitePlayer;

  public void initPions(){
    Shield blackShield = new Shield(PlayerColor.Black);
    Sword blackSword = new Sword(PlayerColor.Black);
    Bow blackBow = new Bow(PlayerColor.Black);
    Spear blackSpear = new Spear(PlayerColor.Black);
    Catapult blackCatapult = new Catapult(PlayerColor.Black);
    King blackKing = new King(PlayerColor.Black);
  }

  public void initComponents(){
    llContent = findViewById(R.id.llContent);
    glBoard = findViewById(R.id.glBoard);
    tvBlackPlayer = findViewById(R.id.tvBlackPlayer);
    tvWhitePlayer = findViewById(R.id.tvWhitePlayer);


    RelativeLayout c0 = (RelativeLayout) glBoard.getChildAt(0);
    RelativeLayout c1 = (RelativeLayout) glBoard.getChildAt(1);


    ImageView img = new ImageView(this);
    img.setImageResource(blackBow.getImg());
    ImageView img2 = new ImageView(this);
    img2.setImageResource(blackShield.getImg());
    c0.addView(img);
    c1.addView(img2);



    DisplayMetrics metrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    int caseSize = metrics.widthPixels/7;

    // -------- ITEM PARAM
    TableRow.LayoutParams itemParams = new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
    itemParams.weight = 1;
    itemParams.height = caseSize;

    // --------- ROW PARAM
    TableRow.LayoutParams rowParams = new TableRow.LayoutParams();
    rowParams.width = TableRow.LayoutParams.MATCH_PARENT;
    rowParams.height = TableRow.LayoutParams.WRAP_CONTENT;


    // ---------- CHESS BOARD

//    for(int i=0; i<8; i++){
//      TableRow row = new TableRow(this);
//      row.setLayoutParams(rowParams);
//      row.setWeightSum(7);
//
//      for(int j=0; j<7; j++){
//          ImageView ivCase = new ImageView(this);
//
//          if(i==5 && j==5) {
//            Bow bow = new Bow(PlayerColor.White);
//            ivCase.setImageResource(bow.getImg());
//          }
//
//          TranslateAnimation anim = new TranslateAnimation( 0, caseSize , 0, caseSize );
//          anim.setDuration(1000);
//          anim.setFillAfter( true );
//          ivCase.startAnimation(anim);
        // --- ICONES
//          if(i == 1 || i == 6) {
//            if (j % 2 == 0)
//              ivCase.setImageResource(R.drawable.sword);
//            else
//              ivCase.setImageResource(R.drawable.shield);
//          }
//          else if(i == 0 || i == 7) {
//            if (j == 0 || j == 6)
//              ivCase.setImageResource(R.drawable.catapult);
//            else if (j == 1 || j == 5)
//              ivCase.setImageResource(R.drawable.bow);
//            else if (j == 2 || j == 4)
//              ivCase.setImageResource(R.drawable.spear);
//            else if (j == 3)
//              ivCase.setImageResource(R.drawable.crown);
//          }

        // --- COULEURS CASES
//          if(i % 2 == 0)
//            if (j % 2 == 0)
//              ivCase.setBackgroundColor(getResources().getColor(R.color.brown));
//            else
//              ivCase.setBackgroundColor(getResources().getColor(R.color.beige));
//          else
//              if (j % 2 == 0)
//                ivCase.setBackgroundColor(getResources().getColor(R.color.beige));
//              else
//                ivCase.setBackgroundColor(getResources().getColor(R.color.brown));
//
//          ivCase.setPadding(20, 20, 20, 20);
//          ivCase.setScaleType(ImageView.ScaleType.FIT_CENTER);
//          ivCase.setAdjustViewBounds(true);
//          ivCase.setLayoutParams(itemParams);
//          row.addView(ivCase);
//      }
//
//      tlBoard.addView(row);
//    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d("lifecycle","onCreate invoked");
    initPions();
    initComponents();
  }

  @Override
  protected void onStart(){
    super.onStart();
    Log.d("lifecycle","onStart invoked");
  }

  @Override
  public void onResume(){
    super.onResume();
    Log.d("lifecycle","onResume invoked");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d("lifecycle","onPause invoked");
  }
  @Override
  protected void onStop() {
    super.onStop();
    Log.d("lifecycle","onStop invoked");
  }
  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d("lifecycle","onRestart invoked");
  }
  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d("lifecycle","onDestroy invoked");
  }
}
