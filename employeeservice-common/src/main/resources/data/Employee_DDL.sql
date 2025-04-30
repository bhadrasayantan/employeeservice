create table Employee(
EmployeeId integer not null primary key auto_increment,
FirstName varchar(50) not null,
LastName varchar(50) not null,
DOB Date not null,
CreatedBy varchar(50) not null,
CreatedOn datetime not null,
ModifiedBy varchar(50),
ModifiedOn datetime
);
create table REVINFO(
REV Integer primary key auto_increment not null,
REVTSTMP  bigint not null
);
create table Employee_Audit(
EmployeeId integer not null auto_increment,
REV integer not null,
REVTYPE tinyint not null,
FirstName varchar(50),
LastName varchar(50),
DOB Date,
CreatedBy varchar(50),
CreatedOn datetime,
ModifiedBy varchar(50),
ModifiedOn datetime,
constraint Employee_Audit_PK primary key(EmployeeId,REV),
constraint Employee_Audit_FK foreign key (REV) references REVINFO(REV)
);
CREATE TABLE User (
  UserId int NOT NULL AUTO_INCREMENT,
  UserName varchar(50) NOT NULL,
  UserPassword varchar(100) NOT NULL,
  PRIMARY KEY (UserId)
);
CREATE TABLE UserRole (
  UserRoleId int NOT NULL AUTO_INCREMENT,
  UserId int NOT NULL,
  RoleName varchar(50) NOT NULL,
  RoleDesc varchar(50) NOT NULL,
  PRIMARY KEY (UserRoleId),
  KEY FK_UserRole (UserId),
  CONSTRAINT FK_UserRole FOREIGN KEY (UserId) REFERENCES User (UserId)
);