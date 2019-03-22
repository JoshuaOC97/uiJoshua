create table if not exists StoredAccounts
(
	STOREDACCOUNTID INTEGER default 1 not null primary key,
	USERNAME VARCHAR(20),
	PASSWORD VARCHAR(25),
	PASSWORDHINT VARCHAR(25),
	APPLICATIONNAME VARCHAR(35),
	PASSWORDEXPIRY DATE,
	CREATIONDATE DATE,
	STOREDACCOUNTS_USERID INTEGER,
	PASSWORDREMINDER DATE
)

create table if not exists Users
(
	USERSID INTEGER default 1 not null primary key,
	USERNAME VARCHAR(20),
	PASSWORD VARCHAR(25),
	EMAIL VARCHAR(50),
	ACCOUNTCREATIONDATE DATE
)


