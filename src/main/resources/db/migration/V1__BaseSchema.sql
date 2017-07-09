
/* Drop Tables */

DROP TABLE IF EXISTS booking;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS "user";




/* Create Tables */

CREATE TABLE book
(
  book_id bigserial NOT NULL,
  book_name varchar NOT NULL,
  description varchar,
  book_owner bigint NOT NULL,
  PRIMARY KEY (book_id)
) WITHOUT OIDS;


CREATE TABLE booking
(
  booking_id bigserial NOT NULL,
  holder_id bigint NOT NULL,
  book_id bigint NOT NULL,
  start_date date NOT NULL,
  end_date date,
  PRIMARY KEY (booking_id)
) WITHOUT OIDS;


CREATE TABLE "user"
(
  user_id bigserial NOT NULL,
  first_name varchar NOT NULL,
  last_name varchar NOT NULL,
  email varchar,
  PRIMARY KEY (user_id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE booking
  ADD FOREIGN KEY (book_id)
REFERENCES book (book_id)
ON UPDATE RESTRICT
ON DELETE RESTRICT
;


ALTER TABLE book
  ADD FOREIGN KEY (book_owner)
REFERENCES "user" (user_id)
ON UPDATE RESTRICT
ON DELETE RESTRICT
;


ALTER TABLE booking
  ADD FOREIGN KEY (holder_id)
REFERENCES "user" (user_id)
ON UPDATE RESTRICT
ON DELETE RESTRICT
;



