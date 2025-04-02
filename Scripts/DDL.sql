CREATE DATABASE pruebaTia;
USE pruebaTia;

CREATE TABLE potencia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    potencia VARCHAR(50),
    hostilidad INT,
    ubicacion VARCHAR(50)
);

CREATE TABLE tropas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    potencia VARCHAR(50),
    frente VARCHAR(10),
    numero_tropas INT,
    tipo_tropas VARCHAR(20),
    hora_despliegue TIME
);
