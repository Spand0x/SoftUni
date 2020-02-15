USE exercises;
CREATE TABLE students(
    student_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(40)
);
CREATE TABLE exams(
    exam_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(40)
) AUTO_INCREMENT=101;
CREATE TABLE students_exams(
    student_id INT NOT NULL,
    exam_id INT NOT NULL
);
ALTER TABLE students
    ADD CONSTRAINT pk_students
    PRIMARY KEY (student_id);
ALTER TABLE exams
    ADD CONSTRAINT pk_exams
    PRIMARY KEY (exam_id);
ALTER TABLE students_exams
    ADD CONSTRAINT pk_students_exams
    PRIMARY KEY (student_id,exam_id),
    ADD CONSTRAINT fk_students_exams_students
        FOREIGN KEY (student_id)
        REFERENCES students(student_id),
    ADD CONSTRAINT fk_students_exams_exams
        FOREIGN KEY (exam_id)
        REFERENCES exams(exam_id);

INSERT INTO students(name)
    VALUES ('Mila'),
           ('Toni'),
           ('Ron');
INSERT INTO exams(name)
    VALUES ('Sprint MVC'),
           ('Neo4j'),
           ('Oracle 11g');
INSERT INTO students_exams(student_id, exam_id)
    VALUES (1,101),
           (1,102),
           (2,101),
           (3,103),
           (2,102),
           (2,103);