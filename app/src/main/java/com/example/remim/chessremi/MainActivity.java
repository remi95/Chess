package com.example.remim.chessremi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
  private Shield blackShield, whiteShield;
  private Sword blackSword, whiteSword;
  private Bow blackBow, whiteBow;
  private Spear blackSpear, whiteSpear;
  private Catapult blackCatapult, whiteCatapult;
  private King blackKing, whiteKing;
  private ArrayList<RelativeLayout> allCases = new ArrayList<>();
  private ArrayList<RelativeLayout> changedCases = new ArrayList<>();
  private RelativeLayout.OnClickListener clickListener;
  private RelativeLayout lastClickedCase;
  private boolean pieceRight, pieceLeft;

  public void initPions(){
//    BLACK PIONS
    blackShield = new Shield(PlayerColor.Black);
    blackSword = new Sword(PlayerColor.Black);
    blackBow = new Bow(PlayerColor.Black);
    blackSpear = new Spear(PlayerColor.Black);
    blackCatapult = new Catapult(PlayerColor.Black);
    blackKing = new King(PlayerColor.Black);

//    WHITE PIONS
    whiteShield = new Shield(PlayerColor.White);
    whiteSword = new Sword(PlayerColor.White);
    whiteBow = new Bow(PlayerColor.White);
    whiteSpear = new Spear(PlayerColor.White);
    whiteCatapult = new Catapult(PlayerColor.White);
    whiteKing = new King(PlayerColor.White);
  }

  public void posPieces(Piece piece, int xPos, int yPos){
//    TRANSLATE DP UNITS TO PX
    int padding_dp = 10;
    final float scale = getResources().getDisplayMetrics().density;
    int padding_px = (int) (padding_dp * scale + 0.5f);

//    IMAGE PARAMETERS
    ImageView img = new ImageView(this);
    img.setPadding(padding_px, padding_px, padding_px, padding_px);
    img.setScaleType(ImageView.ScaleType.FIT_CENTER);
    img.setAdjustViewBounds(true);
    img.setImageResource(piece.getImg());
    img.setTag(piece);

    RelativeLayout.LayoutParams lpImg = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
    lpImg.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
    img.setLayoutParams(lpImg);

//    IMAGE POSITION
    int numCase = (yPos * 8) + xPos;
    RelativeLayout targetCase = (RelativeLayout) glBoard.getChildAt(numCase);
    targetCase.addView(img);
  }

  public void initComponents(){
    llContent = findViewById(R.id.llContent);
    glBoard = findViewById(R.id.glBoard);
    tvBlackPlayer = findViewById(R.id.tvBlackPlayer);
    tvWhitePlayer = findViewById(R.id.tvWhitePlayer);

    DisplayMetrics metrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    int caseSize = metrics.widthPixels/8;




//    EACH CASE HAS A CLICK LISTENER
    for(int i = 0; i < glBoard.getChildCount(); i++){
      GridLayout.LayoutParams glParams = new GridLayout.LayoutParams();
      glParams.width = caseSize;
      glParams.height = caseSize;
      RelativeLayout rlEachCase = (RelativeLayout) glBoard.getChildAt(i);
      rlEachCase.setOnClickListener(clickListener);
      rlEachCase.setLayoutParams(glParams);
      allCases.add(rlEachCase);
    }

//    glBoard.setOnClickListener(clickListener);

//    PIECES POSITIONS
    posPieces(blackCatapult, 0, 0);
    posPieces(blackBow, 1, 0);
    posPieces(blackSpear, 2, 0);
    posPieces(blackKing, 3, 0);
    posPieces(blackKing, 4, 0);
    posPieces(blackSpear, 5, 0);
    posPieces(blackBow, 6, 0);
    posPieces(blackCatapult, 7, 0);
    posPieces(blackSword, 0, 1);
    posPieces(blackShield, 1, 1);
    posPieces(blackSword, 2, 1);
    posPieces(blackShield, 3, 1);
    posPieces(blackShield, 4, 1);
    posPieces(blackSword, 5, 1);
    posPieces(blackShield, 6, 1);
    posPieces(blackSword, 7, 1);

    posPieces(whiteSword, 0, 6);
    posPieces(whiteShield, 1, 6);
    posPieces(whiteSword, 2, 6);
    posPieces(whiteShield, 3, 6);
    posPieces(whiteShield, 4, 6);
    posPieces(whiteSword, 5, 6);
    posPieces(whiteShield, 6, 6);
    posPieces(whiteSword, 7, 6);
    posPieces(whiteCatapult, 0, 7);
    posPieces(whiteBow, 1, 7);
    posPieces(whiteSpear, 2, 7);
    posPieces(whiteKing, 3, 7);
    posPieces(whiteKing, 4, 7);
    posPieces(whiteSpear, 5, 7);
    posPieces(whiteBow, 6, 7);
    posPieces(whiteCatapult, 7, 7);
  }

  public void caseClickListener(){
    clickListener = new RelativeLayout.OnClickListener() {
      @Override
      public void onClick(View v) {

//        GET CLICKED CASE
        RelativeLayout clickedCase = (RelativeLayout) v;

        for (RelativeLayout eachCase : changedCases){
          if (clickedCase.equals(eachCase)){
//            MOVE
            if (clickedCase.getChildCount() == 0){
//              CALL MOVE FUNCTION
              ImageView targetPiece = (ImageView) lastClickedCase.getChildAt(0);
              lastClickedCase.removeView(targetPiece);
              clickedCase.addView(targetPiece);
            }
//            ACTION
            else{
//              CALL ACTION FUNCTION
            }
          }
        }

//        RESET CASES COLORS
        resetCasesColors();
        changedCases.clear();

//        GET PIECE AND CALL MOVES AND ACTIONS FUNCTIONS
        if (clickedCase.getChildCount() > 0){
          lastClickedCase = clickedCase;
          int numCase = glBoard.indexOfChild(clickedCase);
          ImageView ivImg = (ImageView) clickedCase.getChildAt(0);
          Piece piece = (Piece) ivImg.getTag();

          if ((numCase + 1) % 8 == 0 || (numCase + 2 ) % 8 == 0) {
            pieceRight = true;
            pieceLeft = false;
          }
          else if (numCase % 8 == 0 || (numCase - 1) % 8 == 0) {
            pieceLeft = true;
            pieceRight = false;
          }
          else {
            pieceLeft = false;
            pieceRight = false;
          }

          showMoves(piece, numCase);
          showActions(piece, numCase);
        }
      }
    };
  }

  public void showMoves(Piece piece, int numCase){
    ArrayList<Coords> moves = piece.getMoves();
    PlayerColor myColor = piece.getColor();
    boolean fakeCase;

    for (Coords move : moves){
      int x = move.getX();
      int y = move.getY();
//      COLOR PLAYER PLAY ON DIRECTION
      int targetNumCase = numCase + (y * 8) + x;
      if(myColor == PlayerColor.White)
        targetNumCase = numCase - (y * 8) - x;

//      CHECK FAKE CASE
      if (pieceRight && ( (targetNumCase % 8 == 0) || ((targetNumCase - 1) % 8 == 0) ))
        fakeCase = true;
      else if (pieceLeft && ( ((targetNumCase + 1) % 8 == 0) || ((targetNumCase +2) % 8 == 0) ))
        fakeCase = true;
      else
        fakeCase = false;

//      GREEN IF FREE
      if (targetNumCase > 0 && targetNumCase < 64 && !fakeCase) {
        RelativeLayout targetCase = (RelativeLayout) glBoard.getChildAt(targetNumCase);
        if (targetCase.getChildCount() == 0) {
          targetCase.setBackgroundColor(getResources().getColor(R.color.green));
          changedCases.add(targetCase);
        }
      }
    }
  }

  public void showActions(Piece piece, int numCase){
    ArrayList<Coords> actions = piece.getActions();
    PlayerColor myColor = piece.getColor();
    boolean fakeCase;

    for (Coords action : actions){
      int x = action.getX();
      int y = action.getY();
//      COLOR PLAYER PLAY ON DIRECTION
      int targetNumCase = numCase + (y*8) + x;
      if(myColor == PlayerColor.White) {
        targetNumCase = numCase - (y * 8) - x;
      }

      //      CHECK FAKE CASE
      if (pieceRight && ( (targetNumCase % 8 == 0) || ((targetNumCase - 1) % 8 == 0) ))
        fakeCase = true;
      else if (pieceLeft && ( ((targetNumCase + 1) % 8 == 0) || ((targetNumCase +2) % 8 == 0) ))
        fakeCase = true;
      else
        fakeCase = false;

//      IF PIECE, CHECK IF IS ENNEMY -> RED
      if (targetNumCase >= 0 && targetNumCase < 64 && !fakeCase) {
        RelativeLayout targetCase = (RelativeLayout) glBoard.getChildAt(targetNumCase);
        if (targetCase.getChildCount() > 0) {
          ImageView neighbor = (ImageView) targetCase.getChildAt(0);
          Piece neighborClass = (Piece) neighbor.getTag();
          PlayerColor neighborColor = neighborClass.getColor();
          boolean isEnnemy = (neighborColor != myColor);
          if (isEnnemy) {
            targetCase.setBackgroundColor(getResources().getColor(R.color.red));
            changedCases.add(targetCase);
          }
        }
      }
    }
  }

  public void resetCasesColors(){
    for (RelativeLayout eachCase : changedCases){
//      CALCUL COORDINATES
      int numCase = glBoard.indexOfChild(eachCase);
      int y = (int) numCase / 8;
      int x = numCase % 8;
      if (y % 2 == 0){
        if (x % 2 == 0){
          eachCase.setBackgroundColor(getResources().getColor(R.color.brown));
        }
        else{
          eachCase.setBackgroundColor(getResources().getColor(R.color.beige));
        }
      }
      else{
        if (x % 2 == 0){
          eachCase.setBackgroundColor(getResources().getColor(R.color.beige));
        }
        else{
          eachCase.setBackgroundColor(getResources().getColor(R.color.brown));
        }
      }
    }
  }



  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d("lifecycle","onCreate invoked");

    caseClickListener();
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
