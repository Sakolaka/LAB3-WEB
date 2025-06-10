CREATE DATABASE student_grades_db_for_Lab3;
USE student_grades_db_for_Lab3;

CREATE TABLE student (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE grade (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       subject VARCHAR(255) NOT NULL,
                       score INT NOT NULL,
                       student_id BIGINT,
                       FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE
);
