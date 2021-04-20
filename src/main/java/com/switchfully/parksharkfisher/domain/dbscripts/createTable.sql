drop table if exists divisions cascade;
create table divisions
(
    id varchar(60) not null
        constraint divisions_pk
            primary key,
    division_name varchar(60) not null,
    original_name varchar(60),
    director varchar(60) not null
);

