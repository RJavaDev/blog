-- create user table
CREATE TABLE blog_user
(
    id             SERIAL PRIMARY KEY,
    created_date   TIMESTAMP    NOT NULL,
    firstname      VARCHAR(255),
    phone_number   VARCHAR(255) NOT NULL,
    username       VARCHAR(255) NOT NULL,
    password       VARCHAR(255) NOT NULL,
    role_enum_list VARCHAR(255) ARRAY,
    status         VARCHAR(32) DEFAULT 'CREATED'
);

-- create default user
INSERT INTO blog_user(status, created_date, firstname, phone_number, password, role_enum_list, username)
VALUES ('CREATED', now(), 'admin', '+998901389918', '$2a$10$lEKCKIESDYcyh/AIPHvxt.RDnCOutssyyWiGibf7t.nOWhGpq2xO.',
        '{ADMIN}', 'admin')