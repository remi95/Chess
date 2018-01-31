package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 13/12/2017.
 */

public class Shield extends Piece {

  public Shield(PlayerColor color){
    setLife(2);
    setJump(false);
    setJumpAttack(false);
    setColor(color);

    if(color == PlayerColor.White)
      setImg(R.drawable.w_shield);
    else
      setImg(R.drawable.b_shield);

    moves = getMoves();
    initMoves();
    actions = getActions();
  }

  public void initMoves(){
    moves.add(new Coords(0, 1));
  }
}
