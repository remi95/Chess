package com.example.remim.chessremi;

public class TutoPage {

  private String piece;
  private int image;
  private String description;

  public TutoPage(String piece, int image, String description) {
    this.piece = piece;
    this.image = image;
    this.description = description;
  }

  public String getPiece() {
    return piece;
  }

  public int getImage() {
    return image;
  }

  public String getDescription() {
    return description;
  }
}
