DROP SCHEMA IF EXISTS bank CASCADE;
CREATE SCHEMA bank;

CREATE TABLE banks(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE accounts(
    id SERIAL NOT NULL PRIMARY KEY,
    bank_id INT NOT NULL,
    country_code CHAR(2) NOT NULL,
    balance DECIMAL NOT NULL,
    FOREIGN KEY (bank_id) REFERENCES banks (id)
);

CREATE TABLE transactions(
    transaction_id SERIAL NOT NULL PRIMARY KEY,
    origin_id INT NOT NULL,
    destination_id INT NOT NULL,
    FOREIGN KEY (origin_id) REFERENCES accounts (id),
    FOREIGN KEY (destination_id) REFERENCES accounts (id),
    amount DECIMAL NOT NULL
);
