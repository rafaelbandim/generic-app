INSERT INTO users (username,password) VALUES ('rafael','{argon2}$argon2id$v=19$m=131072,t=5,p=1$vJGEUQugBLzbAkkIVsB3ig$OeOGs3hWDZuPiiyyRMoq+aKUYbiT9UGs14VMEEIhRLk');
INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO users_role_list (user_id, role_list_id) VALUES (1,1)