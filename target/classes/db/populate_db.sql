INSERT INTO users(username, email, password, beerkind, gender, interests) values('Fadejimi', 'ade@gmail.com',
'password', 'Gulder', 'M', 'Football,Dancing');

INSERT INTO users(username, email, password, beerkind, gender, interests) values('Admin', 'admin@gmail.com',
                                                                                 'admin', 'Gulder', 'M', 'Football,Dancing');

INSERT INTO user_roles (username, role)
VALUES ('Fadejimi', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('Admin', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('Admin', 'ROLE_USER');
