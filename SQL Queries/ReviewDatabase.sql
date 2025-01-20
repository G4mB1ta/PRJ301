CREATE DATABASE PRJDB;

USE PRJDB;


-- Tạo bảng Role
CREATE TABLE Role (
    roleId INT PRIMARY KEY,
    roleName NVARCHAR(100)
);

-- Tạo bảng Accounts
CREATE TABLE Accounts (
    accountId CHAR(8) PRIMARY KEY,
    password NVARCHAR(100),
    roleId INT,
    FOREIGN KEY (roleId) REFERENCES Role(roleId)
);

CREATE TABLE Specializations (
	specId int IDENTITY(1,1) PRIMARY KEY,
	specName nvarchar(100),
)

CREATE TABLE Students (
	rollNumber char(8) PRIMARY KEY,
	firstName nvarchar(100),
	lastName nvarchar(100),
	birthday date,
	gender char(1),
	english1 nvarchar(10),
	english2 nvarchar(10),
	english3 nvarchar(10),
	english4 nvarchar(10),
	specId int
	FOREIGN KEY (specId) REFERENCES Specializations(specId)
)

INSERT INTO Role(roleId, roleName) VALUES (1, 'Admin');
INSERT INTO Role(roleId, roleName) VALUES (2, 'Student');

INSERT INTO Accounts(accountId, password, roleId) VALUES ('AD000001', 'admin@1', 1);
INSERT INTO Accounts(accountId, password, roleId) VALUES ('AD000002', 'admin@2', 1);
INSERT INTO Accounts(accountId, password, roleId) VALUES ('HE190001', 'stud@1901', 2);
INSERT INTO Accounts(accountId, password, roleId) VALUES ('HE190002', 'stud@1902', 2);
INSERT INTO Accounts(accountId, password, roleId) VALUES ('HE190003', 'stud@1903', 2);
INSERT INTO Accounts(accountId, password, roleId) VALUES ('HE190004', 'stud@1904', 2);
INSERT INTO Accounts(accountId, password, roleId) VALUES ('HE190001', 'stud@1901', 2);

INSERT INTO Specializations(specName) VALUES ('Software Engineering');
INSERT INTO Specializations(specName) VALUES ('Information Assurance');
INSERT INTO Specializations(specName) VALUES ('Artificial Intelligence');

INSERT INTO Students(rollNumber, firstName, lastName, birthday, gender, english1, english2, english3, english4, specId)
	VALUES ('HE190001', 'Nam', 'Nguyen Thanh', '2004-01-01','M','Passed','Passed','Passed','Passed',1)

INSERT INTO Students(rollNumber, firstName, lastName, birthday, gender, english1, english2, english3, english4, specId)
	VALUES ('HE190002', 'Thuy', 'Nguyen Thi', '2004-10-12','F','Passed','Passed','Passed','Not Passed',1)

INSERT INTO Students(rollNumber, firstName, lastName, birthday, gender, english1, english2, english3, english4, specId)
	VALUES ('HE190003', 'Huong', 'Tran Thi', '2004-05-25','F','Passed','Passed','Not Passed','Not Passed',3)

INSERT INTO Students(rollNumber, firstName, lastName, birthday, gender, english1, english2, english3, english4, specId)
	VALUES ('HE190004', 'Binh', 'Tran Duy', '2004-08-17','M','Passed','Passed','Not Passed','Not Passed',2)

SELECT * FROM Role

SELECT * FROM Accounts

SELECT * FROM Specializations

SELECT * FROM Students
