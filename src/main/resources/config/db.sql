drop database if exists albumshop;
create database albumshop;

use albumshop;

drop table if exists album;
drop table if exists song;

create table album
(
    id            bigint primary key,
    name          varchar(255) not null,
    artist        varchar(255) not null,
    imageUrl      varchar(255),
    artistNameUrl varchar(255),
    releaseDate   DATETIME     not null,
    genre         varchar(255) not null,
    description   varchar(2000)
);

create table song
(
    id       bigint primary key auto_increment,
    name     varchar(255) not null,
    duration int not null,
    album_id bigint not null,
    foreign key (album_id) references album (id)
);

insert into album (id, name, artist, imageUrl, artistNameUrl, releaseDate, genre, description)
values (1, 'The Dark Side of the Moon', 'Pink Floyd', 'https://upload.wikimedia.org/wikipedia/en/3/3b/Dark_Side_of_the_Moon.png', 'Pink_Floyd', '1973-03-01', 'Progressive rock', 'The Dark Side of the Moon is the eighth studio album by the English rock band Pink Floyd, released on 1 March 1973 by Harvest Records.'),
       (2,'Desire, I Want to Turn Into You','Caroline Polacheck','/images/desire_vinyl.png','/images/caroline_name.png','2023-06-28','Indie Pop','Desire, I Want to Turn Into You is the second studio album by American musician Caroline Polachek, released on April 1, 2022, through Perpetual Novice and Columbia Records.');

INSERT INTO song (name, duration, album_id) VALUES
                                                ('Welcome to My Island', 240, 2),
                                                ('Pretty In Possible', 210, 2),
                                                ('Bunny Is a Rider', 230, 2),
                                                ('Sunset', 200, 2),
                                                ('Crude Drawing of An Angel', 250, 2),
                                                ('I Believe', 220, 2),
                                                ('Fly To You (feat. Grimes & Dido)', 260, 2),
                                                ('Blood and Butter', 240, 2),
                                                ('Hopedrunk Everasking', 230, 2),
                                                ('Butterfly Net', 215, 2),
                                                ('Smoke', 225, 2),
                                                ('Billions', 270, 2);