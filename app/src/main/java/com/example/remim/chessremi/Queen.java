package com.example.remim.chessremi;

/**
 * Created by remim on 31/01/2018.
 */

public class Queen extends Piece {

  public Queen(PlayerColor color){
    setLife(1);
    setJump(false);
    setJumpAttack(false);
    setColor(color);

    if(color == PlayerColor.White)
      setImg(R.drawable.w_queen);
    else
      setImg(R.drawable.b_queen);

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
    actions.add(new Coords(1, 1));
    actions.add(new Coords(-1, -1));
    actions.add(new Coords(1, -1));
  }
}
