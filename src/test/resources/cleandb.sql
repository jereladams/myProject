DELETE FROM users;
DELETE FROM cars;
DELETE FROM repairs;
DELETE FROM parts;
INSERT INTO `users` VALUES (1,'a@email.com','aaa',NOW(),NOW()),(2,'b@email.com','bbb',NOW(),NOW()),(3,'c@email.com','ccc',NOW(),NOW());
INSERT INTO `cars` VALUES (1,1,2001,'Jeep','Grand Cherokee','12345678901234567',NOW(),NOW());
#INSERT INTO `book` VALUES (1,'Head First Java, 2nd Edition',1,'978-0596009205',2005),(2,'Beginning Hibernate',3,'978-1-4842-2319-2',2016),(3,'Java: A Beginner’s Guide (Sixth Edition)',2,'978-0071809252',2014)


