DROP TABLE IF EXISTS accommodation;

DROP TABLE IF EXISTS room_fair;

DROP TABLE IF EXISTS accommodation_room_fair_relation;

CREATE TABLE accommodation (
    id INT PRIMARY KEY,
    type VARCHAR(32),
    bed_type VARCHAR(32),
    max_guests INT,
    description VARCHAR(512)
);

CREATE TABLE room_fair (
    id INT PRIMARY KEY,
    value DOUBLE,
    season VARCHAR(32)
);

CREATE TABLE accommodation_room_fair_relation (
    id INT PRIMARY KEY,
    accommodation_id INT,
    room_fair_id INT,
    FOREIGN KEY (accommodation_id) REFERENCES accommodation(id),
    FOREIGN KEY (room_fair_id) REFERENCES room_fair(id)
);
