INSERT INTO "User" (id, username, password, nickname, email, bio, status, created_at, updated_at)
VALUES (100, 'eunson', '$2a$10$JJtPo4mrBAJcYgS/ZvFT1.Jel9wbncn7191Owpl322.R3/jo7rVKi', '은비땽', 'ebcode2021@gmail.com', 'This is a test user', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO "Todo" (id, user_id, content, favorite, completed, created_at, updated_at)
VALUES (1000, 100, '안녕', true, false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);