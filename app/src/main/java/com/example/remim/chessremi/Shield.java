package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 13/12/2017.
 */

public class Shield {
  private ArrayList<Coords> moves = new ArrayList<>();
  private ArrayList<Coords> actions = new ArrayList<>();
  private int life = 2;
  private boolean jump = false;
  private Integer img;

  public Shield(PlayerColor color){
    if(color == PlayerColor.White)
      img = R.drawable.w_bow;
    else
      img = R.drawable.bow;
//    initMoves();
//    initActions();
  }
}
