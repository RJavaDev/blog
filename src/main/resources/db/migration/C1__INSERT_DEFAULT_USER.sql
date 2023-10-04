-- create default user
INSERT INTO blog_user(status, created_date, firstname,phone_number, password, role_enum_list, username)
VALUES
      ('CREATED', now(), 'admin','+998901389918','$2a$10$lEKCKIESDYcyh/AIPHvxt.RDnCOutssyyWiGibf7t.nOWhGpq2xO.','{ADMIN}', 'admin')