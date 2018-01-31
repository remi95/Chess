package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 13/12/2017.
 */

public class Piece {
  protected ArrayList<Coords> moves = new ArrayList<>();
  protected ArrayList<Coords> actions = new ArrayList<>();
  protected int life;
  protected boolean jump;
  protected boolean jumpAttack;
  protected Integer img;
  protected PlayerColor color;

  public Piece() {
    this.moves = moves;
    this.actions = actions;
    this.life = life;
    this.jump = jump;
    this.jumpAttack = jumpAttack;
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

  public boolean isJumpAttack() {
    return jumpAttack;
  }

  public void setJumpAttack(boolean jumpAttack) {
    this.jumpAttack = jumpAttack;
  }

  public void decreaseLife(){
    this.life -= 1;
  }

  public boolean isJump() {
    return jump;
  }

  public void setJump(boolean jump) {
    this.jump = jump;
  }

  public PlayerColor getColor() { return color; }

  public void setColor(PlayerColor color) { this.color = color; }
}
