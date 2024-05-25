
INSERT INTO especialidad (nombre)
VALUES
    ('Corte de cabello masculino'),
    ('Corte de cabello femenino'),
    ('Coloración de cabello'),
    ('Peinados y recogidos'),
    ('Tratamientos capilares'),
    ('Manicura y pedicura'),
    ('Depilación facial'),
    ('Masajes capilares'),
    ('Maquillaje para eventos'),
    ('Tratamientos de keratina'),
    ('Extensiones de cabello'),
    ('Alisado permanente'),
    ('Tinte de cejas y pestañas'),
    ('Tratamientos anticaspa'),
    ('Tratamientos anticaída'),
    ('Baños de color'),
    ('Tratamientos de brillo'),
    ('Corte de barba y perfilado'),
    ('Servicio de barbería'),
    ('Diseño de cejas'),
    ('Masajes de cuero cabelludo'),
    ('Pedicura spa'),
    ('Maquillaje de novia'),
    ('Recogidos para eventos'),
    ('Peinados infantiles'),
    ('Servicios para caballeros'),
    ('Retoques de color'),
    ('Peinados vintage'),
    ('Servicio de spa capilar');


-- Registro 1: Corte de cabello masculino
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Corte de cabello masculino', 'Corte de cabello para hombres', 60.0, 25.0);

-- Registro 2: Corte de cabello femenino
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Corte de cabello femenino', 'Corte de cabello para mujeres', 75.0, 30.0);

-- Registro 3: Coloración de cabello
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Coloración de cabello', 'Servicio de tintura para el cabello', 90.0, 50.0);

-- Registro 4: Manicura y pedicura
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Manicura y pedicura', 'Servicio de manicura y pedicura básica', 45.0, 20.0);

-- Registro 5: Maquillaje para eventos
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Maquillaje para eventos', 'Maquillaje profesional para ocasiones especiales', 60.0, 40.0);

-- Registro 6: Depilación facial
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Depilación facial', 'Depilación de áreas faciales', 30.0, 15.0);

-- Registro 7: Tratamientos capilares
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Tratamientos capilares', 'Tratamientos específicos para el cabello', 120.0, 70.0);

-- Registro 8: Peinados y recogidos
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Peinados y recogidos', 'Servicio de peinados y recogidos para eventos', 90.0, 45.0);

-- Registro 9: Extensiones de cabello
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Extensiones de cabello', 'Aplicación de extensiones capilares', 180.0, 100.0);

-- Registro 10: Tratamientos de keratina
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Tratamientos de keratina', 'Tratamiento para alisado y nutrición capilar', 150.0, 80.0);

-- Registro 11: Tinte de cejas y pestañas
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Tinte de cejas y pestañas', 'Tinte para cejas y pestañas', 45.0, 25.0);

-- Registro 12: Masajes capilares
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Masajes capilares', 'Masajes relajantes para el cuero cabelludo', 30.0, 20.0);

-- Registro 13: Baños de color
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Baños de color', 'Servicio de baño de color para el cabello', 90.0, 40.0);

-- Registro 14: Tratamientos anticaspa
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Tratamientos anticaspa', 'Tratamientos específicos para la caspa', 60.0, 35.0);

-- Registro 15: Tratamientos anticaída
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Tratamientos anticaída', 'Tratamientos para prevenir la caída del cabello', 120.0, 60.0);

-- Registro 16: Alisado permanente
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Alisado permanente', 'Servicio de alisado permanente del cabello', 180.0, 90.0);

-- Registro 17: Diseño de cejas
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Diseño de cejas', 'Diseño y perfilado de cejas', 30.0, 15.0);

-- Registro 18: Pedicura spa
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Pedicura spa', 'Pedicura con tratamiento spa', 60.0, 30.0);

-- Registro 19: Peinados infantiles
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Peinados infantiles', 'Peinados creativos para niños', 45.0, 25.0);

-- Registro 20: Servicio de barbería
INSERT INTO Servicio (nombre, descripcion, duracion, precio)
VALUES ('Servicio de barbería', 'Servicios de barbería para caballeros', 60.0, 35.0);

INSERT INTO ciudad (nombre)
VALUES
    ('Bogotá'),
    ('Medellín'),
    ('Cali'),
    ('Barranquilla'),
    ('Cartagena'),
    ('Cúcuta'),
    ('Bucaramanga'),
    ('Pereira'),
    ('Santa Marta'),
    ('Ibagué'),
    ('Pasto'),
    ('Villavicencio'),
    ('Manizales'),
    ('Neiva'),
    ('Armenia'),
    ('Valledupar'),
    ('Montería'),
    ('Sincelejo'),
    ('Popayán'),
    ('Tunja'),
    ('Riohacha'),
    ('Quibdó'),
    ('Arauca'),
    ('Yopal'),
    ('Mocoa'),
    ('San José del Guaviare'),
    ('Puerto Carreño'),
    ('Mitú'),
    ('Leticia');

INSERT INTO empleado (id_usuario, contrasena, email, tipo_usuario, direccion, fecha_nacimiento, imagen_url, nombre, telefono, id_ciudad)
VALUES
    ('1234567890', 'clave123', 'empleado1@example.com', 'EMP', 'Calle Principal #123', '1990-05-20 00:00:00', 'url_imagen1.jpg', 'Juan Pérez', '1234567890', 1),
    ('2345678901', 'password123', 'empleado2@example.com', 'EMP', 'Avenida Central #45', '1985-08-12 00:00:00', 'url_imagen2.jpg', 'María González', '2345678901', 2),
    ('3456789012', 'clave456', 'empleado3@example.com', 'EMP', 'Calle Nueva #67', '1993-02-28 00:00:00', 'url_imagen3.jpg', 'Carlos Rodríguez', '3456789012', 1),
    ('4567890123', 'password456', 'empleado4@example.com', 'EMP', 'Plaza Mayor #89', '1988-11-15 00:00:00', 'url_imagen4.jpg', 'Ana López', '4567890123', 3),
    ('5678901234', 'clave789', 'empleado5@example.com', 'EMP', 'Calle Solitaria #10', '1995-04-03 00:00:00', 'url_imagen5.jpg', 'Pedro Sánchez', '5678901234', 2),
    ('6789012345', 'password789', 'empleado6@example.com', 'EMP', 'Avenida Principal #21', '1991-09-08 00:00:00', 'url_imagen6.jpg', 'Laura Martínez', '6789012345', 3),
    ('7890123456', 'clave000', 'empleado7@example.com', 'EMP', 'Calle Central #33', '1987-06-25 00:00:00', 'url_imagen7.jpg', 'Roberto Jiménez', '7890123456', 1),
    ('8901234567', 'password000', 'empleado8@example.com', 'EMP', 'Avenida Primavera #76', '1994-12-10 00:00:00', 'url_imagen8.jpg', 'Isabel Gutiérrez', '8901234567', 2),
    ('9012345678', 'clave999', 'empleado9@example.com', 'EMP', 'Calle Nueva #11', '1992-03-17 00:00:00', 'url_imagen9.jpg', 'Javier Hernández', '9012345678', 3),
    ('0123456789', 'password999', 'empleado10@example.com', 'EMP', 'Avenida Principal #5', '1989-07-29 00:00:00', 'url_imagen10.jpg', 'Sofía Pérez', '0123456789', 1);
-- Registro 1: Empleado 1 con Servicio 1
INSERT INTO empleado_servicio (id_usuario, id_servicio)
VALUES ('1234567890', 1);

-- Registro 2: Empleado 2 con Servicio 2
INSERT INTO empleado_servicio (id_usuario, id_servicio)
VALUES ('2345678901', 2);

-- Registro 3: Empleado 3 con Servicio 3
INSERT INTO empleado_servicio (id_usuario, id_servicio)
VALUES ('3456789012', 3);

-- Registro 4: Empleado 4 con Servicio 4
INSERT INTO empleado_servicio (id_usuario, id_servicio)
VALUES ('4567890123', 4);

-- Registro 5: Empleado 5 con Servicio 5
INSERT INTO empleado_servicio (id_usuario, id_servicio)
VALUES ('5678901234', 5);

-- Registro 6: Empleado 6 con Servicio 6
INSERT INTO empleado_servicio (id_usuario, id_servicio)
VALUES ('6789012345', 6);

-- Registro 7: Empleado 7 con Servicio 7
INSERT INTO empleado_servicio (id_usuario, id_servicio)
VALUES ('7890123456', 7);

-- Registro 8: Empleado 8 con Servicio 8
INSERT INTO empleado_servicio (id_usuario, id_servicio)
VALUES ('8901234567', 8);

-- Registro 9: Empleado 9 con Servicio 9
INSERT INTO empleado_servicio (id_usuario, id_servicio)
VALUES ('9012345678', 9);

-- Registro 10: Empleado 10 con Servicio 10
INSERT INTO empleado_servicio (id_usuario, id_servicio)
VALUES ('0123456789', 10);

-- Continuar con más registros según sea necesario para relacionar todos los empleados con servicios

-- Empleado 1 - Disponibilidad
-- Empleado 1 - Disponibilidad
INSERT INTO disponibilidad (fecha, hora, estado, empleado_id_usuario)
VALUES ('2024-05-16', '08:00 AM', 'Libre', '1234567890'),
       ('2024-05-17', '09:00 AM', 'Libre', '1234567890'),
       ('2024-05-18', '10:00 AM', 'Libre', '1234567890');

-- Empleado 2 - Disponibilidad
INSERT INTO disponibilidad (fecha, hora, estado, empleado_id_usuario)
VALUES ('2024-05-16', '11:00 AM', 'Libre', '2345678901'),
       ('2024-05-17', '12:00 PM', 'Libre', '2345678901'),
       ('2024-05-18', '01:00 PM', 'Libre', '2345678901');

-- Empleado 3 - Disponibilidad
INSERT INTO disponibilidad (fecha, hora, estado, empleado_id_usuario)
VALUES ('2024-05-16', '02:00 PM', 'Libre', '3456789012'),
       ('2024-05-17', '03:00 PM', 'Libre', '3456789012'),
       ('2024-05-18', '04:00 PM', 'Libre', '3456789012');

-- Empleado 4 - Disponibilidad
INSERT INTO disponibilidad (fecha, hora, estado, empleado_id_usuario)
VALUES ('2024-05-16', '05:00 PM', 'Libre', '4567890123'),
       ('2024-05-17', '06:00 PM', 'Libre', '4567890123'),
       ('2024-05-18', '07:00 PM', 'Libre', '4567890123');

-- Empleado 5 - Disponibilidad
INSERT INTO disponibilidad (fecha, hora, estado, empleado_id_usuario)
VALUES ('2024-05-16', '08:00 PM', 'Libre', '5678901234'),
       ('2024-05-17', '09:00 PM', 'Libre', '5678901234'),
       ('2024-05-18', '10:00 PM', 'Libre', '5678901234');

-- Empleado 6 - Disponibilidad
INSERT INTO disponibilidad (fecha, hora, estado, empleado_id_usuario)
VALUES ('2024-05-16', '11:00 PM', 'Libre', '6789012345'),
       ('2024-05-17', '12:00 AM', 'Libre', '6789012345'),
       ('2024-05-18', '01:00 AM', 'Libre', '6789012345');

-- Empleado 7 - Disponibilidad
INSERT INTO disponibilidad (fecha, hora, estado, empleado_id_usuario)
VALUES ('2024-05-16', '02:00 AM', 'Libre', '7890123456'),
       ('2024-05-17', '03:00 AM', 'Libre', '7890123456'),
       ('2024-05-18', '04:00 AM', 'Libre', '7890123456');

-- Empleado 8 - Disponibilidad
INSERT INTO disponibilidad (fecha, hora, estado, empleado_id_usuario)
VALUES ('2024-05-16', '05:00 AM', 'Libre', '8901234567'),
       ('2024-05-17', '06:00 AM', 'Libre', '8901234567'),
       ('2024-05-18', '07:00 AM', 'Libre', '8901234567');

-- Empleado 9 - Disponibilidad
INSERT INTO disponibilidad (fecha, hora, estado, empleado_id_usuario)
VALUES ('2024-05-16', '08:00 AM', 'Libre', '9012345678'),
       ('2024-05-17', '09:00 AM', 'Libre', '9012345678'),
       ('2024-05-18', '10:00 AM', 'Libre', '9012345678');

-- Empleado 10 - Disponibilidad
INSERT INTO disponibilidad (fecha, hora, estado, empleado_id_usuario)
VALUES ('2024-05-16', '11:00 AM', 'Libre', '0123456789'),
       ('2024-05-17', '12:00 PM', 'Libre', '0123456789'),
       ('2024-05-18', '01:00 PM', 'Libre', '0123456789');
INSERT INTO Producto (nombre, descripcion, precio, stock_dispo, imagen_url) VALUES
                                                                                ('Shampoo Reparador', 'Shampoo que repara y fortalece el cabello dañado', 15.99, 50, 'https://images.pexels.com/photos/3872899/pexels-photo-3872899.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Acondicionador Nutritivo', 'Acondicionador con ingredientes nutritivos para el cabello', 14.99, 60, 'https://images.pexels.com/photos/4465828/pexels-photo-4465828.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Mascarilla Hidratante', 'Mascarilla que hidrata profundamente el cabello', 18.50, 40, 'https://images.pexels.com/photos/4465969/pexels-photo-4465969.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Gel Fijador', 'Gel para fijar peinados con alta duración', 12.00, 30, 'https://images.pexels.com/photos/7262687/pexels-photo-7262687.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Spray de Volumen', 'Spray que da volumen al cabello fino', 17.25, 35, 'https://images.pexels.com/photos/3735657/pexels-photo-3735657.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Aceite de Argán', 'Aceite de argán para nutrir y suavizar el cabello', 22.00, 25, 'https://images.pexels.com/photos/3735627/pexels-photo-3735627.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Crema para Peinar', 'Crema que facilita el peinado y controla el frizz', 16.50, 45, 'https://images.pexels.com/photos/7428099/pexels-photo-7428099.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Serum Reparador de Puntas', 'Serum que repara puntas abiertas y evita el quiebre', 19.99, 40, 'https://images.pexels.com/photos/9909784/pexels-photo-9909784.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Tinte para Cabello Rubio', 'Tinte permanente para el cabello, color rubio', 9.99, 50, 'https://images.pexels.com/photos/3993292/pexels-photo-3993292.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Tinte para Cabello Castaño', 'Tinte permanente para el cabello, color castaño', 9.99, 50, 'https://images.pexels.com/photos/3993141/pexels-photo-3993141.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Tinte para Cabello Negro', 'Tinte permanente para el cabello, color negro', 9.99, 50, 'https://images.pexels.com/photos/3993139/pexels-photo-3993139.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Espuma Moldeadora', 'Espuma que ayuda a moldear el cabello con rizos definidos', 14.50, 30, 'https://images.pexels.com/photos/14149696/pexels-photo-14149696.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Cera para Cabello', 'Cera para estilizar el cabello con acabado mate', 13.00, 40, 'https://images.pexels.com/photos/4841234/pexels-photo-4841234.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Spray Protector Térmico', 'Spray que protege el cabello del calor de planchas y secadores', 18.75, 35, 'https://images.pexels.com/photos/5462672/pexels-photo-5462672.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Peine de Dientes Anchos', 'Peine ideal para desenredar el cabello húmedo', 5.00, 100, 'https://images.pexels.com/photos/4154173/pexels-photo-4154173.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Cepillo Redondo', 'Cepillo redondo para dar forma y volumen al cabello', 8.50, 60, 'https://images.pexels.com/photos/3654937/pexels-photo-3654937.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Plancha para Cabello', 'Plancha de cerámica para alisar el cabello', 45.00, 20, 'https://images.pexels.com/photos/3738359/pexels-photo-3738359.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Secador de Cabello', 'Secador de cabello con tecnología iónica', 55.00, 15, 'https://images.pexels.com/photos/973406/pexels-photo-973406.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Rizador de Cabello', 'Rizador de cabello con barril de cerámica', 35.00, 25, 'https://images.pexels.com/photos/3065209/pexels-photo-3065209.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Cortadora de Cabello', 'Cortadora de cabello profesional', 60.00, 10, 'https://images.pexels.com/photos/3993442/pexels-photo-3993442.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Kit de Manicura', 'Kit completo para manicura con herramientas de acero inoxidable', 25.00, 40, 'https://images.pexels.com/photos/20246361/pexels-photo-20246361/free-photo-of-flores-purpura-morado-lila.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Esmalte de Uñas Rojo', 'Esmalte de uñas color rojo', 7.00, 80, 'https://images.pexels.com/photos/791157/pexels-photo-791157.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Esmalte de Uñas Nude', 'Esmalte de uñas color nude', 7.00, 80, 'https://images.pexels.com/photos/10107538/pexels-photo-10107538.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Esmalte de Uñas Negro', 'Esmalte de uñas color azul', 7.00, 80, 'https://images.pexels.com/photos/755993/pexels-photo-755993.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
                                                                                ('Removedor de Esmalte', 'Removedor de esmalte sin acetona', 6.50, 60, 'https://images.pexels.com/photos/2208582/pexels-photo-2208582.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
