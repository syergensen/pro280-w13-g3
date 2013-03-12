INSERT INTO app_properties_table values('agreement',
'Terms and Conditions – NUBA\n
 
This tool provides estimations of salaries, taxes, and other expenses.  It is not intended to be used as a guarantee of salary or income amounts.  The amounts used within this tool are based on U.S. Bureau of Labor Statistics information gathered from the Occupational Employment Statistics database.  This information may be outdated or contain numbers that are higher (or lower) than the average starting salary.\n
 
This tool is intended solely for the use of current Neumont University students and their advisors.  Access by individuals outside of the Neumont University community is prohibited. \n
 
The functionality of this tool is provided “as-is”.\n
 
Data entered into this tool is temporarily stored on Neumont University servers.  The user session and relevant information will kept on the server for time up to one hour after leaving the site, unless the user logs out.  No personally identifiable information is collected or stored within the tool.\n
 
Questions regarding the information contained in this tool may be directed to the Neumont University Career Services department.  
'
);

-- -- Inserts
-- Cars
Insert into cars(quality,high,middle,low) values('New',70000,25000,15000);
Insert into cars(quality,high,middle,low) values('Used',40000,12000,5000);
-- Mileage
Insert into mileage(type,cost) values('high',155);
Insert into mileage(type,cost) values('average',209);
Insert into mileage(type,cost) values('low',411);

-- Nu Degrees
Insert into NuDegrees values('BSCS',10);
Insert into NuDegrees values('BSGD',12);
Insert into NuDegrees values('BSTM',10);
Insert into NuDegrees values('BSWD',10);
-- Regions
Insert into Regions values('Mid-Atlantic',948,1130);
Insert into Regions values('MidWest',682,828);
Insert into Regions values('Mountain-plains',694,867);
Insert into Regions values('New England',893,1160);
Insert into Regions values('SouthEast',726,913);
Insert into Regions values('SouthWest',695,735);
Insert into Regions values('West',976,1167);

-- Enter Salaries --
	-- BSCS
	INSERT INTO Salaries values('BSCS','New England',73268,0.25);
	INSERT INTO Salaries values('BSCS','Mid-Atlantic',75867,0.25);
	INSERT INTO Salaries values('BSCS','SouthEast',68721,0.25);
	INSERT INTO Salaries values('BSCS','MidWest',65705,0.25);
	INSERT INTO Salaries values('BSCS','SouthWest',70898,0.25);
	INSERT INTO Salaries values('BSCS','Mountain-plains',68550,0.25);
	INSERT INTO Salaries values('BSCS','West',73615,0.25);
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
	INSERT INTO Salaries values('BSTM','New England',94333,0.28);
	INSERT INTO Salaries values('BSTM','Mid-Atlantic',95375,0.28);
	INSERT INTO Salaries values('BSTM','SouthEast',92750,0.28);
	INSERT INTO Salaries values('BSTM','MidWest',86300,.025);
	INSERT INTO Salaries values('BSTM','SouthWest',86000,.025);
	INSERT INTO Salaries values('BSTM','Mountain-plains',87500,.025);
	INSERT INTO Salaries values('BSTM','West',75000,.025);
	-- 
		-- BSWD
	INSERT INTO Salaries values('BSWD','New England',75735,.025);
	INSERT INTO Salaries values('BSWD','Mid-Atlantic',86367,.025);
	INSERT INTO Salaries values('BSWD','SouthEast',70002,.025);
	INSERT INTO Salaries values('BSWD','MidWest',71370,.025);
	INSERT INTO Salaries values('BSWD','SouthWest',70818,.025);
	INSERT INTO Salaries values('BSWD','Mountain-plains',70710,.025);
	INSERT INTO Salaries values('BSWD','West',74370,.025);
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

Select * from app_properties_table;
Select * from cars;
Select * from groups;
Select * from mileage;
Select * from NuDegrees;
Select * from Regions;
Select * from selectGroup;
Select * from selectItem;
Select * from Salaries;
Select * from users;
Select * from users_groups;
Select * from vlogin;