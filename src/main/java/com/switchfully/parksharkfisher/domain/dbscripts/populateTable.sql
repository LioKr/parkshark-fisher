INSERT INTO address (id, city, number, postalcode, streetname)
VALUES ('ad2b77c1-e9ba-43af-924d-5b68b2db4698', 'city1', '001', '0001', 'street1');
INSERT INTO address (id, city, number, postalcode, streetname)
VALUES ('ae3b6865-c681-4d88-aee4-aff4e99f95ab', 'cityToo', '200', '2000', 'streetOfCityToo');
INSERT INTO address (id, city, number, postalcode, streetname)
VALUES ('210e74f2-94d7-4baa-902d-5de8ffea78a2', 'bigcity', '42', '1000', 'streety');
INSERT INTO address (id, city, number, postalcode, streetname)
VALUES ('838f96d9-dca8-4525-be7c-d626ac04fef5', 'personcity1', '42', '1000', 'streety');
INSERT INTO address (id, city, number, postalcode, streetname)
VALUES ('cf018587-90e3-4e72-b274-fe07c2de47fd', 'personcity2', '42', '1000', 'streety');
INSERT INTO address (id, city, number, postalcode, streetname)
VALUES ('2b5d660a-8f30-497e-9224-2d11266497f1', 'personcity3', '42', '1000', 'streety');
INSERT INTO address (id, city, number, postalcode, streetname)
VALUES ('4f37c39e-1448-40cb-b6d8-343cb3636fe7', 'membercity1', '42', '1000', 'streety');
INSERT INTO address (id, city, number, postalcode, streetname)
VALUES ('3f317873-5097-443c-b08f-d7042179df29', 'membercity2', '42', '1000', 'streety');
INSERT INTO address (id, city, number, postalcode, streetname)
VALUES ('52a69cac-2c90-403e-9427-0a2094b493ef', 'membercity3', '42', '1000', 'streety');
SELECT *
FROM address;



INSERT INTO contactpersons (id, emailaddress, firstname, lastname, mobilephone, telephone, address_id)
VALUES ('fdcd59ff-7416-431a-a766-0f42eb59b9cc', 'fake@mail.com1', 'firstname1', 'lastname1', '0456101010', '070000000',
        '838f96d9-dca8-4525-be7c-d626ac04fef5');
INSERT INTO contactpersons (id, emailaddress, firstname, lastname, mobilephone, telephone, address_id)
VALUES ('b93699c8-336b-4e83-a8dd-52d365a089a4', 'fake@mail.com2', 'firstname2', 'lastname2', '0456222222', '070222222',
        'cf018587-90e3-4e72-b274-fe07c2de47fd');
INSERT INTO contactpersons (id, emailaddress, firstname, lastname, mobilephone, telephone, address_id)
VALUES ('375da882-0758-40e2-9fbe-acce32f380e3', 'fake@mail.com3', 'firstname3', 'lastname3', '0456333333', '070333333',
        '2b5d660a-8f30-497e-9224-2d11266497f1');
SELECT *
FROM contactpersons;



INSERT INTO divisions(id, division_name, original_name, director)
VALUES ('0197a8ed-5b86-49c4-bc46-c1b8bdef31bf', 'division1', 'originalname1', 'mrdirector1');
INSERT INTO divisions(id, division_name, original_name, director)
VALUES ('60e9757a-0acb-49c4-950c-6ab09022dda1', 'division2', 'originalname2', 'mrdirector2');
INSERT INTO divisions(id, division_name, original_name, director)
VALUES ('30cae31e-40ea-4712-94b1-bd8e5ad5331c', 'division3', 'originalname3', 'mrdirector3');
INSERT INTO divisions(id, division_name, original_name, director)
VALUES ('bf123fd4-4f04-45f6-a23e-7ae2bebe55a1', 'division4', 'originalname4', 'mrdirector4');
INSERT INTO divisions(id, division_name, original_name, director)
VALUES ('4039e6f5-81cc-4cc5-92f6-fbcfcafdf57c', 'division5', 'originalname5', 'mrdirector5');
INSERT INTO divisions(id, division_name, original_name, director)
VALUES ('82e07725-9839-4f4f-b3e4-7ea844248b96', 'division6', 'originalname6', 'mrdirector6');
SELECT *
FROM divisions;


INSERT INTO parkinglots (category, maxcapacity, name, price, spots_in_use, address_id, contactperson_id, division_id)
VALUES ('UNDERGROUND_BUILDING', 100, 'parkinglot_1', 10222333, 5000, 'ad2b77c1-e9ba-43af-924d-5b68b2db4698',
        'fdcd59ff-7416-431a-a766-0f42eb59b9cc', '0197a8ed-5b86-49c4-bc46-c1b8bdef31bf');
INSERT INTO parkinglots (category, maxcapacity, name, price, spots_in_use, address_id, contactperson_id, division_id)
VALUES ('ABOVE_GROUND_BUILDING', 200, 'parkinglot_2', 20222222, 50002, 'ae3b6865-c681-4d88-aee4-aff4e99f95ab',
        'b93699c8-336b-4e83-a8dd-52d365a089a4', '60e9757a-0acb-49c4-950c-6ab09022dda1');
SELECT *
FROM parkinglots;



INSERT INTO license_plate (plate_number, issuing_country)
VALUES ('000AAA111', 'Belgium');
INSERT INTO license_plate (plate_number, issuing_country)
VALUES ('000AAA222', 'Belgium');
INSERT INTO license_plate (plate_number, issuing_country)
VALUES ('000AAA333', 'Belgium');
SELECT *
FROM license_plate;



INSERT INTO members(id, firstname, lastname, phone_number, mail, license_plate_platenumber, registration_date,
                    address_id, membership)
VALUES ('a5f3a873-6f10-482a-a3a0-09259fd10641', 'firstname1', 'lastname1', '0475938475', 'mail1@mail.com', '000AAA111',
        '2020-02-01', '4f37c39e-1448-40cb-b6d8-343cb3636fe7', 'BRONZE');
INSERT INTO members(id, firstname, lastname, phone_number, mail, license_plate_platenumber, registration_date,
                    address_id, membership)
VALUES ('85472233-c400-4744-bd8e-eafa497b38fc', 'firstname2', 'lastname2', '0475125475', 'mail2@mail.com', '000AAA222',
        '2020-02-02', '3f317873-5097-443c-b08f-d7042179df29', 'GOLD');
SELECT *
FROM members;