package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 13/12/2017.
 */

public class Shield extends Pion {

  private ArrayList<Coords> moves;
  private ArrayList<Coords> actions;

  public Shield(PlayerColor color){
    setLife(2);
    setJump(false);

    if(color == PlayerColor.White)
      setImg(R.drawable.w_shield);
    else
      setImg(R.drawable.b_shield);

    moves = getMoves();
    initMoves();
    actions = null;
  }

  public void initMoves(){
    moves.add(new Coords(0, 1));
  }
}
