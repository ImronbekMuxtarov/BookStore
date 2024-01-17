drop table if exists permissions cascade;
create table if not exists permissions(
    id int generated always as identity primary key,
    name varchar unique
);