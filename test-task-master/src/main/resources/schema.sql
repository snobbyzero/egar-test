create table CAR (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  power DOUBLE,
  year_of_issue YEAR
);

create table AIRPLANE (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  manufacturer VARCHAR2(500),
  year_of_issue YEAR,
  fuelCapacity INT,
  seats INT
);

create table CAR_ASSESSED_VALUES (
  id IDENTITY primary key,
  car_id INT,
  dt date,
  assessed_value DEC(20),
  foreign key (car_id) REFERENCES CAR(id)
);

create table AIRPLANE_ASSESSED_VALUES (
  id IDENTITY primary key,
  airplane_id INT,
  dt date,
  assessed_value DEC(20),
  foreign key (airplane_id) REFERENCES AIRPLANE(id)
);

