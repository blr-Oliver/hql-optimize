package com.securepay.model;

import java.util.List;

public class PayableItem {
  private int id = -1;
  private String email;
  private Hotel hotel;
  private List<CustomerEmail> emails;

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public Hotel getHotel() { return hotel; }
  public void setHotel(Hotel hotel) { this.hotel = hotel; }

  public List<CustomerEmail> getEmails() { return emails; }
  public void setEmails(List<CustomerEmail> emails) { this.emails = emails; }
}
