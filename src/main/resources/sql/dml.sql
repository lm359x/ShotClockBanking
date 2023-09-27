INSERT INTO roles (role_name) VALUES ('ROLE_USER'),('ROLE_ADMIN');
insert into users (username, password, role_id)  values
                                                     ('admin','admin',2),
                                                     ('default','default',1);
INSERT INTO customers (first_name, last_name, address, contact_details, user_id) VALUES
                                                                                     ('petr','petrov','127123','smth',2),
                                                                                     ('ivan','ivanov','123123','smth',3);

