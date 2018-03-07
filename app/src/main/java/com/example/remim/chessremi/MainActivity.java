package com.example.remim.chessremi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by remim on 29/11/2017.
 */

public class MainActivity extends Activity {

  private Context context;
  private RelativeLayout rlContent;
  private GridLayout glBoard;
  private String player1, player2;
  private TextView tvBlackPlayer, tvWhitePlayer;
  private Shield blackShield_1, blackShield_2, blackShield_3, blackShield_4,
    whiteShield_1, whiteShield_2, whiteShield_3, whiteShield_4;
  private Sword blackSword_1, blackSword_2, blackSword_3, blackSword_4,
    whiteSword_1, whiteSword_2, whiteSword_3, whiteSword_4;
  private Bow blackBow_1, blackBow_2, whiteBow_1, whiteBow_2;
  private Spear blackSpear_1, blackSpear_2, whiteSpear_1, whiteSpear_2;
  private Catapult blackCatapult_1, blackCatapult_2, whiteCatapult_1, whiteCatapult_2;
  private King blackKing, whiteKing;
  private Queen blackQueen, whiteQueen;
  private ArrayList<RelativeLayout> allCases = new ArrayList<>();
  private ArrayList<RelativeLayout> changedCases = new ArrayList<>();
  private RelativeLayout.OnClickListener caseClickListener;
  private Button btnPause, btnWhiteFinish, btnBlackFinish, btnBlackCancel, btnWhiteCancel;
  private Button.OnClickListener finishClickListener, optionsClickListener, cancelClickListener;
  private RelativeLayout lastClickedCase;
  private boolean pieceRight, pieceLeft, isWhiteTurn, hasMoved, isCancellable;
  private Piece playerInMove;
  private int lastPosition, currentPosition;

  public void caseClickListener(){
    caseClickListener = new RelativeLayout.OnClickListener() {
      @Override
      public void onClick(View v) {

//        GET CLICKED CASE
        RelativeLayout clickedCase = (RelativeLayout) v;

//        MOVE OR ACTION ?
        for (RelativeLayout eachCase : changedCases){
          if (clickedCase.equals(eachCase)){
            if (clickedCase.getChildCount() == 0) {
              move(lastClickedCase, clickedCase);
              break;
            }
            else {
              action(clickedCase);
              return;
            }
          }
        }

//        RESET CASES COLORS
        resetCasesColors();
        changedCases.clear();

//        GET PIECE AND CALL MOVES AND ACTIONS FUNCTIONS
        if (clickedCase.getChildCount() > 0){
          ImageView ivImg = (ImageView) clickedCase.getChildAt(0);
          Piece piece = (Piece) ivImg.getTag();
          PlayerColor color = piece.getColor();

          if ((isWhiteTurn && color == PlayerColor.White) || (!isWhiteTurn && color == PlayerColor.Black)) {
            lastClickedCase = clickedCase;
            int numCase = glBoard.indexOfChild(clickedCase);

            piecePlacement(numCase);

            if (!hasMoved)
              showMoves(piece, numCase);
            showActions(piece, numCase);
          }

          if (hasMoved && changedCases.isEmpty() && piece == playerInMove)
            changeTurn();
        }
      }
    };
  }

  public void btnFinishClickListener(){
    finishClickListener = new Button.OnClickListener() {
      @Override
      public void onClick(View v) {
        Button clickedBtn = (Button) v;
        if ((clickedBtn == btnWhiteFinish && isWhiteTurn) || (clickedBtn == btnBlackFinish && !isWhiteTurn)) {
          if (hasMoved)
            changeTurn();
          else
            Toast.makeText(context, "Vous devez obligatoirement déplacer un pion", Toast.LENGTH_SHORT).show();
        }
      }
    };
  }

  public void btnOptionsClickListener(){
    optionsClickListener = new Button.OnClickListener() {
      @Override
      public void onClick(View v) {
        openPopup("Pause");
      }
    };
  }

  public void btnCancelClickListener() {
    cancelClickListener = new Button.OnClickListener() {
      @Override
      public void onClick(View v) {
        Button clickedBtn = (Button) v;
        if (isCancellable) {
          RelativeLayout currentCase = (RelativeLayout) glBoard.getChildAt(currentPosition);
          RelativeLayout targetCase = (RelativeLayout) glBoard.getChildAt(lastPosition);
          move(currentCase, targetCase);
          resetCasesColors();
          changedCases.clear();
          btnWhiteCancel.setEnabled(false);
          btnBlackCancel.setEnabled(false);
        }
      }
    };
  }

  public void initPions(){
//    BLACK PIONS
    blackShield_1 = new Shield(PlayerColor.Black);
    blackShield_2 = new Shield(PlayerColor.Black);
    blackShield_3 = new Shield(PlayerColor.Black);
    blackShield_4 = new Shield(PlayerColor.Black);
    blackSword_1 = new Sword(PlayerColor.Black);
    blackSword_2 = new Sword(PlayerColor.Black);
    blackSword_3 = new Sword(PlayerColor.Black);
    blackSword_4 = new Sword(PlayerColor.Black);
    blackBow_1 = new Bow(PlayerColor.Black);
    blackBow_2 = new Bow(PlayerColor.Black);
    blackSpear_1 = new Spear(PlayerColor.Black);
    blackSpear_2 = new Spear(PlayerColor.Black);
    blackCatapult_1 = new Catapult(PlayerColor.Black);
    blackCatapult_2 = new Catapult(PlayerColor.Black);
    blackKing = new King(PlayerColor.Black);
    blackQueen = new Queen(PlayerColor.Black);

//    WHITE PIONS
    whiteShield_1 = new Shield(PlayerColor.White);
    whiteShield_2 = new Shield(PlayerColor.White);
    whiteShield_3 = new Shield(PlayerColor.White);
    whiteShield_4 = new Shield(PlayerColor.White);
    whiteSword_1 = new Sword(PlayerColor.White);
    whiteSword_2 = new Sword(PlayerColor.White);
    whiteSword_3 = new Sword(PlayerColor.White);
    whiteSword_4 = new Sword(PlayerColor.White);
    whiteBow_1 = new Bow(PlayerColor.White);
    whiteBow_2 = new Bow(PlayerColor.White);
    whiteSpear_1 = new Spear(PlayerColor.White);
    whiteSpear_2 = new Spear(PlayerColor.White);
    whiteCatapult_1 = new Catapult(PlayerColor.White);
    whiteCatapult_2 = new Catapult(PlayerColor.White);
    whiteKing = new King(PlayerColor.White);
    whiteQueen = new Queen(PlayerColor.White);
  }

  public void initComponents(){
    rlContent = findViewById(R.id.glContent);
    glBoard = findViewById(R.id.glBoard);
    tvBlackPlayer = findViewById(R.id.tvBlackPlayer);
    tvWhitePlayer = findViewById(R.id.tvWhitePlayer);

    DisplayMetrics metrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    int caseSize = metrics.widthPixels/8;

//    EACH CASE HAS A CLICK LISTENER & FORCE SQUARE CASE
    for(int i = 0; i < glBoard.getChildCount(); i++){
      GridLayout.LayoutParams glParams = new GridLayout.LayoutParams();
      glParams.width = caseSize;
      glParams.height = caseSize;
      RelativeLayout rlEachCase = (RelativeLayout) glBoard.getChildAt(i);
      rlEachCase.setOnClickListener(caseClickListener);
      rlEachCase.setLayoutParams(glParams);
      allCases.add(rlEachCase);
    }

    btnPause = findViewById(R.id.btnPause);
    btnWhiteFinish = findViewById(R.id.btnWhiteFinish);
    btnBlackFinish = findViewById(R.id.btnBlackFinish);
    btnBlackCancel = findViewById(R.id.btnBlackCancel);
    btnWhiteCancel = findViewById(R.id.btnWhiteCancel);

    btnWhiteFinish.setOnClickListener(finishClickListener);
    btnBlackFinish.setOnClickListener(finishClickListener);
    btnBlackCancel.setOnClickListener(cancelClickListener);
    btnWhiteCancel.setOnClickListener(cancelClickListener);
    btnPause.setOnClickListener(optionsClickListener);

    Intent intent = getIntent();
    Bundle extras = intent.getExtras();

    if (extras != null) {
      String strExtra1 = intent.getStringExtra("player1");
      String strExtra2 = intent.getStringExtra("player2");
      player1 = strExtra1.equals("") ? "Joueur 1" : strExtra1;
      player2 = strExtra2.equals("") ? "Joueur 2" : strExtra2;
    }

    tvWhitePlayer.setText(player1);
    tvBlackPlayer.setText(player2);

    btnWhiteCancel.setEnabled(false);
    btnBlackCancel.setEnabled(false);

//    glBoard.setOnClickListener(clickListener);

//    PIECES POSITIONS
    posPieces(blackCatapult_1, 0, 0);
    posPieces(blackBow_1, 1, 0);
    posPieces(blackSpear_1, 2, 0);
    posPieces(blackKing, 3, 0);
    posPieces(blackQueen, 4, 0);
    posPieces(blackSpear_2, 5, 0);
    posPieces(blackBow_2, 6, 0);
    posPieces(blackCatapult_2, 7, 0);
    posPieces(blackSword_1, 0, 1);
    posPieces(blackShield_1, 1, 1);
    posPieces(blackSword_2, 2, 1);
    posPieces(blackShield_2, 3, 1);
    posPieces(blackShield_3, 4, 1);
    posPieces(blackSword_3, 5, 1);
    posPieces(blackShield_4, 6, 1);
    posPieces(blackSword_4, 7, 1);

    posPieces(whiteSword_1, 0, 6);
    posPieces(whiteShield_1, 1, 6);
    posPieces(whiteSword_2, 2, 6);
    posPieces(whiteShield_2, 3, 6);
    posPieces(whiteShield_3, 4, 6);
    posPieces(whiteSword_3, 5, 6);
    posPieces(whiteShield_4, 6, 6);
    posPieces(whiteSword_4, 7, 6);
    posPieces(whiteCatapult_1, 0, 7);
    posPieces(whiteBow_1, 1, 7);
    posPieces(whiteSpear_1, 2, 7);
    posPieces(whiteKing, 3, 7);
    posPieces(whiteQueen, 4, 7);
    posPieces(whiteSpear_2, 5, 7);
    posPieces(whiteBow_2, 6, 7);
    posPieces(whiteCatapult_2, 7, 7);

    isWhiteTurn = true;
    hasMoved = false;
    isCancellable = false;
    lastPosition = 0;
    currentPosition = 0;
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

  public void piecePlacement(int numCase){
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
  }

  public void showMoves(Piece piece, int numCase){
    ArrayList<Coords> moves = piece.getMoves();
    PlayerColor myColor = piece.getColor();

    for (Coords move : moves){
      int x = move.getX();
      int y = move.getY();
//      COLOR PLAYER PLAY ON DIRECTION
      int targetNumCase = numCase + (y * 8) + x;
      if(myColor == PlayerColor.White)
        targetNumCase = numCase - (y * 8) - x;

//      CHECK FAKE CASE
      boolean fakeCase = isFakeCase(targetNumCase);

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

    for (Coords action : actions){
      int x = action.getX();
      int y = action.getY();
//      COLOR PLAYER PLAY ON DIRECTION
      int targetNumCase = numCase + (y*8) + x;
      if(myColor == PlayerColor.White)
        targetNumCase = numCase - (y * 8) - x;

      //      CHECK FAKE CASE
      boolean fakeCase = isFakeCase(targetNumCase);

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
//          else if (piece.getClass().getSimpleName().equals("Spear")) {
//            return;
//          }
        }
      }
    }
  }

  public boolean isFakeCase(int targetNumCase){
    boolean fakeCase;
    if (pieceRight && ( (targetNumCase % 8 == 0) || ((targetNumCase - 1) % 8 == 0) ))
      fakeCase = true;
    else if (pieceLeft && ( ((targetNumCase + 1) % 8 == 0) || ((targetNumCase +2) % 8 == 0) ))
      fakeCase = true;
    else
      fakeCase = false;
    return fakeCase;
  }

  public void move(RelativeLayout caseToLeave, RelativeLayout targetCase){
    ImageView targetPiece = (ImageView) caseToLeave.getChildAt(0);
    Piece piece = (Piece) targetPiece.getTag();
    caseToLeave.removeView(targetPiece);
    targetCase.addView(targetPiece);
    hasMoved = !hasMoved;
    playerInMove = piece;
    toggleCancellable(true);
    lastPosition = glBoard.indexOfChild(caseToLeave);
    currentPosition = glBoard.indexOfChild(targetCase);
  }

  public void action(RelativeLayout clickedCase){
//    FOR SPEAR PIECE ONLY
    if (lastClickedCase.getChildAt(0).getTag().getClass().getSimpleName().equals("Spear")) {
      boolean isBlocked = spearAction(clickedCase);
      if (isBlocked)
        return;
    }

//    GET PIECE INFOS
    ImageView targetPieceImg = (ImageView) clickedCase.getChildAt(0);
    Piece targetPiece = (Piece) targetPieceImg.getTag();
    PlayerColor color = targetPiece.getColor();
    String className = targetPiece.getClass().getSimpleName();

    targetPiece.decreaseLife();

    if (targetPiece.getLife() == 0) {
      String idString = "tv" + String.valueOf(color) + className;
      int tvId = getResources().getIdentifier(idString, "id", getPackageName());
      TextView tvTarget = findViewById(tvId);
      int previousValue = Integer.parseInt(tvTarget.getText().toString());

      tvTarget.setText(String.valueOf(previousValue - 1));
      clickedCase.removeView(targetPieceImg);

      if (className.equals("King")){
        win(color);
      }
    }
    else if (targetPiece.getLife() == 1) {
      if (className.equals("Shield")) {
        int brokenShield = color == PlayerColor.Black ? R.drawable.b_broken_shield : R.drawable.w_broken_shield;
        targetPieceImg.setImageResource(brokenShield);
      }
    }
    changeTurn();
  }

  public boolean spearAction(RelativeLayout clickedCase){
    int spearPos = glBoard.indexOfChild(lastClickedCase);
    int clickedPos = glBoard.indexOfChild(clickedCase);

//    WHEN SECOND ACTION CASE IS CLICKED
    if (Math.abs(spearPos - clickedPos) == 16) {
      int otherTouched = spearPos < clickedPos ? spearPos + 8 : spearPos - 8;
      RelativeLayout otherCaseTouched = (RelativeLayout) glBoard.getChildAt(otherTouched);

      if (otherCaseTouched.getChildCount() > 0) {
        Piece otherPiece = (Piece) otherCaseTouched.getChildAt(0).getTag();
        PlayerColor otherPieceColor = otherPiece.getColor();

        if ((otherPieceColor == PlayerColor.White && isWhiteTurn) || (otherPieceColor == PlayerColor.Black && !isWhiteTurn))
          Toast.makeText(context, "Traître, essaie de ne pas attaquer tes alliés", Toast.LENGTH_SHORT).show();

        if (otherPiece.getClass().getSimpleName().equals("Shield")) {
          action(otherCaseTouched);
          return true;
        }
        else {
          action(otherCaseTouched);
          changeTurn();
        }
      }
    }
    return false;
  }

  public void resetCasesColors(){
    for (RelativeLayout eachCase : changedCases){
//      CALCUL COORDINATES
      int numCase = glBoard.indexOfChild(eachCase);
      int y = (int) numCase / 8;
      int x = numCase % 8;
      if (y % 2 == 0){
        if (x % 2 == 0)
          eachCase.setBackgroundColor(getResources().getColor(R.color.brown));
        else
          eachCase.setBackgroundColor(getResources().getColor(R.color.beige));
      }
      else{
        if (x % 2 == 0)
          eachCase.setBackgroundColor(getResources().getColor(R.color.beige));
        else
          eachCase.setBackgroundColor(getResources().getColor(R.color.brown));
      }
    }
  }

  public void toggleCancellable(boolean toggle) {
    isCancellable = toggle;
    if (isWhiteTurn)
      btnWhiteCancel.setEnabled(toggle);
    else
      btnBlackCancel.setEnabled(toggle);
  }

  public void changeTurn(){
    hasMoved = false;
    isWhiteTurn = !isWhiteTurn;
    resetCasesColors();
    changedCases.clear();
    toggleCancellable(false);

    if (isWhiteTurn) {
      tvWhitePlayer.setBackgroundColor(getResources().getColor(R.color.green));
      tvBlackPlayer.setBackgroundColor(getResources().getColor(R.color.darkBrown));
    }
    else {
      tvBlackPlayer.setBackgroundColor(getResources().getColor(R.color.green));
      tvWhitePlayer.setBackgroundColor(getResources().getColor(R.color.darkBrown));
    }
  }

  public void win(PlayerColor diedColor){
    for(int i = 0; i < glBoard.getChildCount(); i++){
      RelativeLayout rlEachCase = (RelativeLayout) glBoard.getChildAt(i);
      rlEachCase.setOnClickListener(null);
    }
    String winner = diedColor == PlayerColor.Black ? player1 : player2;
    openPopup(winner + " a gagné !");
  }

  public void openPopup(String message){
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
    final View popupView = inflater.inflate(R.layout.popup_options,null);
    final PopupWindow optionsPopupWindow = new PopupWindow(
      popupView,
      LinearLayout.LayoutParams.MATCH_PARENT,
      LinearLayout.LayoutParams.WRAP_CONTENT
    );

    Button btnClose = popupView.findViewById(R.id.btnClose);
    Button btnRestart = popupView.findViewById(R.id.btnRestart);
    Button btnExit = popupView.findViewById(R.id.btnExit);
    TextView tvMessage = popupView.findViewById(R.id.tvMessage);

    tvMessage.setText(message);

    btnClose.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        optionsPopupWindow.dismiss();
      }
    });

    btnRestart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        optionsPopupWindow.dismiss();
        Intent intent = getIntent();
        startActivity(intent);
        finish();
      }
    });

    btnExit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        optionsPopupWindow.dismiss();
        goToMenu();
      }
    });

    optionsPopupWindow.showAtLocation(rlContent, Gravity.CENTER,0,0);
  }

  public void goToMenu(){
    Intent intentStart = new Intent(this, MenuActivity.class);
    startActivity(intentStart);
    finish();
  }

  @Override
  public void onBackPressed() {
    openPopup("Etes-vous sûr de vouloir quitter ?");
  }

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d("lifecycle","onCreate invoked");

    context = getApplicationContext();

    caseClickListener();
    btnFinishClickListener();
    btnCancelClickListener();
    btnOptionsClickListener();
    initPions();
    initComponents();
  }
}
