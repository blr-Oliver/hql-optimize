CREATE SCHEMA `securepay` DEFAULT CHARACTER SET utf8 ;

CREATE USER 'securepay-user'@'localhost' IDENTIFIED BY 'montesuma';
GRANT select, insert, update, delete, execute ON securepay.* TO 'securepay-user'@'localhost';
