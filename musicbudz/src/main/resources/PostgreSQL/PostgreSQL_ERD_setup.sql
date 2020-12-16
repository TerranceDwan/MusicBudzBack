drop table if exists reviews cascade;
drop table if exists comments cascade;
drop table if exists relationship cascade;
drop table if exists relationship_statuses cascade;
drop table if exists "user" cascade;

create table "user" (
	user_id serial primary key,
	email varchar unique not null,
	"password" varchar not null,
	user_name varchar unique not null,
	first_name varchar not null,
	last_name varchar not null
);

create table reviews (
	review_id serial primary key,
	user_id int references "user"(user_id),
	spotify_id varchar NOT NULL,
	"name" varchar not null,
	artist varchar not null,
	"type" varchar NOT NULL,
	rating float not null, 
	check (rating >= 0 and rating <= 5),
	title varchar not null,
	review varchar
);

create table comments (
	comment_id serial primary key,
	user_id int references "user"(user_id),
	review_id int references reviews(review_id),
	"time" timestamp,
	"comment" varchar not null
);

create table relationship_statuses (
	status_code int unique,
	status varchar
);

insert into relationship_statuses values (0, 'Pending');
insert into relationship_statuses values (1, 'Accepted');
insert into relationship_statuses values (2, 'Denied');
insert into relationship_statuses values (3, 'Deleted');

create table relationship (
	user_one_id int references "user"(user_id),
	user_two_id int references "user"(user_id),
	status int references relationship_statuses(status_code), 
	check (status >= 0 and status <= 2),
	action_user_id int not null,
	PRIMARY KEY(user_one_id, user_two_id)
);


