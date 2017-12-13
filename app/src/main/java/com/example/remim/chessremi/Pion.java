package com.example.remim.chessremi;

import java.util.ArrayList;

/**
 * Created by remim on 13/12/2017.
 */

public class Pion {
  private ArrayList deplacements;
  private ArrayList actions;
  private int life;
  private boolean jump;
  private Integer img;

  public Pion() {
    this.deplacements = deplacements;
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

  public ArrayList getDeplacements() {
    return deplacements;
  }

  public void setDeplacements(ArrayList deplacements) {
    this.deplacements = deplacements;
  }

  public ArrayList getActions() {
    return actions;
  }

  public void setActions(ArrayList actions) {
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
