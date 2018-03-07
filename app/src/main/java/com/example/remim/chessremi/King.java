package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 08/01/2018.
 */

public class King extends Piece {

  public King(PlayerColor color){
    setLife(1);
    setJump(false);
    setJumpAttack(false);
    setColor(color);

    if(color == PlayerColor.White)
      setImg(R.drawable.w_king);
    else
      setImg(R.drawable.b_king);

    moves = getMoves();
    initMoves();
    actions = getActions();
    initActions();
  }

  public void initMoves(){
    moves.add(new Coords(-1, 1));
    moves.add(new Coords(0, 1));
    moves.add(new Coords(1, 1));
    moves.add(new Coords(-1, 0));
    moves.add(new Coords(1, 0));
    moves.add(new Coords(-1, -1));
    moves.add(new Coords(0, -1));
    moves.add(new Coords(1, -1));
  }

  public void initActions(){
    actions.add(new Coords(-1, 1));
    actions.add(new Coords(0, 1));
    actions.add(new Coords(1, 1));
    actions.add(new Coords(-1, 0));
    actions.add(new Coords(1, 0));
    actions.add(new Coords(-1, -1));
    actions.add(new Coords(0, -1));
    actions.add(new Coords(1, -1));
  }
}
