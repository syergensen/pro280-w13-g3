CREATE TABLE NuDegrees(
	Degree VARCHAR(10) not null primary key
);

-- Aspirations
CREATE TABLE Regions(
	regionName VARCHAR(15) not null primary key
);

CREATE TABLE selectGroup(
	groupId  smallint unique,
	description varchar(20) unique,
	primary key (groupId)
);

-- Cars can be simpliefied to these two items
-- We can also Housing situation\preffered as well
CREATE TABLE selectItem(
	id int not null AUTO_INCREMENT primary key,
	itemName varchar(20),
	groupId smallint,
	constraint fk_selectGroupId foreign key (groupId) references selectGroup(groupId)
);

-- Nu Degrees
Insert into NuDegrees values('BSCS');
Insert into NuDegrees values('BSGD');
Insert into NuDegrees values('BSTM');
Insert into NuDegrees values('BSWD');
-- Regions
Insert into Regions values('Asia');
Insert into Regions values('Australia and Oceania');
Insert into Regions values('Central America and the Caribbean');
Insert into Regions values('Europe');
Insert into Regions values('Greater Arabia');
Insert into Regions values('Middle East');
Insert into Regions values('North Africa');
Insert into Regions values('North America');
Insert into Regions values('South America');
Insert into Regions values('Sub-Saharan Africa');

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

Select * from NuDegrees;
Select * from Regions;
Select * from selectGroup;
Select * from selectItem;
