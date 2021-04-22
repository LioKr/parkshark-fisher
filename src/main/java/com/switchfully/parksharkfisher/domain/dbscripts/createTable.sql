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
    number     varchar(10),
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
    id               integer default nextval('parkinglot_seq'::regclass) not null
        constraint parkinglots_pkey
            primary key,
    category         varchar(255),
    maxcapacity      integer,
    name             varchar(255),
    price            bigint,
    spots_in_use     integer,
    address_id       uuid
        constraint fk3b6fo74f3eflrpaafoeyli5qo
            references address,
    contactperson_id uuid
        constraint fkgmoe8jbe1g28cxrj15c7qecko
            references contactpersons,
    division_id      uuid                                                not null
        constraint fkbfjsvqey0m0k5ssx2i2m3o3h6
            references divisions
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
    mail                      varchar(60) not null,
    license_plate_platenumber varchar(60) not null
        constraint members_license_plate_plate_number_fk
            references license_plate,
    registration_date         date        not null,
    address_id                uuid        not null
        constraint members_address_id_fk
            references address,
    membership                text
);


create table allocations
(
    id            bigint default nextval('allocations_seq'::regclass) not null
        constraint allocations_pkey
            primary key,
    start_time    date,
    stop_time     date,
    member_id     uuid                                                not null
        constraint allocations_member_id_fk
            references members,
    parkinglot_id integer                                             not null
        constraint allocations_parkinglot_id_fk
            references parkinglots
);

