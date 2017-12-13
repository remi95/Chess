package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 13/12/2017.
 */

public class Bow extends Pion {

  private ArrayList<Coords> moves = new ArrayList<>();
  private ArrayList<Coords> actions = new ArrayList<>();

  public Bow(PlayerColor color){
    setLife(1);
    setJump(false);
    if(color == PlayerColor.White)
      setImg(R.drawable.w_bow);
    else
      setImg(R.drawable.bow);
    initMoves();
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
    actions.add(new Coords(1, 1));
    actions.add(new Coords(0, -2));
    actions.add(new Coords(0, 2));
    actions.add(new Coords(1, -1));
    actions.add(new Coords(1, 1));
    actions.add(new Coords(2, 0));
  }

  public ArrayList<Coords> getMoves() {
    return moves;
  }

  public void setMoves(ArrayList<Coords> moves) {
    this.moves = moves;
  }

  public ArrayList<Coords> getActions() {
    return actions;
  }

}
