create table extra_info
(
    id           INTEGER PRIMARY KEY,
    city         varchar(15) null,
    phone_number varchar(25) null,
    email        varchar(30) null,
    skype        varchar(30) null,
    age          int         null
);


create table person
(
    id            INTEGER PRIMARY KEY,

    name          varchar(50) null,
    login         varchar(50) null,
    password      varchar(20) null,
    surname       varchar(20) null,
    gender        varchar(20) null
--     extra_info_id int         null,
--     constraint person_ibfk_1
--         foreign key (extra_info_id) references extra_info (id)
);

-- create index extra_info_id
--     on person (extra_info_id);


