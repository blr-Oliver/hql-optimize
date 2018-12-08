package com.securepay.model;

import java.util.List;

public class HotelEmail extends Email {
  private String emailType;
  private Hotel hotel;
  private List<PayableItem> payableItems;

  public String getEmailType() { return emailType; }
  public void setEmailType(String emailType) { this.emailType = emailType; }

  public Hotel getHotel() { return hotel; }
  public void setHotel(Hotel hotel) { this.hotel = hotel; }

  public List<PayableItem> getPayableItems() { return payableItems; }
  public void setPayableItems(List<PayableItem> payableItems) { this.payableItems = payableItems; }
}
