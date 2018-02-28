DELETE FROM users;
DELETE FROM cars;
DELETE FROM repairs;
DELETE FROM parts;
INSERT INTO `users` VALUES (1,'a@email.com','aaa','2018-01-01 12:00:00','2018-01-01 12:00:00'),(2,'b@email.com','bbb','2018-01-01 12:00:00','2018-01-01 12:00:00'),(3,'c@email.com','ccc','2018-01-01 12:00:00','2018-01-01 12:00:00');
INSERT INTO `cars` VALUES (1,1,2001,'Jeep','Grand Cherokee','12345678901234567','2018-01-01 12:00:00','2018-01-01 12:00:00');
INSERT INTO `repairs` VALUES (1,1,'2018-01-01','123-456','Midas',300,45000,'5 years parts and labor','Brakes','Replaced rotors and pads','2018-01-01 12:00:00','2018-01-01 12:00:00');
INSERT INTO `parts` VALUES (1,1,'Brakes pads','Raybestos','123-456','5 year replacement','Autozone',100.00,'Gold Premium','2018-01-01 12:00:00','2018-01-01 12:00:00');




