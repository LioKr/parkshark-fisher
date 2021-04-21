drop table if exists divisions cascade;
create table divisions
(
    id uuid not null
        constraint divisions_pk
            primary key,
    division_name varchar(60) not null,
    original_name varchar(60),
    director varchar(60) not null
);
create table address
(
    id uuid
        constraint address_pk
            primary key,
    streetname varchar(25),
    number varchar(5),
    postalcode varchar(8),
    city varchar(25)
);
create table contactpersons
(
    id uuid
        constraint contactpersons_pk
            primary key,
    firstname varchar(15),
    lastname varchar(15),
    mobilephone varchar(25),
    telephone varchar(25),
    emailaddress varchar(32),
    address varchar(32)
);

create table license_plate
(
    plate_number    varchar(60) not null
        constraint license_plate_pk
            primary key,
    issuing_country varchar(60) not null
);


create table members
(
    id                        uuid        not null
        constraint members_pk
            primary key,
    firstname                 varchar(60) not null,
    lastname                  varchar(60) not null,
    phone_number              varchar(60) not null,
    license_plate_platenumber varchar(60) not null
        constraint members_license_plate_plate_number_fk
            references license_plate,
    "registrationDate"        date        not null,
    address_id                uuid        not null
        constraint members_address_id_fk
            references address
);

