package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 08/01/2018.
 */

public class Catapult extends Piece {

  public Catapult(PlayerColor color){
    setLife(1);
    setJump(false);
    setJumpAttack(true);
    setColor(color);

    if(color == PlayerColor.White)
      setImg(R.drawable.w_catapult);
    else
      setImg(R.drawable.b_catapult);

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
    actions.add(new Coords(0, 3));
    actions.add(new Coords(0, 4));
  }
}
