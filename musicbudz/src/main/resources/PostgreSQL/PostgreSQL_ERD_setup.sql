drop table if exists album_review cascade;
drop table if exists song_review cascade;
drop table if exists album_comment cascade;
drop table if exists song_comment cascade;
drop table if exists relationship cascade;
drop table if exists relationship_statuses cascade;
drop table if exists "user" cascade;

create table "user" (
	user_id serial primary key,
	email varchar,
	"password" varchar,
	user_name varchar,
	first_name varchar,
	last_name varchar
);

create table album_review (
	review_id serial primary key,
	user_id int references "user"(user_id),
	album_name varchar,
	artist_name varchar,
	rating float, 
	check (rating >= 0 and rating <= 5),
	title varchar,
	review varchar
);

create table song_review (
	review_id serial primary key,
	user_id int references "user"(user_id),
	song_name varchar,
	artist_name varchar,
	rating float, 
	check (rating >= 0 and rating <= 5),
	title varchar,
	review varchar
);

create table album_comment (
	comment_id serial primary key,
	user_id int references "user"(user_id),
	review_id int references album_review(review_id),
	"time" timestamp,
	"comment" varchar
);

create table song_comment (
	comment_id serial primary key,
	user_id int references "user"(user_id),
	review_id int references song_review(review_id),
	"time" timestamp,
	"comment" varchar
);

create table relationship_statuses (
	status_code int unique,
	status varchar
);

insert into relationship_statuses values (0, 'Pending');
insert into relationship_statuses values (1, 'Accepted');
insert into relationship_statuses  values (2, 'Denied');

create table relationship (
	user_one_id int references "user"(user_id),
	user_two_id int references "user"(user_id),
	status int references relationship_statuses(status_code), 
	check (status >= 0 and status <= 2),
	action_user_id int,
	PRIMARY KEY(user_one_id, user_two_id)
);


