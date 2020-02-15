USE exercises;
CREATE TABLE customers(
    customer_id INT NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(50),
    birthday DATE,
    city_id INT
);
CREATE TABLE cities(
    city_id INT NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(50)
);
CREATE TABLE orders(
    order_id INT NOT NULL AUTO_INCREMENT UNIQUE,
    customer_id INT
);
CREATE TABLE order_items(
    order_id INT NOT NULL UNIQUE ,
    item_id INT NOT NULL
);
CREATE TABLE items(
    item_id INT NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(50),
    item_type_id INT
);
CREATE TABLE item_types(
    item_type_id INT NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(50)
);
ALTER TABLE customers
    ADD CONSTRAINT pk_customer_id
    PRIMARY KEY (customer_id),
    ADD CONSTRAINT fk_city_cities_id
    FOREIGN KEY (city_id)
    REFERENCES cities(city_id);
ALTER TABLE cities
    ADD CONSTRAINT pk_city_id
    PRIMARY KEY (city_id);
ALTER TABLE orders
    ADD CONSTRAINT pk_order_id
    PRIMARY KEY (order_id),
    ADD CONSTRAINT fk_customer_customers_id
    FOREIGN KEY (customer_id)
    REFERENCES customers(customer_id);
ALTER TABLE order_items
    ADD CONSTRAINT pk_order_items
    PRIMARY KEY (order_id,item_id),
    ADD CONSTRAINT fk_order_orders_id
    FOREIGN KEY (order_id)
    REFERENCES orders(order_id),
    ADD CONSTRAINT fk_item_items_id
    FOREIGN KEY (item_id)
    REFERENCES items(item_id);
ALTER TABLE items
    ADD CONSTRAINT pk_item_id
    PRIMARY KEY (item_id),
    ADD CONSTRAINT fk_item_type_types_id
    FOREIGN KEY (item_type_id)
    REFERENCES item_types(item_type_id);
ALTER TABLE item_types
    ADD CONSTRAINT pk_item_type_id
    PRIMARY KEY (item_type_id);