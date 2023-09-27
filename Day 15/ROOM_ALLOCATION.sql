CREATE TABLE ROOM_ALLOCATION (
    room_no VARCHAR(15),
    pid VARCHAR(15),
    admission_date DATE NOT NULL,
    release_date DATE,
    FOREIGN KEY (room_no) REFERENCES ROOM_MASTER(room_no),
    FOREIGN KEY (pid) REFERENCES PATIENT_MASTER(pid)
);
INSERT INTO ROOM_ALLOCATION (room_no, pid, admission_date, release_date)
VALUES
    ('R0001', 'P0001', '2016-10-15', '2016-10-26'),
    ('R0002', 'P0002', '2016-11-15', '2016-11-26'),
    ('R0002', 'P0003', '2016-12-01', '2016-12-30'),
    ('R0004', 'P0001', '2017-01-01', '2017-01-30');
