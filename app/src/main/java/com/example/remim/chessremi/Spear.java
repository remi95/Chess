package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 08/01/2018.
 */

public class Spear extends Piece {

  private ArrayList<Coords> moves;
  private ArrayList<Coords> actions;

  public Spear(PlayerColor color){
    setLife(1);
    setJump(false);
    setColor(color);

    if(color == PlayerColor.White)
      setImg(R.drawable.w_spear);
    else
      setImg(R.drawable.b_spear);

    moves = getMoves();
    initMoves();
    actions = getActions();
    initActions();
  }

  public void initMoves(){
    moves.add(new Coords(0, 1));
    moves.add(new Coords(0, -1));
    moves.add(new Coords(-1, 0));
    moves.add(new Coords(1, 0));
  }

  public void initActions(){
    actions.add(new Coords(0, 1));
    actions.add(new Coords(0, 2));
  }
}
