create table users (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	email varchar(255) not null,
	password_hash varchar(255) not null,
);

create table beans (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	name varchar(255) not null,
);

