DROP TABLE IF EXISTS ACCOUNT;

CREATE TABLE ACCOUNT (
    ACCOUNT_NUMBER VARCHAR(50) NOT NULL PRIMARY KEY,
    ACCOUNT_HOLDERNAME VARCHAR(50) NOT NULL,
    PASSWORD VARCHAR(50) NOT NULL,
    BALANCE DOUBLE DEFAULT 0,
    STATUS VARCHAR(2) DEFAULT 1,
    CREATED_ON TIMESTAMP DEFAULT SYSTIMESTAMP,
    AADHAAR_NO VARCHAR(50) NOT NULL,
    CONSTRAINT ACCOUNT_PK PRIMARY KEY (ACCOUNT_NUMBER)
);

CREATE INDEX AADHAAR_STATUS_IDX ON ACCOUNT(AADHAAR_NO, STATUS);

DROP TABLE IF EXISTS TRANSACTION;

CREATE TABLE TRANSACTION (
    TXN_ID VARCHAR(50) NOT NULL PRIMARY KEY,
    TXN_TYPE VARCHAR(50) NOT NULL,
    ACCOUNT_NUMBER VARCHAR(50) NOT NULL,
    AMOUNT VARCHAR(50) NOT NULL,
    TRANSACTION_TIME TIMESTAMP DEFAULT SYSTIMESTAMP,
    CONSTRAINT TRANSACTION_PK PRIMARY KEY (TXN_ID)
);
