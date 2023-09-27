CREATE TABLE PATIENT_MASTER (
    pid VARCHAR(15) PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    age INT NOT NULL,
    weight INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    address VARCHAR(50) NOT NULL,
    phoneno VARCHAR(10) NOT NULL,
    disease VARCHAR(50) NOT NULL,
    doctorid VARCHAR(5),
    FOREIGN KEY (doctorid) REFERENCES DOCTOR_MASTER(doctor_id)
);

INSERT INTO PATIENT_MASTER (pid, name, age, weight, gender, address, phoneno, disease, doctorid)
VALUES
    ('P0001', 'Gita', 35, 65, 'F', 'Chennai', '9867145678', 'Eye Infection', 'D0003'),
    ('P0002', 'Ashish', 40, 70, 'M', 'Delhi', '9845675678', 'Asthma', 'D0003'),
    ('P0003', 'Radha', 25, 60, 'F', 'Chennai', '9867166678', 'Pain in heart', 'D0005'),
    ('P0004', 'Chandra', 28, 55, 'F', 'Bangalore', '9978675567', 'Asthma', 'D0001'),
    ('P0005', 'Goyal', 42, 65, 'M', 'Delhi', '8967533223', 'Pain in Stomach', 'D0004');
