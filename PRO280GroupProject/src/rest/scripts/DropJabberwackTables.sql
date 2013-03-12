ALTER TABLE selectItem DROP foreign key fk_selectGroupId;
ALTER TABLE users_groups DROP FOREIGN KEY fk_users_groups_user_id;
ALTER TABLE users_groups DROP FOREIGN KEY fk_users_groups_group_id;

DROP VIEW IF EXISTS vlogin;
DROP TABLE IF EXISTS users_groups;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS users;

DROP TABLE selectItem;
Drop table Salaries;
Drop Table app_properties_table;
DROP TABLE selectGroup;
DROP TABLE Regions;
DROP TABLE NuDegrees;

DROP TABLE cars;
DROP TABLE mileage;