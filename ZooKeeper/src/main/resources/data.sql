INSERT INTO species (species_name, feeding_type) VALUES
     ('Rabbit', 'HERBIVORE'),
     ('Lion', 'CARNIVORE'),
     ('Cow', 'HERBIVORE'),
     ('Tiger', 'CARNIVORE'),
     ('Sheep', 'HERBIVORE'),
     ('Snake', 'CARNIVORE'),
     ('Parrot', 'OMNIVORE'),
     ('Monkey', 'OMNIVORE'),
     ('Bat', 'HERBIVORE'),
     ('Owl', 'CARNIVORE'),
     ('Lama', 'HERBIVORE');

INSERT INTO cage (id) VALUES
      (3),
      (4),
      (10),
      (7),
      (2),
      (5),
      (8),
      (11),
      (9);

INSERT INTO worker (name, salary, job_title) VALUES
     ('{"firstName": "Ines", "secondName": "Park"}', 14.3, 'CLEANER'),
     ('{"firstName": "Adam", "secondName": "Black"}', 54.8, 'TRAINER'),
     ('{"firstName": "Boil", "secondName": "Red"}', 23.3, 'CLEANER'),
     ('{"firstName": "Sam", "secondName": "Blue"}', 42.2, 'TRAINER'),
     ('{"firstName": "Misha", "secondName": "Bobov", "patronymicName": "Victorovich"}', 21.4, 'CLEANER'),
     ('{"firstName": "Lila", "middleName": "Lee", "secondName": "Parkman"}', 54.5, 'ADMINISTRATIVE_WORKER'),
     ('{"firstName": "Vlad", "secondName": "Dikiy"}', 23.5, 'VETERINARIAN'),
     ('{"firstName": "Boba", "secondName": "Aboba"}', 63.4, 'VETERINARIAN'),
     ('{"firstName": "July", "secondName": "Clark"}', 54.7, 'VETERINARIAN'),
     ('{"firstName": "Ivan", "secondName": "Plushkin", "patronymicName": "Michailovich"}', 64.5, 'ADMINISTRATIVE_WORKER'),
     ('{"firstName": "Tyler", "secondName": "Durden"}', 23.6, 'HANDY_WORKER'),
     ('{"firstName": "Sherri", "secondName": "Gould"}', 63.6, 'VETERINARIAN'),
     ('{"firstName": "Kirsten", "secondName": "Hopper"}', 12.6, 'HANDY_WORKER'),
     ('{"firstName": "Dorothea", "secondName": "Curtis"}', 62.6, 'TRAINER'),
     ('{"firstName": "Savage", "secondName": "Bolton"}', 67.6, 'ADMINISTRATIVE_WORKER'),
     ('{"firstName": "Marsha", "secondName": "Saveman"}', 13.6, 'HANDY_WORKER');

INSERT INTO administrator(id)
SELECT id from worker
WHERE job_title = 'ADMINISTRATIVE_WORKER';

INSERT INTO cleaner(id)
SELECT id from worker
WHERE job_title = 'CLEANER';

INSERT INTO trainer
SELECT id from worker
WHERE job_title = 'TRAINER';

INSERT INTO vet
SELECT id from worker
WHERE job_title = 'VETERINARIAN';

INSERT INTO animal (name, species_id, cage_id, need_warm_cage) VALUES
    ('Bonny', 1, 3, false),
    ('Jack', 1, 3, false),
    ('Horn', 2, 4, false),
    ('Becky', 2, 4, false),
    ('Lermace', 3, 10, false),
    ('Dima', 5, 7, false),
    ('Goose', 5, 7, false),
    ('Magoost', 5, 7, true),
    ('Ken', 5, 7, true),
    ('Barbie', 6, 2, true),
    ('Felix', 8, 5, true),
    ('Terry', 7, 11, true),
    ('Freddy', 7, 11, true),
    ('Chika', 9, 9, true),
    ('Yasha', 1, 3, true),
    ('Vlad', 1, 3, true),
    ('Vlad Junior', 1, 3, true);

INSERT INTO vet_card (age, sex, height, weight, need_isolation, is_pregnant, gestation_term, animal_id) VALUES
    (3, 'male', 3.4, 44.5, false, null, null, 1),
    (2, 'male', 45.4, 4.574, false, null, null, 2),
    (5, 'female', 45.4, 4.5, false, null, null, 3),
    (5, 'male', 37.4, 74.5, false, null, null, 4),
    (3, 'female', 32.4, 4.54, true, true, '2024-03-11', 5),
    (5, 'male', 73.4, 74.5, false, null, null, 6),
    (6, 'male', 35.4, 4.45, false, null, null, 7),
    (5, 'male', 38.4, 4.5, false, null, null, 8),
    (4, 'female', 33.74, 44.5, true, true, '2024-02-24', 9),
    (3, 'female', 3.44, 4.57, false, true, '2024-04-04', 10),
    (5, 'male', 3.74, 4.54, false, null, null, 11),
    (7, 'female', 38.4, 4.56, true, null, null, 12),
    (7, 'male', 3.44, 46.5, false, null, null, 13),
    (0, 'female', 53.4, 4.45, false, null, null, 15),
    (3, 'male', 3.47, 74.5, false, null, null, 16),
    (1, 'female', 3.44, 4.5, false, null, null, 17);

INSERT INTO animal_trainer_relation (animal_id, trainer_id) VALUES
    (1, 2),
    (2, 4),
    (3, 14),
    (4, 14);

INSERT INTO cleaner_cage_relation (cage_id, cleaner_id) VALUES
    (3, 1),
    (5, 3),
    (10, 5);

INSERT INTO vet_vet_card_relation (vet_card_id, vet_id) VALUES
    (1, 7),
    (2, 8),
    (3, 9),
    (3, 8);

INSERT INTO vaccination_history_record (date, vet_card_id, vaccination) VALUES
    ('2024-03-11', 1, 'CDV'),
    ('2023-04-12', 2, 'CAV'),
    ('2022-12-01', 3, 'CDV'),
    ('2024-09-30', 4, 'CAV');

INSERT INTO medical_history_record (date, vet_card_id, disease, treatment) VALUES
   ('2024-03-11', 1, 'Coronavirus', 'Isolation'),
   ('2023-04-12', 2, 'Scrapie', 'Isolation'),
   ('2022-12-01', 3, 'Coronavirus', 'Isolation'),
   ('2024-09-30', 4, 'Scrapie', 'Isolation');
