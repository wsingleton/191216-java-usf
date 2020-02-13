create table customer(
  customer_id varchar(36) primary key not null,
  first_name varchar(64),
  last_name varchar(64),
  street_address varchar(128),
  city varchar(64),
  state varchar(24),
  zip_code varchar(12),
  phone_number varchar(32)
);