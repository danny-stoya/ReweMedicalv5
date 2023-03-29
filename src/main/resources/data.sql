insert into diagnoses (code, description, deleted) values ('W880', 'Exposure to X-rays', false);
insert into diagnoses (code, description, deleted) values ('T83418A', 'Breakdown of prosth dev/implnt/grft of genitl trct, init', false);
insert into diagnoses (code, description, deleted) values ('V263XXA', 'Prsn brd/alit mtrcy injured in clsn w nonmtr vehicle, init', false);
insert into diagnoses (code, description, deleted) values ('S7619', 'Oth injury of quadriceps muscle, fascia and tendon', false);
insert into diagnoses (code, description, deleted) values ('T23662D', 'Corrosion of second degree back of left hand, subs encntr', false);
insert into diagnoses (code, description, deleted) values ('S42326D', 'Nondisp transverse fx shaft of humer, unsp arm, 7thD', false);
insert into diagnoses (code, description, deleted) values ('S85819A', 'Lacerat blood vessels at lower leg level, unsp leg, init', false);
insert into diagnoses (code, description, deleted) values ('S70329A', 'Blister (nonthermal), unspecified thigh, initial encounter', false);
# insert into diagnoses (code, description) values ('M2020', 'Hallux rigidus, unspecified foot');
# insert into diagnoses (code, description) values ('S62616', 'Disp fx of proximal phalanx of right little finger');
# insert into diagnoses (code, description) values ('O41143', 'Placentitis, third trimester');
# insert into diagnoses (code, description) values ('S8512', 'Other specified injury of unspecified tibial artery');
# insert into diagnoses (code, description) values ('S43429D', 'Sprain of unspecified rotator cuff capsule, subs encntr');
# insert into diagnoses (code, description) values ('Z906', 'Acquired absence of other parts of urinary tract');
# insert into diagnoses (code, description) values ('V80720', 'Animal-rider injured in collision with animal-drawn vehicle');
# insert into diagnoses (code, description) values ('M4789', 'Other spondylosis');
# insert into diagnoses (code, description) values ('S72323Q', 'Displ transverse fx shaft of unsp femr, 7thQ');
# insert into diagnoses (code, description) values ('I081', 'Rheumatic disorders of both mitral and tricuspid valves');
# insert into diagnoses (code, description) values ('R9430', 'Abnormal result of cardiovascular function study, unsp');
# insert into diagnoses (code, description) values ('S83422S', 'Sprain of lateral collateral ligament of left knee, sequela');


insert into specialties (name)values ('ENT');
insert into specialties (name)values ('Neurosurgery');
insert into specialties (name)values ('Dermatology');
insert into specialties (name)values ('Urology');
insert into specialties (name)values ('Orthopedic Surgery');
insert into specialties (name)values ('Dentistry');

insert into doctors (birth_date, is_gp, name, uid) values ('1989-12-29', true, 'Lorrayne', 'b3a');
insert into doctors (birth_date, is_gp, name, uid) values ('1985-12-21', true, 'Dillie', '0f2');
insert into doctors (birth_date, is_gp, name, uid) values ('1997-10-08', true, 'Quinta', '7e9');
insert into doctors (birth_date, is_gp, name, uid) values ('1997-01-14', false, 'Cordelia', '35e');
insert into doctors (birth_date, is_gp, name, uid) values ('1989-04-26', false, 'Francisca', '37b');
insert into doctors (birth_date, is_gp, name, uid) values ('1996-09-11', false, 'Leese', 'd83');

insert into doctors_specialties (doctor_id, specialties_id) VALUES (1, 1);
insert into doctors_specialties (doctor_id, specialties_id) VALUES (2, 2);
insert into doctors_specialties (doctor_id, specialties_id) VALUES (3, 3);
insert into doctors_specialties (doctor_id, specialties_id) VALUES (4, 4);
insert into doctors_specialties (doctor_id, specialties_id) VALUES (5, 5);
insert into doctors_specialties (doctor_id, specialties_id) VALUES (6, 6);
insert into doctors_specialties (doctor_id, specialties_id) VALUES (1, 2);
insert into doctors_specialties (doctor_id, specialties_id) VALUES (2, 3);

insert into patients (name, uid, gp_id) values ('Starlene', '8f4', 1);
insert into patients (name, uid, gp_id) values ('Kyrstin', '9cb', 2);
insert into patients (name, uid, gp_id) values ('Wylma', '348', null);

insert into insurances (end_date, start_date, patient_id) VALUES ('2023-12-01', '2023-01-01', 1);

insert into fees (end_date, start_date, value) VALUES ('2023-12-01', '2033-01-01', 0);
insert into fees (end_date, start_date, value) VALUES ('2023-12-01', '2023-01-01', 80);

insert into visits (visit_time, doctor_id, fee_id, patient_id) VALUES ('2023-10-15 16:11:00', 1 , 1, 1);
insert into visits (visit_time, doctor_id, fee_id, patient_id) VALUES ('2023-11-15 16:11:00', 1 , 1, 1);
insert into visits (visit_time, doctor_id, fee_id, patient_id) VALUES ('2023-09-15 16:11:00', 1 , 2, 1);
insert into visits (visit_time, doctor_id, fee_id, patient_id) VALUES ('2023-08-15 16:11:00', 1 , 2, 2);

insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (1,1);
insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (1,5);
insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (2,2);
insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (3,1);

# insert into visits_diagnoses (visit_doctor_id, visit_time, diagnoses_id) VALUES (1,'2023-10-15 16:11:00', 1);
# insert into visits_diagnoses (visit_doctor_id, visit_time, diagnoses_id) VALUES (1,'2023-10-15 16:11:00', 5);
# insert into visits_diagnoses (visit_doctor_id, visit_time, diagnoses_id) VALUES (1,'2023-11-15 16:11:00', 2);
# insert into visits_diagnoses (visit_doctor_id, visit_time, diagnoses_id) VALUES (1,'2023-09-15 16:11:00', 3);
# insert into visits_diagnoses (visit_doctor_id, visit_time, diagnoses_id) VALUES (1,'2023-08-15 16:11:00', 4);

# insert into patients (has_insurance, name, uid, gp_id) values (true, 'Erinna', '#48d', 2);
# insert into patients (has_insurance, name, uid, gp_id) values (true, 'Garrick', '#8de', 2);
# insert into patients (has_insurance, name, uid, gp_id) values (false, 'Tamiko', '#1ae', null);
# insert into patients (has_insurance, name, uid, gp_id) values (true, 'Oralie', '#778', 3);
# insert into patients (has_insurance, name, uid, gp_id) values (false, 'Rosella', '#315', null);
# insert into patients (has_insurance, name, uid, gp_id) values (false, 'Mandie', '#305', null);
# insert into patients (has_insurance, name, uid, gp_id) values (true, 'Jewell', '#fad', 3);
# insert into patients (has_insurance, name, uid, gp_id) values (true, 'Aldis', '#4b5', 3);
# insert into patients (has_insurance, name, uid, gp_id) values (false, 'Timothy', '#d17', null);
# insert into patients (has_insurance, name, uid, gp_id) values (true, 'Glory', '#553', 1);
# insert into patients (has_insurance, name, uid, gp_id) values (false, 'Kellby', '#89d', null);
# insert into patients (has_insurance, name, uid, gp_id) values (false, 'Loutitia', '#cc3', null);
# insert into patients (has_insurance, name, uid, gp_id) values (false, 'Gordy', '#be9', null);
# insert into patients (has_insurance, name, uid, gp_id) values (true, 'Tyne', '#14c', 1);
# insert into patients (has_insurance, name, uid, gp_id) values (true, 'Titos', '#e8f', 2);
# insert into patients (has_insurance, name, uid, gp_id) values (false, 'Khalil', '#be7', null);
# insert into patients (has_insurance, name, uid, gp_id) values (false, 'Armin', '#0ad', null);
#
#

# insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 10:00:00', 1, 1, 1);
# insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 10:30:00', 1, 1, 2);
# insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 11:00:00', 2, 2, 3);
# insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 11:30:00', 2, 2, 4);
# # insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 12:00:00', 3, 1, 5);
# # insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 12:30:00', 3, 2, 6);
# # insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 13:00:00', 4, 1, 7);
# # insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 13:30:00', 4, 2, 8);
# # insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 14:00:00', 5, 2, 8);
# # insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 14:30:00', 5, 1, 9);
# # insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 15:00:00', 6, 1, 10);
# # insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 15:30:00', 6, 1, 10);
# # insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 16:00:00', 6, 2, 15);
# # insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 16:30:00', 6, 2, 15);
# # insert into visits (date_time, doctor_id, fee_id, patient_id) values ('2023-04-01 17:00:00', 6, 2, 20);
# #
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (1,1);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (2,2);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (3,3);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (4,4);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (5,5);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (6,6);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (7,6);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (8,6);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (9,7);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (10,8);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (11,9);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (12,10);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (13,10);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (14,10);
# # insert into visits_diagnoses (visit_id, diagnoses_id) VALUES (15,10);