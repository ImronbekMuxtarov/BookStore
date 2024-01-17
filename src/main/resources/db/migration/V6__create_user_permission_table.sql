drop table if exists user_permission cascade;
create table if not exists user_permission(
    user_id int references users(id) on delete cascade,
    permission_id int references permissions(id) on delete cascade
);
