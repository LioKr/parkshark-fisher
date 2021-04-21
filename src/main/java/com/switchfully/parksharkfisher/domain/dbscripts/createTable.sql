drop table if exists divisions cascade;
create table divisions
(
    id            uuid        not null
        constraint divisions_pk
            primary key,
    division_name varchar(60) not null,
    original_name varchar(60),
    director      varchar(60) not null
);
create table address
(
    id         uuid
        constraint address_pk
            primary key,
    streetname varchar(25),
    number     varchar(5),
    postalcode varchar(8),
    city       varchar(25)
);
create table contactpersons
(
    id           uuid
        constraint contactpersons_pk
            primary key,
    firstname    varchar(15),
    lastname     varchar(15),
    mobilephone  varchar(25),
    telephone    varchar(25),
    emailaddress varchar(32),
    address_id   uuid,
    constraint contactpersons_address_id_fk
        foreign key (address_id) references address (id)
);

create table parkinglots
(
    id               integer
        constraint parkinglots_pk
            primary key,
    name             varchar(25),
    maxcapacity      integer,
    contactperson_id uuid,
    address_id       uuid,
    price            bigint,
    category         text,
    constraint parkinglots_contactpersons_id_fk
        foreign key (contactperson_id) references contactpersons,
    constraint parkinglots_address_id_fk
        foreign key (address_id) references address (id)
);

