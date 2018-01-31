package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 13/12/2017.
 */

public class Bow extends Piece {

  public Bow(PlayerColor color){
    setLife(1);
    setJump(true);
    setJumpAttack(true);
    setColor(color);

    if(color == PlayerColor.White)
      setImg(R.drawable.w_bow);
    else
      setImg(R.drawable.b_bow);

    moves = getMoves();
    initMoves();
    actions = getActions();
    initActions();
  }

  public void initMoves(){
    moves.add(new Coords(-2, -2));
    moves.add(new Coords(-2, 2));
    moves.add(new Coords(-1, -1));
    moves.add(new Coords(-1, 1));
    moves.add(new Coords(1, -1));
    moves.add(new Coords(1, 1));
    moves.add(new Coords(2, -2));
    moves.add(new Coords(2, 2));
  }

  public void initActions(){
    actions.add(new Coords(-2, 0));
    actions.add(new Coords(-1, -1));
    actions.add(new Coords(-1, 1));
    actions.add(new Coords(0, -2));
    actions.add(new Coords(0, 2));
    actions.add(new Coords(1, -1));
    actions.add(new Coords(1, 1));
    actions.add(new Coords(2, 0));
  }
}
