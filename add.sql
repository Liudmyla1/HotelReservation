use hoteldb;
insert into client (name, login, password) values 
('Mike', 'mike345', 'mike1pass'),
('Jake', 'jaksonn23', 'pass234jakk'),
('Maria', 'mariee257', 'mar32ia'),
('Anna', 'ann48', 'passw543'),
('Nicole', 'nike123', 'pass123nikee'),
('Roman', 'ronaldo', 'ronaldpass123'),
('James', 'jamm', 'waffle1pass');
insert into admin (name, login, password) values 
('Mike', 'admin', 'admin'),
('Jake', 'admin2', '12345'),
('Maria', 'admin3', 'passw123');
insert into room (number, capacity, category, cost, isFree) values
(1, 1, 'Standard', 450, 1),
(2, 1, 'Standard', 450, 0),
(3, 1, 'Standard', 450, 1),
(4, 2, 'Standard', 550, 1),
(5, 2, 'Standard', 550, 1),
(6, 2, 'Standard', 550, 0),
(10, 1, 'Luxe', 600, 1),
(11, 1, 'Luxe', 600, 1),
(12, 2, 'Luxe', 700, 0),
(13, 2, 'Luxe', 700, 1),
(27, 2, 'Business Suite', 800, 1),
(26, 2, 'Business Suite', 800, 0),
(28, 2, 'King Suite', 900, 1),
(34, 3, 'Family Suite', 750, 0),
(39, 3, 'Family Suite', 750, 1),
(38, 4, 'Family Suite', 850, 1),
(49, 3, 'Apartment', 2500, 1);