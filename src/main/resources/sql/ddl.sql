CREATE TABLE roles (
                       role_id SERIAL PRIMARY KEY,
                       role_name VARCHAR(20) NOT NULL
);

CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       role_id INT,
                       FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

CREATE TABLE customers (
                           customer_id SERIAL PRIMARY KEY,
                           first_name VARCHAR(50) NOT NULL,
                           last_name VARCHAR(50) NOT NULL,
                           address VARCHAR(250),
                           contact_details VARCHAR(100),
                           user_id INT,
                           FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE accounts (
                          account_id SERIAL PRIMARY KEY,
                          account_number INT NOT NULL,
                          account_type VARCHAR(20),
                          balance DECIMAL(18, 2),
                          owner_id INT,
                          monthly_payment DECIMAL(18, 2),
                          FOREIGN KEY (owner_id) REFERENCES customers(customer_id)
);

CREATE TABLE deposits (
                          deposit_id SERIAL PRIMARY KEY,
                          deposit_number INT NOT NULL,
                          balance DECIMAL(18, 2),
                          interest_rate DECIMAL(5, 2),
                          owner_id INT,
                          FOREIGN KEY (owner_id) REFERENCES customers(customer_id)
);

CREATE TABLE operations (
                              transaction_id SERIAL PRIMARY KEY,
                              account_id INT,
                              transaction_type VARCHAR(50) NOT NULL,
                              amount DECIMAL(18, 2) NOT NULL,
                              transaction_date TIMESTAMP NOT NULL,
                              FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);
