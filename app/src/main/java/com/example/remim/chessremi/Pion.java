package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 13/12/2017.
 */

public class Pion {
  private ArrayList<Coords> moves = new ArrayList<>();
  private ArrayList<Coords> actions = new ArrayList<>();
  private int life;
  private boolean jump;
  private Integer img;

  public Pion() {
    this.moves = moves;
    this.actions = actions;
    this.life = life;
    this.jump = jump;
  }

  public Integer getImg() {
    return img;
  }

  public void setImg(Integer img) {
    this.img = img;
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

  public void setActions(ArrayList<Coords> actions) {
    this.actions = actions;
  }

  public int getLife() {
    return life;
  }

  public void setLife(int life) {
    this.life = life;
  }

  public boolean isJump() {
    return jump;
  }

  public void setJump(boolean jump) {
    this.jump = jump;
  }
}
