package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 08/01/2018.
 */

public class Sword extends Piece {

  public Sword(PlayerColor color){
    setLife(1);
    setJump(false);
    setJumpAttack(false);
    setColor(color);

    if(color == PlayerColor.White)
      setImg(R.drawable.w_sword);
    else
      setImg(R.drawable.b_sword);

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
    actions.add(new Coords(0, -1));
    actions.add(new Coords(-1, 0));
    actions.add(new Coords(1, 0));
  }
}
