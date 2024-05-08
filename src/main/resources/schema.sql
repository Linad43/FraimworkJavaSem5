create table tasks(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    text VARCHAR(50) NOT NULL,
    status boolean not null default 0
);