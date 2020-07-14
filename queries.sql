-- Part 1: Test it with SQL
-- Create a new schema (database) named techjobs
-- If I could use command line, I probably would have done it like this:
-- mysql -u techjobs -h locahost techjobs < queries.sql
CREATE SCHEMA `techjobs` DEFAULT CHARACTER SET utf8mb4;     -- UTF8 + Emojis
-- Create a new user (and grant all privileges to this database)
CREATE USER 'techjobs'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON techjobs . * TO 'techjobs'@'localhost';
FLUSH PRIVILEGES;
## Part 2: Test it with SQL

## Part 3: Test it with SQL

## Part 4: Test it with SQL