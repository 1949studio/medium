-- CREATE SEQUENCE IF NOT EXISTS user_seq;

-- CREATE TABLE IF NOT EXISTS users (
-- user_id BIGINT NOT NULL DEFAULT nextval('user_seq') PRIMARY KEY,
-- username VARCHAR(20) NOT NULL,
-- first_name VARCHAR(100) NOT NULL,
-- last_name VARCHAR(100) NOT NULL,
-- email VARCHAR(100) NOT NULL,
-- password VARCHAR(100) NOT NULL
-- );

-- CREATE SEQUENCE IF NOT EXISTS post_seq;

-- CREATE TABLE IF NOT EXISTS posts (
-- post_id BIGINT NOT NULL DEFAULT nextval('post_seq') PRIMARY KEY,
-- message VARCHAR(100) NOT NULL,
-- mediaurl VARCHAR(100) NOT NULL,
-- created_time TIMESTAMP,
-- user_id BIGINT NOT NULL
-- );