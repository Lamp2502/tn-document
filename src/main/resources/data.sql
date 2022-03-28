INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@gmail.com', '{noop}password'),
       ('Admin', 'admin@javaops.ru', '{noop}admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO documents (NAME, number, content, status, customer, supplier, amount, created, modified)
VALUES                ('doc_1', '1', 'content_1', 'NO_VIEWED', 'ORGANIZATION_1', 'FACTORY_1', '1000', '2020-01-20 10:00:00', '2021-01-20 10:00:00'),
                      ('doc_2', '2', 'content_2', 'NO_VIEWED', 'ORGANIZATION_2', 'FACTORY_2', '2000', '2020-02-20 10:00:00', '2021-02-20 10:00:00'),
                      ('doc_3', '3', 'content_3', 'NO_VIEWED', 'ORGANIZATION_1', 'FACTORY_1', '3000', '2020-03-20 10:00:00', '2021-03-20 10:00:00'),
                      ('doc_4', '4', 'content_4', 'NO_VIEWED', 'ORGANIZATION_2', 'FACTORY_2', '4000', '2020-04-20 10:00:00', '2021-04-20 10:00:00');



