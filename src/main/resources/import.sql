DROP TABLE IF EXISTS message;
--DROP SEQUENCE hibernate_sequence;
CREATE TABLE message(id serial PRIMARY KEY, type VARCHAR(10), content VARCHAR(255), sender VARCHAR(100));
--CREATE SEQUENCE hibernate_sequence START 1;

INSERT INTO message(type, content, sender) VALUES('CHAT', 'Hello from Jason', 'Jason');
INSERT INTO message(type, content, sender) VALUES('CHAT', 'How are you', 'Brick');
INSERT INTO message(type, content, sender) VALUES('CHAT', 'good to know you', 'Beck');
INSERT INTO message(type, content, sender) VALUES('CHAT', 'Yo', 'Youth');
