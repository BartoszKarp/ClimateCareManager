CREATE TABLE customers (
                           id UUID NOT NULL PRIMARY KEY,
                           first_name VARCHAR(255) NOT NULL,
                           last_name VARCHAR(255) NOT NULL,
                           address VARCHAR(255),
                           city VARCHAR(255),
                           phone_number VARCHAR(20),
                           email VARCHAR(255)
);

CREATE TABLE serviceTechnician (
                           id UUID NOT NULL PRIMARY KEY,
                           first_name VARCHAR(255) NOT NULL,
                           last_name VARCHAR(255) NOT NULL,
                           company_name VARCHAR(255),
                           phone_number VARCHAR(20),
                           email VARCHAR(255)
);

CREATE TABLE fitter (
                                   id UUID NOT NULL PRIMARY KEY,
                                   first_name VARCHAR(255) NOT NULL,
                                   last_name VARCHAR(255) NOT NULL,
                                   company_name VARCHAR(255),
                                   phone_number VARCHAR(20),
                                   email VARCHAR(255)
);

CREATE TABLE trader (
                                   id UUID NOT NULL PRIMARY KEY,
                                   first_name VARCHAR(255) NOT NULL,
                                   last_name VARCHAR(255) NOT NULL,
                                   company_name VARCHAR(255),
                                   phone_number VARCHAR(20),
                                   email VARCHAR(255)
);

