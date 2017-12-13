package com.example.remim.chessremi;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by remim on 29/11/2017.
 */

public class MainActivity extends Activity {

  private TableLayout tlBoard;
  private TableRow trBlack;
  private TableRow trWhite;
  ArrayList<Integer> icons = new ArrayList<>();
  ArrayList<Integer> whiteIcons = new ArrayList<>();

  public void initComponents(){
    tlBoard = findViewById(R.id.tlBoard);
    trBlack = findViewById(R.id.trBlack);
    trWhite = findViewById(R.id.trWhite);

    DisplayMetrics metrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);

    // -------- ITEM PARAM
    TableRow.LayoutParams itemParams = new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
    itemParams.weight = 1;
    itemParams.height = metrics.widthPixels/7;

    // --------- ROW PARAM
    TableRow.LayoutParams rowParams = new TableRow.LayoutParams();
    rowParams.width = TableRow.LayoutParams.MATCH_PARENT;
    rowParams.height = TableRow.LayoutParams.WRAP_CONTENT;

    // --------- BLACK PART
    trBlack.setWeightSum(12);
    for(int a=0; a<12; a++){
      if(a%2 == 0){
        ImageView ivCaseBlack = new ImageView(this);
        ivCaseBlack.setImageResource(whiteIcons.get(a/2));
        ivCaseBlack.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ivCaseBlack.setAdjustViewBounds(true);
        ivCaseBlack.setPadding(10, 10, 10, 10);
        ivCaseBlack.setLayoutParams(itemParams);
        trBlack.addView(ivCaseBlack);
      }
      else{
        TextView tvCaseBlack = new TextView(this);
        tvCaseBlack.setText("0");
        tvCaseBlack.setTextColor(Color.rgb(255, 255, 255));
        tvCaseBlack.setGravity(Gravity.CENTER);
        tvCaseBlack.setTextSize(5,4);
        tvCaseBlack.setLayoutParams(itemParams);
        trBlack.addView(tvCaseBlack);
      }
    }

    // ---------- WHITE PART

    trWhite.setWeightSum(12);
    for(int a=0; a<12; a++){
      if(a%2 == 0){
        ImageView ivCaseWhite = new ImageView(this);
        ivCaseWhite.setImageResource(icons.get(a/2));
        ivCaseWhite.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ivCaseWhite.setAdjustViewBounds(true);
        ivCaseWhite.setPadding(10, 10, 10, 10);
        ivCaseWhite.setLayoutParams(itemParams);
        trWhite.addView(ivCaseWhite);
      }
      else{
        TextView tvCaseWhite = new TextView(this);
        tvCaseWhite.setText("0");
        tvCaseWhite.setTextColor(Color.rgb(0, 0, 0));
        tvCaseWhite.setGravity(Gravity.CENTER);
        tvCaseWhite.setTextSize(5,4);
        tvCaseWhite.setLayoutParams(itemParams);
        trWhite.addView(tvCaseWhite);
      }
    }

    // ---------- CHESS BOARD

    for(int i=0; i<8; i++){
      TableRow row = new TableRow(this);
      row.setLayoutParams(rowParams);
      row.setWeightSum(7);

      for(int j=0; j<7; j++){
          ImageView ivCase = new ImageView(this);

        // --- ICONES
          if(i == 1 || i == 6) {
            if (j % 2 == 0)
              ivCase.setImageResource(R.drawable.sword);
            else
              ivCase.setImageResource(R.drawable.shield);
          }
          else if(i == 0 || i == 7) {
            if (j == 0 || j == 6)
              ivCase.setImageResource(R.drawable.catapult);
            else if (j == 1 || j == 5)
              ivCase.setImageResource(R.drawable.bow);
            else if (j == 2 || j == 4)
              ivCase.setImageResource(R.drawable.spear);
            else if (j == 3)
              ivCase.setImageResource(R.drawable.crown);
          }

        // --- COULEURS CASES
          if(i % 2 == 0)
            if (j % 2 == 0)
              ivCase.setBackgroundColor(getResources().getColor(R.color.brown));
            else
              ivCase.setBackgroundColor(getResources().getColor(R.color.beige));
          else
              if (j % 2 == 0)
                ivCase.setBackgroundColor(getResources().getColor(R.color.beige));
              else
                ivCase.setBackgroundColor(getResources().getColor(R.color.brown));

          ivCase.setPadding(20, 20, 20, 20);
          ivCase.setScaleType(ImageView.ScaleType.FIT_CENTER);
          ivCase.setAdjustViewBounds(true);
          ivCase.setLayoutParams(itemParams);
          row.addView(ivCase);
      }

      tlBoard.addView(row);
    }
  }

  public void initIcons(){
    icons.add(R.drawable.shield);
    icons.add(R.drawable.sword);
    icons.add(R.drawable.bow);
    icons.add(R.drawable.spear);
    icons.add(R.drawable.catapult);
    icons.add(R.drawable.crown);

    whiteIcons.add(R.drawable.w_shield);
    whiteIcons.add(R.drawable.w_sword);
    whiteIcons.add(R.drawable.w_bow);
    whiteIcons.add(R.drawable.w_spear);
    whiteIcons.add(R.drawable.w_catapult);
    whiteIcons.add(R.drawable.w_crown);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d("lifecycle","onCreate invoked");
    initIcons();
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
