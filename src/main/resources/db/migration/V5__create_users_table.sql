drop table if exists users cascade;
create table if not exists users(
    id int generated always as identity primary key,
    username varchar,
    password varchar,
    role varchar
);