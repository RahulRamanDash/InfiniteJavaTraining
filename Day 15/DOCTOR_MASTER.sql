create database hms;

use hms;

CREATE TABLE DOCTOR_MASTER (
    doctor_id VARCHAR(15) PRIMARY KEY,
    doctor_name VARCHAR(15) NOT NULL,
    dept VARCHAR(15) NOT NULL
);

INSERT INTO DOCTOR_MASTER (doctor_id, doctor_name, dept)
VALUES
    ('D0001', 'Ram', 'ENT'),
    ('D0002', 'Rajan', 'ENT'),
    ('D0003', 'Smita', 'Eye'),
    ('D0004', 'Bhavan', 'Surgery'),
    ('D0005', 'Sheela', 'Surgery'),
    ('D0006', 'Nethra', 'Surgery');


select * from DOCTOR_MASTER;