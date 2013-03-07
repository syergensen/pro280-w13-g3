CREATE TABLE NuDegrees(
	Degree VARCHAR(10) not null primary key
);

-- Aspirations
CREATE TABLE Regions(
	regionName VARCHAR(18) not null primary key
);

CREATE TABLE selectGroup(
	groupId  smallint unique,
	description varchar(20) unique,
	primary key (groupId)
);

-- Holds combinations: Quarters, Housing, PrefHousing, CarX3
CREATE TABLE selectItem(
	id int not null AUTO_INCREMENT primary key,
	itemName varchar(20) not null,
	groupId smallint,
	constraint fk_selectGroupId foreign key (groupId) references selectGroup(groupId)
);

CREATE TABLE Salaries(
	Degree VARCHAR(10) not null references NuDegrees(Degree) ,
	Region VARCHAR(18) not null  references Regions(regionName),
	Salary int not null,
	primary key(Degree,Region)
);

---- Inserts
-- Nu Degrees
Insert into NuDegrees values('BSCS');
Insert into NuDegrees values('BSGD');
Insert into NuDegrees values('BSTM');
Insert into NuDegrees values('BSWD');
-- Regions
Insert into Regions values('New England');
Insert into Regions values('Mid-Atlantic');
Insert into Regions values('SouthEast');
Insert into Regions values('MidWest');
Insert into Regions values('SouthWest');
Insert into Regions values('Mountain-plains');
Insert into Regions values('West');

-- Enter Salaries --
	-- BSCS
	INSERT INTO Salaries values('BSCS','New England',73268);
	INSERT INTO Salaries values('BSCS','Mid-Atlantic',75867);
	INSERT INTO Salaries values('BSCS','SouthEast',68721);
	INSERT INTO Salaries values('BSCS','MidWest',65705);
	INSERT INTO Salaries values('BSCS','SouthWest',70898);
	INSERT INTO Salaries values('BSCS','Mountain-plains',68550);
	INSERT INTO Salaries values('BSCS','West',73615);
	-- 
		-- BSGD
	INSERT INTO Salaries values('BSGD','New England',76801);
	INSERT INTO Salaries values('BSGD','Mid-Atlantic',85477);
	INSERT INTO Salaries values('BSGD','SouthEast',73453);
	INSERT INTO Salaries values('BSGD','MidWest',68653);
	INSERT INTO Salaries values('BSGD','SouthWest',70250);
	INSERT INTO Salaries values('BSGD','Mountain-plains',72038);
	INSERT INTO Salaries values('BSGD','West',75978);
	-- 
		-- BSTM
	INSERT INTO Salaries values('BSTM','New England',94333);
	INSERT INTO Salaries values('BSTM','Mid-Atlantic',95375);
	INSERT INTO Salaries values('BSTM','SouthEast',92750);
	INSERT INTO Salaries values('BSTM','MidWest',86300);
	INSERT INTO Salaries values('BSTM','SouthWest',86000);
	INSERT INTO Salaries values('BSTM','Mountain-plains',87500);
	INSERT INTO Salaries values('BSTM','West',75000);
	-- 
		-- BSWD
	INSERT INTO Salaries values('BSWD','New England',75735);
	INSERT INTO Salaries values('BSWD','Mid-Atlantic',86367);
	INSERT INTO Salaries values('BSWD','SouthEast',70002);
	INSERT INTO Salaries values('BSWD','MidWest',71370);
	INSERT INTO Salaries values('BSWD','SouthWest',70818);
	INSERT INTO Salaries values('BSWD','Mountain-plains',70710);
	INSERT INTO Salaries values('BSWD','West',74370);
-- /Enter Salaries


-- Group selections --
	-- inSchoolHousing
	Insert into selectGroup values( 1,'InSchoolHousing' );
	Insert into selectItem(itemName, groupId) values('Neumont University Housing', 1);
	Insert into selectItem(itemName, groupId) values('Live with Family or friends for free', 1);
	Insert into selectItem(itemName, groupId) values('Renting an apartment or similar', 1);
	-- afterSchoolHousing
	Insert into selectGroup values( 2,'AfterHousing' );
	Insert into selectItem(itemName, groupId) values('Own', 2);
	Insert into selectItem(itemName, groupId) values('Rent', 2);
	Insert into selectItem(itemName, groupId) values('Live with Parents', 2);
	-- Car age
	Insert into selectGroup values( 3,'CarAge' );
	Insert into selectItem(itemName, groupId) values('New', 3);
	Insert into selectItem(itemName, groupId) values('Used', 3);
	-- Car Fuel
	Insert into selectGroup values( 4,'CarFuel' );
	Insert into selectItem(itemName, groupId) values('Average', 4);
	Insert into selectItem(itemName, groupId) values('Above Average', 4);
	Insert into selectItem(itemName, groupId) values('Below Average', 4);
	-- Car Rating
	Insert into selectGroup values( 5,'CarRating' );
	Insert into selectItem(itemName, groupId) values('Average', 5);
	Insert into selectItem(itemName, groupId) values('Above Average', 5);
	Insert into selectItem(itemName, groupId) values('Below Average', 5);

	-- Neumont Quarters --
	Insert into selectGroup values( 6,'Quarters' );
	Insert into selectItem(itemName, groupId) values('Spring',6);
	Insert into selectItem(itemName, groupId) values('Winter',6);
	Insert into selectItem(itemName, groupId) values('Fall',6);
	Insert into selectItem(itemName, groupId) values('Summer',6);
-- /Group Selections --

-- SQL Queries --

Select * from NuDegrees;
Select * from Regions;
Select * from selectGroup;
Select * from selectItem;
Select * from Salaries;