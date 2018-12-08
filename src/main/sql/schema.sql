drop table if exists UpsellItems;
drop table if exists ManualEmails;
drop table if exists Bookings;
drop table if exists PayableItems_HotelEmails;
drop table if exists PayableItems_CustomerEmails;
drop table if exists HotelEmails;
drop table if exists CustomerEmails;
drop table if exists SmsMessages;
drop table if exists PayableItems;
drop table if exists Hotels;
drop table if exists Emails;

create table Emails (
  id int PRIMARY KEY AUTO_INCREMENT,
  address varchar(1000) NOT NULL default 'john.doe@example.com'
);

create table Hotels (
  id int PRIMARY KEY AUTO_INCREMENT,
  name varchar(1000) NOT NULL default 'Hotel'
);

create table PayableItems (
  id int PRIMARY KEY AUTO_INCREMENT,
  email varchar(1000),
  hotel_id int,
  FOREIGN KEY (hotel_id) REFERENCES Hotels(id) 
);

create table SmsMessages (
  id int PRIMARY KEY AUTO_INCREMENT,
  email_id int NOT NULL,
  status smallint NOT NULL default 0,
  cost decimal(18, 4),
  messageContent varchar(1000),
  FOREIGN KEY (email_id) REFERENCES Emails(id)
);

create table CustomerEmails (
  id int PRIMARY KEY,
  emailType varchar(100),
  FOREIGN KEY (id) REFERENCES Emails(id)
);

create table HotelEmails (
  id int PRIMARY KEY,
  emailType varchar(100),
  hotel_id int NOT NULL,
  FOREIGN KEY (id) REFERENCES Emails(id),
  FOREIGN KEY (hotel_id) REFERENCES Hotels(id)
);

create table PayableItems_CustomerEmails (
  payableItem_id int NOT NULL,
  customerEmail_id int NOT NULL,
  customerEmail_order int NOT NULL,
  PRIMARY KEY (payableItem_id, customerEmail_id, customerEmail_order),
  FOREIGN KEY (payableItem_id) REFERENCES PayableItems(id),
  FOREIGN KEY (customerEmail_id) REFERENCES CustomerEmails(id)
);

create table PayableItems_HotelEmails (
  payableItem_id int NOT NULL,
  hotelEmail_id int NOT NULL,
  hotelEmail_order int NOT NULL,
  PRIMARY KEY (payableItem_id, hotelEmail_id, hotelEmail_order),
  FOREIGN KEY (payableItem_id) REFERENCES PayableItems(id),
  FOREIGN KEY (hotelEmail_id) REFERENCES HotelEmails(id)
);

create table Bookings (
  id int PRIMARY KEY,
  status smallint NOT NULL default 0,
  FOREIGN KEY (id) REFERENCES PayableItems(id)
);

create table ManualEmails (
  id int PRIMARY KEY,
  title varchar(1000) NOT NULL default 'Manual e-mail',
  FOREIGN KEY (id) REFERENCES PayableItems(id)
);

create table UpsellItems (
  id int PRIMARY KEY,
  name varchar(1000) NOT NULL default 'Upsell item',
  FOREIGN KEY (id) REFERENCES PayableItems(id)
);
