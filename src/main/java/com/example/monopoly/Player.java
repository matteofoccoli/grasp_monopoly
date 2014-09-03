package com.example.monopoly;

/**
* Created by matteo on 03/09/14.
*/
public class Player {
  private Cup cup;
  private Board board;
  private Square currentLocation;

  public Player(Cup cup, Board board) {
    this.cup = cup;
    this.board = board;
  }

  public void takeTurn() {
    cup.roll();
    int steps = cup.getValue(); // Query Command Separation Principle
    Square newLocation = board.getSquare(getCurrentLocation(), steps);
    setCurrentLocation(newLocation);
    newLocation.landedOn(this);
  }

  public Square getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(Square currentLocation) {
    this.currentLocation = currentLocation;
  }
}
