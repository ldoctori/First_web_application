CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
email varchar(100) not null,
phone varchar(100) not null,
password VARCHAR(100) not null);