create table customer (
customerID INT,
firstName VARCHAR(20) not null,
lastName VARCHAR(20) not null,
phone VARCHAR(12) not null, -- has the form XXX-XXX-XXXX
gender VARCHAR(1), -- M or F
annual_income INT,
city VARCHAR(20),
primary key(customerID)
);

create table supplier (
supplierID INT,
supplierLocation VARCHAR(50),
primary key(supplierID)
);

create table assemblyPlants (
plantID INT,
plantLocation VARCHAR(50),
primary key(plantID)
);

create table brands (
	brandID INT,
	brandName VARCHAR(20),
	Primary key(brandID)
);

create table models (
	modelID INT,
	modelName VARCHAR(20),
	bodyStyle VARCHAR(30),  
	primary key(modelID)
);

create table options (
	optionID INT,
	color VARCHAR(15),
	primary key(optionID)
);


create table parts (
modelID INT,
partID INT,
primary key(partID),
foreign key(modelID) references models 
);


	
create table vehicles (
vin INT,
assembleDate date,
customerID INT,
plantID INT,
modelID INT,
optionID INT,
isSold NUMBER(1),
foreign key(customerID) references customer(customerID),
foreign key(plantID) references assemblyPlants(plantID),
primary key(vin),
foreign key(modelID) references models(modelID),
foreign key(optionID) references options(optionID)
);

create table dealers (
dealerID INT,
saleDate date, 
city varchar(20),
primary key(dealerID)
);

create table vehicleSales (
saleID INT,
vin INT,
customerID INT,
dealerID INT,
foreign key(dealerID) references dealers(dealerID),
foreign key(customerID) references customer(customerID),
foreign key(vin) references vehicles(vin),
primary key(saleID));

create table employees(
employeeID INT,
salary INT,
name varchar(20),
position varchar(20),
gender varchar(1),
dealerID INT,
vin INT,
primary key(employeeID),
foreign key(dealerID) references dealers(dealerID),
foreign key(vin) references vehicles(vin)
);