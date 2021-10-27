DROP TABLE IF EXISTS AUTHOR;
DROP TABLE IF EXISTS BLOG;
DROP TABLE IF EXISTS CONTACT;
DROP TABLE IF EXISTS ADMIN;

CREATE TABLE ADMIN (
    ADMIN_ID VARCHAR(45) primary key,
    ADMIN_NAME VARCHAR(45) NOT NULL,
    ADMIN_EMAIL VARCHAR(45) NOT NULL,
    ADMIN_PASSWORD VARCHAR(45) NOT NULL
);

CREATE TABLE AUTHOR (
    AUTHOR_ID VARCHAR(45) primary key,
    AUTHOR_NAME VARCHAR(45) NOT NULL,
    AUTHOR_EMAIL VARCHAR(45) NOT NULL,
    AUTHOR_DESCRIPTION VARCHAR(45) NOT NULL,
    AUTHOR_AVATAR VARCHAR(45) NOT NULL,
    AUTHOR_PASSWORD VARCHAR(45) NOT NULL,
    ADMIN_ID VARCHAR(45),
        FOREIGN KEY (ADMIN_ID)
            REFERENCES ADMIN (ADMIN_ID)
);

CREATE TABLE BLOG (
    BLOG_ID VARCHAR(45) PRIMARY KEY,
    BLOG_NAME VARCHAR(450) NOT NULL,
    BLOG_INTRODUCTION VARCHAR(500) NOT NULL,
    BLOG_CONTENT VARCHAR(45) NOT NULL,
    BLOG_PICTURE VARCHAR(200) NOT NULL,
    BLOG_TYPE VARCHAR(45) NOT NULL,
    BLOG_DATE VARCHAR(45) NOT NULL,
    AUTHOR_ID VARCHAR(45),
        FOREIGN KEY (AUTHOR_ID)
            REFERENCES AUTHOR (AUTHOR_ID)

);

CREATE TABLE CONTACT (
    CONTACT_ID VARCHAR(45) PRIMARY KEY,
    CONTACT_NAME VARCHAR(45) NOT NULL,
    CONTACT_EMAIL_FROM VARCHAR(45) NOT NULL,
    CONTACT_MESSAGE VARCHAR(45) NOT NULL,
    AUTHOR_ID VARCHAR(45) NOT NULL,
        FOREIGN KEY (AUTHOR_ID)
            REFERENCES AUTHOR (AUTHOR_ID)
)
