-- q1) Display the patients who were admitted in the month of january.
select * from PATIENT_MASTER where pid=(select pid  from ROOM_ALLOCATION where month(admission_date)=1 );

-- q2) Display the female patient who is not suffering from asthma 
select * from  PATIENT_MASTER where disease != "asthma" and gender="F";

-- q3) Count the number of male and female patients. 
select gender,count(*) from PATIENT_MASTER group by gender;

-- q4) :Display the patient_id,patient_name, doctor_id, doctor_name, room_no, room_type and admission_date.

SELECT PM.pid, PM.name ,DM.doctor_id, DM.doctor_name, RA.room_no,RM.room_type, RA.admission_date FROM PATIENT_MASTER AS PM
INNER JOIN DOCTOR_MASTER AS DM
INNER JOIN room_allocation AS RA
INNER JOIN room_master AS RM;

-- 5) Display the room_no which was never allocated to any patient.
SELECT room_no FROM ROOM_MASTER WHERE room_no NOT IN (SELECT room_no FROM ROOM_ALLOCATION);

-- 6) :Display the room_no, room_type which are allocated more than once.
SELECT room_no,room_type FROM room_master WHERE ROOM_NO in (SELECT room_no FROM ROOM_ALLOCATION GROUP BY room_no HAVING COUNT(*) > 1);
