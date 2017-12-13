package com.example.remim.chessremi;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

/**
 * Created by remim on 29/11/2017.
 */

public class MainActivity extends Activity {

  private TableLayout tlContent;
//  private GridLayout glContent;

  public void initComponents(){
    tlContent = findViewById(R.id.tlContent);

    TableRow.LayoutParams itemParams = new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
    itemParams.weight = 1;

    TableRow.LayoutParams rowParams = new TableRow.LayoutParams();
    rowParams.width = TableRow.LayoutParams.MATCH_PARENT;
    rowParams.height = TableRow.LayoutParams.WRAP_CONTENT;

    for(int i=0; i<8; i++){
      TableRow row = new TableRow(this);
      row.setLayoutParams(rowParams);
      row.setWeightSum(7);

      for(int j=0; j<7; j++){
          ImageView ivCase = new ImageView(this);
          ivCase.setImageResource(R.drawable.bow);
          ivCase.setScaleType(ImageView.ScaleType.FIT_CENTER);
          ivCase.setAdjustViewBounds(true);
          ivCase.setLayoutParams(itemParams);
          row.addView(ivCase);
      }

      tlContent.addView(row);
    }
//    glContent = findViewById(R.id.glContent);
//
//    for(int i=0; i<8; i++){
//      for(int j=0; j<7; j++){
//        ImageView ivCase = new ImageView(this);
//        ivCase.setImageResource(R.drawable.bow);
//        ivCase.setBackgroundColor(Color.rgb(255, 65, 83));
//        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
//        params.height = GridLayout.LayoutParams.WRAP_CONTENT;
//        params.width = GridLayout.LayoutParams.WRAP_CONTENT;
//        params.rowSpec = GridLayout.spec(i);
//        params.columnSpec = GridLayout.spec(j);
//        ivCase.setLayoutParams(params);
//        glContent.addView(ivCase);
//      }
//    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d("lifecycle","onCreate invoked");
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
