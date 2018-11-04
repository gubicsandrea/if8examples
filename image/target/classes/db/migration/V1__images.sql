create table Images (
    id bigint auto_increment,
    image_file mediumblob not null,
    file_type varchar(20) not null,
    file_name varchar(50) not null,
    constraint pk_images primary key (id)
);