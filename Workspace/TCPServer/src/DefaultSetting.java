	import java.sql.*;
	import DatabaseLogic.DatabaseConnection;

	public class DefaultSetting
	{
		//Creates an new object of the class DatabaseConnection
		private DatabaseConnection DC = new DatabaseConnection();
		//Creates a method which creates the ordinarry users and 
		public void CreateDatabase() throws SQLException
		{
			//Creates the strings containing the syntaxes needed to communicate with MySQL
			//If database allready exists, drop it
			String DropDatabase = "DROP DATABASE IF EXISTS BtcDatabase";
			//Create a new database
			String CreateDatabase = "CREATE DATABASE BtcDatabase;";
			//Create 4 different tables in the MySQL
			String ProfileTable = "CREATE TABLE BtcDatabase.Login_Information(USERID int not null PRIMARY KEY AUTO_INCREMENT, "
					+ "CBSMail varchar(255) NOT NULL, Password varchar(255), Balance decimal(10,2), adminID varchar(1) NOT NULL, "
					+ "backgroundColor varchar(7))";
			String TransferTable ="CREATE TABLE BtcDatabase.Transfer_Information(TransferID int NOT NULL PRIMARY KEY AUTO_INCREMENT, "
					+ "Date varchar(30) NOT NULL, Outgoing varchar(30) NOT NULL, Ingoing varchar(30) NOT NULL, Amount decimal(15,2) NOT NULL, "
					+ "UserID int, FOREIGN KEY (UserID) REFERENCES BtcDatabase.Login_Information(UserID))";
			String exchangeTable ="CREATE TABLE BtcDatabase.exchangeRate(exchangeRateText varchar(255), "
					+ "exchangeRateDecimal decimal (10,4) not null PRIMARY KEY)";
			String bugTable ="CREATE TABLE BtcDatabase.bugTable(bugID int PRIMARY KEY auto_increment NOT NULL, "
					+ "bugText varchar(255), USERID int, FOREIGN KEY (USERID) REFERENCES BtcDatabase.Login_Information(USERID))";
			//Creates a few standard users and the exchange rate
			String AddAdmin = "Insert Into BtcDatabase.Login_Information (CBSMail, Password, Balance, adminID, backgroundColor) "
					+ "VALUES ('88888888', '1234abcd', '12.34', '1', '#4967aa')";
			String AddUsername = "Insert Into BtcDatabase.Login_Information (CBSMail, Password, Balance, adminID, backgroundColor) "
					+ "VALUES ('test', 'test', '11.43', '2', '#4967aa')";
			String AddUsername1 = "Insert Into BtcDatabase.Login_Information (CBSMail, Password, Balance, adminID, backgroundColor) "
					+ "VALUES ('Asger', '1234', '421.34', '2', '#4967aa')";
			String addUsername2 = "Insert Into BtcDatabase.Login_Information (CBSMail,  Password, Balance, adminID, backgroundColor) "
					+ "VALUES ('a', 'a', '12', '1', '#4967aa')";
			String addUsername3 = "Insert Into BtcDatabase.Login_Information (CBSMail,  Password, Balance, adminID, backgroundColor) "
					+ "VALUES ('b', 'b', '12', '2', '#4967aa')";
			String setExchangeRate = "Insert into BtcDatabase.exchangeRate(exchangeRateText, exchangeRateDecimal) VALUES ('EXR', '2375.1810')";
			
			//Executes all updates with the above strings
			DC.doUpdate(DropDatabase);
			DC.doUpdate(CreateDatabase);
			DC.doUpdate(ProfileTable);
			DC.doUpdate(TransferTable);
			DC.doUpdate(exchangeTable);
			DC.doUpdate(bugTable);
			DC.doUpdate(AddAdmin);
			DC.doUpdate(AddUsername);
			DC.doUpdate(AddUsername1);
			DC.doUpdate(addUsername2);
			DC.doUpdate(addUsername3);
			DC.doUpdate(setExchangeRate);
		}
	}