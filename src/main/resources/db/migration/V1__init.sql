CREATE TABLE customer
(
    id    char(36)     NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE product
(
    id           char(36)     NOT NULL,
    name         VARCHAR(255) NULL,
    price        BIGINT       NULL,
    publish_date datetime     NULL,
    customer_id  char(36)     NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);