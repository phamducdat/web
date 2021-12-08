-- INSERT INTO ADMIN (ADMIN_ID, ADMIN_NAME, ADMIN_EMAIL, ADMIN_PASSWORD) VALUES ('1', 'THANG', 'thang@gmail.com', '123')
--
--
-- INSERT INTO AUTHOR (AUTHOR_ID, AUTHOR_NAME ,AUTHOR_EMAIL, AUTHOR_DESCRIPTION, AUTHOR_AVATAR, AUTHOR_PASSWORD, ADMIN_ID) VALUES ('1', 'PHAM', 'phamducdat2402@gmail.com', 'TEST', 'PICTURE','123',1)
-- INSERT INTO AUTHOR(AUTHOR_ID, AUTHOR_NAME ,AUTHOR_EMAIL, AUTHOR_DESCRIPTION, AUTHOR_AVATAR, AUTHOR_PASSWORD, ADMIN_ID) VALUES ('2', 'DUC', 'PHAM@GMAIL.COM', 'TEST', 'AVATAR','123',1)
-- INSERT INTO AUTHOR(AUTHOR_ID, AUTHOR_NAME ,AUTHOR_EMAIL, AUTHOR_DESCRIPTION, AUTHOR_AVATAR, AUTHOR_PASSWORD, ADMIN_ID) VALUES ('3', 'DAT', 'PHAM@GMAIL.COM', 'TEST', 'AVA','123',1)
--
-- INSERT INTO BLOG (BLOG_ID, BLOG_NAME, BLOG_INTRODUCTION, BLOG_CONTENT, BLOG_PICTURE, BLOG_TYPE, BLOG_DATE, AUTHOR_ID) VALUES ('4', 'Wherever far wow thus a squirrel raccoon jeez jaguar this from along', 'The copy warned the Little Blind Text, that where it came from it would have been rewritten a thousand times and everything that was left from its origin would be the word \"and\" and the Little Blind', 'Content of Blog', 'https://www.nature.org/content/dam/tnc/nature/en/photos/tnc_48980557.jpg', 'ART','1990-09-01',1)
-- INSERT INTO BLOG(BLOG_ID, BLOG_NAME, BLOG_INTRODUCTION, BLOG_CONTENT, BLOG_PICTURE, BLOG_TYPE, BLOG_DATE, AUTHOR_ID) VALUES ('5', 'Coffe sugar, chicory seasonal espresso barista americano', 'Arista, percolator, cream, aromatic, fair trade, breve body instant lungo blue mountain cappuccino. Americano aroma mug espresso latte crema milk redeye acerbic. Galão robusta instant, decaffeinated, so fair trade wings', 'Content of Blog', 'https://natureconservancy-h.assetsadobe.com/is/image/content/dam/tnc/nature/en/photos/FreeFlowingRiver.jpg?crop=191,0,1322,992&wid=820&hei=615&scl=1.6130081300813008','BLOG','1990-09-03',2)
-- INSERT INTO BLOG(BLOG_ID, BLOG_NAME, BLOG_INTRODUCTION, BLOG_CONTENT, BLOG_PICTURE, BLOG_TYPE, BLOG_DATE, AUTHOR_ID) VALUES ('6', 'According a funnily until pre-set or arrogant well cheerful', 'Single shot cultivar beans as chicory caffeine. Medium brewed, milk extra that froth pumpkin spice mocha. Whipped redeye pumkin spice sweet, extraction to go macchiato acerbic steamed filter. Robusta grounds decaffeinated', 'Content of Blog', 'https://natureconservancy-h.assetsadobe.com/is/image/content/dam/tnc/nature/en/photos/robert-keane-1425463-unsplash.jpg?crop=0,0,3556,2667&wid=820&hei=615&scl=4.336585365853659', 'ART','1990-09-05',3)
--
-- INSERT INTO CONTACT(CONTACT_ID, CONTACT_NAME, CONTACT_EMAIL_FROM, CONTACT_MESSAGE, AUTHOR_ID) VALUES ('7', 'CONTACT_1', 'FROM','QUESTION', 1)
--
--

INSERT INTO ADMIN (ADMIN_ID, ADMIN_NAME, ADMIN_EMAIL, ADMIN_PASSWORD) VALUES ('1', 'THANG', 'thang@gmail.com', '$2a$10$3ttj4xzFQUBmJ8Xm1loyeOp5Yo4v/pwvpkQWwC4Yo550IOkseSS6K')


INSERT INTO AUTHOR (AUTHOR_ID, AUTHOR_NAME ,AUTHOR_EMAIL, AUTHOR_DESCRIPTION,AUTHOR_AVATAR, AUTHOR_PHONE,AUTHOR_DATE_OF_BIRTH, AUTHOR_PASSWORD, ADMIN_ID) VALUES ('1', 'PHAM', 'phamducdat2402@gmail.com', 'TEST','PICTURE','0977289','1999-02-24 01:02:03','$2a$10$3ttj4xzFQUBmJ8Xm1loyeOp5Yo4v/pwvpkQWwC4Yo550IOkseSS6K',1)
INSERT INTO AUTHOR (AUTHOR_ID, AUTHOR_NAME ,AUTHOR_EMAIL, AUTHOR_DESCRIPTION,AUTHOR_AVATAR, AUTHOR_PHONE,AUTHOR_DATE_OF_BIRTH, AUTHOR_PASSWORD, ADMIN_ID) VALUES ('2', 'DUC', 'phamducdat@gmail.com', 'TEST','PICTURE','77289','2019-12-31 01:02:03','$2a$10$3ttj4xzFQUBmJ8Xm1loyeOp5Yo4v/pwvpkQWwC4Yo550IOkseSS6K',1)
INSERT INTO AUTHOR (AUTHOR_ID, AUTHOR_NAME ,AUTHOR_EMAIL, AUTHOR_DESCRIPTION,AUTHOR_AVATAR, AUTHOR_PHONE,AUTHOR_DATE_OF_BIRTH, AUTHOR_PASSWORD, ADMIN_ID) VALUES ('3', 'DAT', 'phamducdat242@gmail.com', 'TEST','PICTURE','503','2019-12-31 01:02:03','$2a$10$3ttj4xzFQUBmJ8Xm1loyeOp5Yo4v/pwvpkQWwC4Yo550IOkseSS6K',1)

INSERT INTO CATEGORY (CATEGORY_ID, CATEGORY_NAME ,CATEGORY_TYPE) VALUES ('100','animal','ANIMAL')
INSERT INTO CATEGORY (CATEGORY_ID, CATEGORY_NAME ,CATEGORY_TYPE) VALUES ('101','science','SCIENCE')
INSERT INTO CATEGORY (CATEGORY_ID, CATEGORY_NAME ,CATEGORY_TYPE) VALUES ('102','engineering','ENGINEERING')

INSERT INTO BLOG (BLOG_ID, BLOG_NAME, BLOG_INTRODUCTION, BLOG_CONTENT, BLOG_PICTURE, BLOG_DATE, CATEGORY_NAME, AUTHOR_ID,CATEGORY_ID) VALUES ('4', 'name', 'intro', 'Content of Blog', 'https://www.nature.org/content/dam/tnc/nature/en/photos/tnc_48980557.jpg', '2019-12-31', 'animal',1,100)
INSERT INTO BLOG (BLOG_ID, BLOG_NAME, BLOG_INTRODUCTION, BLOG_CONTENT, BLOG_PICTURE, BLOG_DATE, CATEGORY_NAME, AUTHOR_ID,CATEGORY_ID) VALUES ('5', 'name', 'intro', 'Content of Blog', 'https://www.nature.org/content/dam/tnc/nature/en/photos/tnc_48980557.jpg', '2019-12-31', 'animal',1,101)
INSERT INTO BLOG (BLOG_ID, BLOG_NAME, BLOG_INTRODUCTION, BLOG_CONTENT, BLOG_PICTURE, BLOG_DATE, CATEGORY_NAME, AUTHOR_ID,CATEGORY_ID) VALUES ('6', 'name', 'intro', 'Content of Blog', 'https://www.nature.org/content/dam/tnc/nature/en/photos/tnc_48980557.jpg', '2019-12-31', 'animal',1,102)
--
-- INSERT INTO CONTACT(CONTACT_ID, CONTACT_NAME, CONTACT_EMAIL_FROM, CONTACT_MESSAGE, AUTHOR_ID) VALUES ('7', 'CONTACT_1', 'FROM','QUESTION', 1)



