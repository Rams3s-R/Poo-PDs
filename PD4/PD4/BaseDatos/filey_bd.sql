-- PD4: Base de datos de stands de la Filey (MySQL)
DROP DATABASE IF EXISTS filey;
CREATE DATABASE filey CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE filey;

-- Usuario genérico para la conexión JDBC
CREATE USER IF NOT EXISTS 'filey_user'@'localhost' IDENTIFIED BY 'filey123';
GRANT ALL PRIVILEGES ON filey.* TO 'filey_user'@'localhost';
FLUSH PRIVILEGES;

CREATE TABLE editorial (
    id_editorial INT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(100) NOT NULL,
    correo       VARCHAR(100) NOT NULL UNIQUE,
    telefono     VARCHAR(15),
    giro         VARCHAR(80)
);

CREATE TABLE stand (
    codigo VARCHAR(10) PRIMARY KEY,
    tipo   ENUM('GASTRONOMICO','ARTESANAL','COMERCIAL') NOT NULL,
    zona   ENUM('GASTRONOMICA','ARTESANAL','COMERCIAL') NOT NULL,
    largo  DECIMAL(6,2) NOT NULL CHECK (largo > 0),
    ancho  DECIMAL(6,2) NOT NULL CHECK (ancho > 0),
    estado ENUM('DISPONIBLE','RESERVADO','OCUPADO','MANTENIMIENTO')
           NOT NULL DEFAULT 'DISPONIBLE'
);

CREATE TABLE reserva (
    id_reserva   INT AUTO_INCREMENT PRIMARY KEY,
    codigo_stand VARCHAR(10) NOT NULL,
    id_editorial INT NOT NULL,
    fecha        DATE NOT NULL,
    estado       ENUM('PENDIENTE','CONFIRMADA','CANCELADA') NOT NULL DEFAULT 'PENDIENTE',
    CONSTRAINT fk_reserva_stand     FOREIGN KEY (codigo_stand) REFERENCES stand(codigo),
    CONSTRAINT fk_reserva_editorial FOREIGN KEY (id_editorial) REFERENCES editorial(id_editorial)
);

-- Datos de ejemplo
INSERT INTO editorial (nombre, correo, telefono, giro) VALUES
('Ediciones Peninsulares', 'contacto@peninsulares.com', '9991234567', 'Literatura regional'),
('Editorial Maya Libros',  'ventas@mayalibros.com',     '9997654321', 'Cultura y tradiciones'),
('Letras del Sureste',     'info@letrassureste.com',    '9995551234', 'Libros infantiles');

INSERT INTO stand (codigo, tipo, zona, largo, ancho, estado) VALUES
('G1', 'GASTRONOMICO', 'GASTRONOMICA', 3, 3, 'OCUPADO'),
('G2', 'GASTRONOMICO', 'GASTRONOMICA', 4, 3, 'DISPONIBLE'),
('A1', 'ARTESANAL',    'ARTESANAL',    3, 2, 'RESERVADO'),
('C1', 'COMERCIAL',    'COMERCIAL',    4, 4, 'DISPONIBLE'),
('C2', 'COMERCIAL',    'COMERCIAL',    2, 2, 'MANTENIMIENTO');

INSERT INTO reserva (codigo_stand, id_editorial, fecha, estado) VALUES
('G1', 1, '2026-11-10', 'CONFIRMADA'),
('A1', 2, '2026-11-12', 'PENDIENTE'),
('C1', 3, '2026-11-13', 'CANCELADA');

-- Comprobación
SELECT * FROM editorial;
SELECT * FROM stand;
SELECT * FROM reserva;
