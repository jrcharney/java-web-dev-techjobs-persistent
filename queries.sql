-- Create a new schema (database) named techjobs
-- If I could use command line, I probably would have done it like this:
-- mysql -u techjobs -h locahost techjobs < queries.sql
-- CREATE SCHEMA `techjobs` DEFAULT CHARACTER SET utf8mb4;     -- UTF8 + Emojis
-- Create a new user (and grant all privileges to this database)
-- CREATE USER 'techjobs'@'localhost' IDENTIFIED BY 'auth';
--GRANT ALL PRIVILEGES ON techjobs . * TO 'techjobs'@'localhost';
-- FLUSH PRIVILEGES;

USE DATABASE techjobs;

## Part 1: Test it with SQL
DESCRIBE job;

+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| id       | int          | NO   | PRI | <null>  |       |
| employer | varchar(255) | YES  |     | <null>  |       |
| name     | varchar(255) | YES  |     | <null>  |       |
| skills   | varchar(255) | YES  |     | <null>  |       |
+----------+--------------+------+-----+---------+-------+

## Part 2: Test it with SQL
SELECT name AS "Employer Name"
FROM employer
WHERE location = "St. Louis City";

## Part 3: Test it with SQL
DROP TABLE job;

## Part 4: Test it with SQL
# Write a query to return a list of the names and descriptions of all the skills that are attached to jobs in alphabetical order.
# If a skill does not have a job listed, it should not be included in the query.
# Tip: You will need to make use of the "IS NOT NULL" statement.
# (Who wants to bet there will be a JOIN statement somewhere?)

SELECT skill.name AS "Name", skill.description AS "Description"
FROM skill
LEFT JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY skill.name ASC;

# TODO: List the output of this query!