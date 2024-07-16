INSERT INTO banks (name)
VALUES
    ('Santander'),
    ('Galicia'),
    ('Citibank');

INSERT INTO accounts (bank_id, country_code, balance)
VALUES
    (1, 'AR', 1000.0),
    (1, 'AR', 2000.0),
    (2, 'AR', 5000.0),
    (3, 'BR', 7000.0);