DROP TABLE IF EXISTS message;
--DROP SEQUENCE hibernate_sequence;
CREATE TABLE message(id serial PRIMARY KEY, type VARCHAR(10), content VARCHAR(255), sender VARCHAR(100));
--CREATE SEQUENCE hibernate_sequence START 1;