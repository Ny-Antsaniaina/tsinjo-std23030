CREATE TABLE donor (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(255),
                       name VARCHAR(255)
);

CREATE TABLE payment (
                         psp_payment_id VARCHAR(255) PRIMARY KEY,
                         status VARCHAR(50),
                         amount INT,
                         payment_date TIMESTAMP
);

CREATE TABLE donation (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          donor_id BIGINT,
                          payment_id VARCHAR(255),
                          donation_date TIMESTAMP,
                          CONSTRAINT fk_donor FOREIGN KEY (donor_id) REFERENCES donor(id),
                          CONSTRAINT fk_payment FOREIGN KEY (payment_id) REFERENCES payment(psp_payment_id)
);
