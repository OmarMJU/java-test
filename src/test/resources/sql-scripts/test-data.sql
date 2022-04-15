CREATE TABLE IF NOT EXISTS movies(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL
);

insert into movies (name, minutes, genre) values ('Dark Knight', 152, 'ACTION');
insert into movies (name, minutes, genre) values ('Memento', 113, 'THRILLER');
insert into movies (name, minutes, genre) values ('Theres Something About Mary', 119, 'COMEDY');
insert into movies (name, minutes, genre) values ('Super 8', 112, 'THRILLER');
insert into movies (name, minutes, genre) values ('Scream', 111, 'HORROR');
insert into movies (name, minutes, genre) values ('Home Alon', 103, 'COMEDY');
insert into movies (name, minutes, genre) values ('Matrix', 112, 'ACTION');