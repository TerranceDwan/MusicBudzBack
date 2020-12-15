drop table if exists review_album cascade;
drop table if exists review_song cascade;
drop table if exists comments_album cascade;
drop table if exists comments_song cascade;
drop table if exists relationships cascade;
drop table if exists relationship_statuses cascade;
drop table if exists users cascade;

create table users (
	id serial primary key,
	email varchar,
	"password" varchar,
	user_name varchar,
	first_name varchar,
	last_name varchar
);

create table review_album (
	id serial primary key,
	user_id int references users(id),
	album_name varchar,
	artist_name varchar,
	rating float, 
	check (rating >= 0 and rating <= 5),
	title varchar,
	review varchar
);

create table review_song (
	id serial primary key,
	user_id int references users(id),
	song_name varchar,
	artist_name varchar,
	rating float, 
	check (rating >= 0 and rating <= 5),
	title varchar,
	review varchar
);

create table comments_album (
	id serial primary key,
	user_id int references users(id),
	review_id int references review_album(id),
	"time" timestamp,
	"comment" varchar
);

create table comments_song (
	id serial primary key,
	user_id int references users(id),
	review_id int references review_song(id),
	"time" timestamp,
	"comment" varchar
);

create table relationship_statuses (
	status_code int unique,
	status varchar
);

create table relationships (
	user_one_id int references users(id),
	user_two_id int references users(id),
	status int references relationship_statuses(status_code), 
	check (status >= 0 and status <= 2),
	action_user_id int,
	PRIMARY KEY(user_one_id, user_two_id)
);


