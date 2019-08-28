# JBanking is a ACCOUNT BALANCE MANAGEMENT SYSTEM.

It contains two desktop application ->1.JBanking.java
                                      2.AdminBanking.java
 
1.JBanking.java-> It is general user application.
                  Atfirst it has a login frame->then a main frame(this frame contains 5 user operations     DIPOSITE,WITHDRAW,TRANSFER,BALANCE,EXIT).
                  
2.AdminBankung.java-> It is admin application.
                      It has a main frame which shows all available data from database.
                      It also contains some admin operations SEARCH,INSERT,UPDATE,DELETE.
                      SEARCH->It searches data for a given account number.
                      INSERT->Atfirst it automatic generate a unique accountnumber then takes other data input from admin and inserts it to the database.
                      UPDATE->admin selects a row from data table then after pressing update all input initializes by that row then admin can update all data except the account number.
                      DELETE->it deletes a selected row from data table.
         
customer.ibd->it is the relational database table.         
both the applications  are connected to mysql database by JDBC and uses some SQL queries to insert,update,delete,retrive data from database.
