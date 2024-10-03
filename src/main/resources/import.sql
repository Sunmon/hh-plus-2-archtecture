-- User
INSERT INTO users (user_id, name) VALUES (1, '10cm');
INSERT INTO users (user_id, name) VALUES (2, '권졍열');
INSERT INTO users (user_id, name) VALUES (3, '모기');
INSERT INTO users (user_id, name) VALUES (4, '모기왕');
INSERT INTO users (user_id, name) VALUES (5, '텀블러');
INSERT INTO users (user_id, name) VALUES (6, '스타벅스');
INSERT INTO users (user_id, name) VALUES (7, '사용자7');
INSERT INTO users (user_id, name) VALUES (8, '사용자8');
INSERT INTO users (user_id, name) VALUES (9, '사용자9');
INSERT INTO users (user_id, name) VALUES (10, '사용자10');
INSERT INTO users (user_id, name) VALUES (11, '사용자11');
INSERT INTO users (user_id, name) VALUES (12, '사용자12');
INSERT INTO users (user_id, name) VALUES (13, '사용자13');
INSERT INTO users (user_id, name) VALUES (14, '사용자14');
INSERT INTO users (user_id, name) VALUES (15, '사용자15');
INSERT INTO users (user_id, name) VALUES (16, '사용자16');
INSERT INTO users (user_id, name) VALUES (17, '사용자17');
INSERT INTO users (user_id, name) VALUES (18, '사용자18');
INSERT INTO users (user_id, name) VALUES (19, '사용자19');
INSERT INTO users (user_id, name) VALUES (20, '사용자20');
INSERT INTO users (user_id, name) VALUES (21, '사용자21');
INSERT INTO users (user_id, name) VALUES (22, '사용자22');
INSERT INTO users (user_id, name) VALUES (23, '사용자23');
INSERT INTO users (user_id, name) VALUES (24, '사용자24');
INSERT INTO users (user_id, name) VALUES (25, '사용자25');
INSERT INTO users (user_id, name) VALUES (26, '사용자26');
INSERT INTO users (user_id, name) VALUES (27, '사용자27');
INSERT INTO users (user_id, name) VALUES (28, '사용자28');
INSERT INTO users (user_id, name) VALUES (29, '사용자29');
INSERT INTO users (user_id, name) VALUES (30, '사용자30');
INSERT INTO users (user_id, name) VALUES (31, '사용자31');
INSERT INTO users (user_id, name) VALUES (32, '사용자32');
INSERT INTO users (user_id, name) VALUES (33, '사용자33');
INSERT INTO users (user_id, name) VALUES (34, '사용자34');
INSERT INTO users (user_id, name) VALUES (35, '사용자35');
INSERT INTO users (user_id, name) VALUES (36, '사용자36');
INSERT INTO users (user_id, name) VALUES (37, '사용자37');
INSERT INTO users (user_id, name) VALUES (38, '사용자38');
INSERT INTO users (user_id, name) VALUES (39, '사용자39');
INSERT INTO users (user_id, name) VALUES (40, '사용자40');

-- Teacher
INSERT INTO teachers (teacher_id, name) VALUES (1, '하선생');
INSERT INTO teachers (teacher_id, name) VALUES (2, '바선생');
INSERT INTO teachers (teacher_id, name) VALUES (3, '나선생');
--INSERT INTO teachers (teacher_id, name) VALUES (4, '김선생');
--INSERT INTO teachers (teacher_id, name) VALUES (5, '최선생');

-- Lecture
INSERT INTO lectures (lecture_id, name) VALUES (1, '새벽은깊어질');
INSERT INTO lectures (lecture_id, name) VALUES (2, '우린지금연락해야해');
INSERT INTO lectures (lecture_id, name) VALUES (3, '서로의안부를챙겨주며');
--INSERT INTO lectures (lecture_id, name) VALUES (4, '서로의안부를챙겨주며');
--INSERT INTO lectures (lecture_id, name) VALUES (5, '복잡한');
--INSERT INTO lectures (lecture_id, name) VALUES (6, '얘길들어주면돼');
--INSERT INTO lectures (lecture_id, name) VALUES (7, '오오오오오');

-- Schedule
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (1, 1, 1, '2024-01-01');
--INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (2, 1, 2, '2024-01-01');
--INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (3, 1, 3, '2024-01-01');
--INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (4, 1, 4, '2024-01-01');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (5, 2, 1, '2024-01-02');
--INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (6, 2, 2, '2024-01-02');
--INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (7, 2, 3, '2024-01-02');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (8, 3, 1, '2024-01-03');
INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (9, 3, 2, '2024-01-03');
--INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (10, 4, 1, '2024-01-04');
--INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (11, 5, 1, '2024-01-05');
--INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (12, 5, 1, '2024-01-05');
--INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (13, 6, 2, '2024-01-05');
--INSERT INTO schedules (schedule_id, lecture_id, teacher_id, schedule_date) VALUES (14, 6, 3, '2024-01-05');
