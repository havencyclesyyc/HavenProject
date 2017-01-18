/* *********************************************************************
**	File:  		Create.sql
**	Author:  	Matthew Davison
**	Created:	January 13, 2016
**	Description: This Sql script is responsible for creating the
**  Havencycles database "HavencyclesDB". This Sql script is also
**  responsible for adding primary key constraints for the Havencycles
**  database "HavencyclesDB".
**	Update History:
********************************************************************* */

DROP DATABASE if exists HavencyclesDB;
CREATE DATABASE HavencyclesDB;

USE HavencyclesDB;

CREATE TABLE Address (
  addressid int(9),
  userid int(9),
  streetAddress VarChar(50),
  city VarChar(30),
  state VarChar(30),
  country VarChar(30),
  zipCode VarChar(9),

  PRIMARY KEY (addressid)
);

CREATE TABLE Phone (
  userid int(9),
  phoneNumber VarChar(10)
);

CREATE TABLE Role (
  roleid int(2),
  roleName VarChar(10),

  PRIMARY KEY (roleid)
);

CREATE TABLE User (
  userid int(9),
  roleid int(2),
  email VarChar(30) Not Null,
  password VarChar(30) Not Null,
  firstName VarChar(25),
  lastName VarChar(25),
  passwordUUID VarChar(50),
  registerUUID VarChar(50),

  PRIMARY KEY (userid),
  UNIQUE (email)
);

CREATE TABLE RentalOrder (
  rentalOrderId int(9),
  typeId int(3),
  userid int(9),
  rentalBikeId int(9),
  endDate Date,
  startDate Date,
  status Char(1),

  PRIMARY KEY (rentalOrderId)
);

CREATE TABLE RentalType (
  rentalTypeId int(3),
  ratePerDay NUMERIC(9,2),

  PRIMARY KEY (rentalTypeId)
);

CREATE TABLE RentalBike (
  rentalBikeId int(9),
  available Char(1),
  year int(4),
  brand VarChar(25),
  model VarChar(20),
  size Char(2),
  color VarChar(20),
  description VarChar(2000),

  PRIMARY KEY (rentalBikeId)
);

CREATE TABLE RepairOrder (
  repairOrderId int(9),
  userid int(9),
  repairBikeId int(9),
  endDate Date,
  startDate Date,
  cost NUMERIC(9, 2),
  notes VarChar(5000),
  status Char(1),

  PRIMARY KEY (repairOrderId)
);

CREATE TABLE RepairBike (
  repairBikeId int(9),
  year int(4),
  brand VarChar(25),
  model VarChar(25),
  type VarChar(25),
  size Char(2),
  color VarChar(20),
  seatHeight NUMERIC(6,2),

  PRIMARY KEY (repairBikeId)
);

CREATE TABLE PurchaseOrder (
  purchaseOrderId int(9),
  userid int(9),
  cart int(9),
  shippingAddress int(9),
  billingAddress int(9),
  datePlaced Date,
  estimatedDelivery Date,
  status Char(1),
  shipAndHandleCost NUMERIC(9, 2),
  estimatedTaxes NUMERIC(9, 2),

  PRIMARY KEY (purchaseOrderId)
);

CREATE TABLE CartProduct (
  cartProductId int(9),
  capurchaseOrderId int(9),
  productId int(9),
  quantity int(3),
  price NUMERIC(9,2),

  PRIMARY KEY (cartProductId)
);

CREATE TABLE Product (
  productId int(9),
  name VarChar(100),
  description VarChar(2000),
  quantityLeft int(4),
  price NUMERIC(9,2),
  imageLocation VarChar(25),
  category Varchar(25),
  weight NUMERIC(9,2),
  height NUMERIC(9,2),

  PRIMARY KEY (productId)
);