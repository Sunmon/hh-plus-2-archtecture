-- User
INSERT INTO users (user_id, name) VALUES (1, '10cm');
INSERT INTO users (user_id, name) VALUES (2, '권졍열');
INSERT INTO users (user_id, name) VALUES (3, '모기');
INSERT INTO users (user_id, name) VALUES (4, '모기왕');
INSERT INTO users (user_id, name) VALUES (5, '텀블러');
INSERT INTO users (user_id, name) VALUES (6, '스타벅스');

-- Teacher
INSERT INTO teachers (teacher_id, name) VALUES (1, '하선생');
INSERT INTO teachers (teacher_id, name) VALUES (2, '바선생');
INSERT INTO teachers (teacher_id, name) VALUES (3, '나선생');
INSERT INTO teachers (teacher_id, name) VALUES (4, '김선생');
INSERT INTO teachers (teacher_id, name) VALUES (5, '최선생');

-- Lecture
INSERT INTO lectures (lecture_id, name) VALUES (1, '새벽은깊어질');
INSERT INTO lectures (lecture_id, name) VALUES (2, '우린지금연락해야해');
INSERT INTO lectures (lecture_id, name) VALUES (3, '서로의안부를챙겨주며');
INSERT INTO lectures (lecture_id, name) VALUES (4, '서로의안부를챙겨주며');
INSERT INTO lectures (lecture_id, name) VALUES (5, '복잡한');
INSERT INTO lectures (lecture_id, name) VALUES (6, '얘길들어주면돼');
INSERT INTO lectures (lecture_id, name) VALUES (7, '오오오오오');

-- Schedule
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (1, 1, 1, '2024-01-01');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (2, 1, 2, '2024-01-01');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (3, 1, 3, '2024-01-01');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (4, 1, 4, '2024-01-01');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (5, 2, 1, '2024-01-02');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (6, 2, 2, '2024-01-02');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (7, 2, 3, '2024-01-02');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (8, 3, 1, '2024-01-03');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (9, 3, 2, '2024-01-03');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (10, 4, 1, '2024-01-04');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (11, 5, 1, '2024-01-05');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (12, 5, 1, '2024-01-05');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (13, 6, 2, '2024-01-05');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (14, 6, 3, '2024-01-05');
