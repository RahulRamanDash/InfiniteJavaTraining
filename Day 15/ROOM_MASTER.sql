CREATE TABLE ROOM_MASTER (
    room_no VARCHAR(15) PRIMARY KEY,
    room_type VARCHAR(15) NOT NULL,
    status VARCHAR(15) NOT NULL
);

INSERT INTO ROOM_MASTER (room_no, room_type, status)
VALUES
    ('R0001', 'AC', 'occupied'),
    ('R0002', 'Suite', 'vacant'),
    ('R0003', 'NonAC', 'vacant'),
    ('R0004', 'NonAC', 'occupied'),
    ('R0005', 'AC', 'vacant'),
    ('R0006', 'AC', 'occupied');
