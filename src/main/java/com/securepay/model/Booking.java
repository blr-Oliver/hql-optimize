package com.securepay.model;

public class Booking extends PayableItem {
  private int status;

  public int getStatus() { return status; }
  public void setStatus(int status) { this.status = status; }
}
