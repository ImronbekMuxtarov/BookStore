drop table if exists books cascade;
create table books(
    id int generated always as identity primary key,
    title varchar,
    author_id int references authors(id) on delete cascade,
    category_id int references categories(id) on delete cascade,
    year int,
    language varchar
);