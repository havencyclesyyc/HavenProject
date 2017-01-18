/* *********************************************************************
**	File:  		Create.sql
**	Author:  	Matthew Davison
**	Created:	January 13, 2016
**	Description: This Sql script is responsible for creating the
**  Havencycles database "HavencyclesDB". This Sql script is also
**  responsible for altering and adding constraints for the Havencycles
**  database "HavencyclesDB".
**	Update History:
********************************************************************* */

USE HavencyclesDB;

ALTER TABLE Address
  ADD CONSTRAINT `Valid_Address_Constraint`
  FOREIGN KEY (userid)
  REFERENCES User(userid);

ALTER TABLE Phone
  ADD CONSTRAINT `Valid_Phone_Constraint`
  FOREIGN KEY (userid)
  REFERENCES User(userid);

ALTER TABLE User
  ADD CONSTRAINT `Valid_Role_Constraint`
  FOREIGN KEY (roleid)
  REFERENCES Role(roleid),

  ADD CONSTRAINT `Unique_Email_Constraint`UNIQUE (email);

ALTER TABLE RentalOrder
  ADD CONSTRAINT `Valid_RentalType_Constraint`
  FOREIGN KEY (typeId)
  REFERENCES RentalType(rentalTypeId),

  ADD CONSTRAINT `Valid_RentalBike_Constraint`
  FOREIGN KEY (rentalBikeId)
  REFERENCES RentalBike(rentalBikeId),

  ADD CONSTRAINT `Valid_RentalOrder_Constraint`
  FOREIGN KEY (userid)
  REFERENCES User(userid);

ALTER TABLE RepairOrder
  ADD CONSTRAINT `Valid_RepairOrder_Constraint`
  FOREIGN KEY (userid)
  REFERENCES User(userid),

  ADD CONSTRAINT `Valid_RepairBike_Constraint`
  FOREIGN KEY (repairBikeId)
  REFERENCES RepairBike(repairBikeId);

ALTER TABLE PurchaseOrder
  ADD CONSTRAINT `Valid_PurchaseOrder_Constraint`
  FOREIGN KEY (userid)
  REFERENCES User(userid);

ALTER TABLE CartProduct
  ADD CONSTRAINT `Valid_CartProduct_Constraint`
  FOREIGN KEY (productId)
  REFERENCES Product(productId),

  ADD CONSTRAINT `Valid_PurchaseOrder_Constraint`
  FOREIGN KEY (purchaseOrderId)
  REFERENCES PurchaseOrder(purchaseOrderId);
