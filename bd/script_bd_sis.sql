-- -----------------------------------------------------
-- sis_db
-- -----------------------------------------------------
CREATE DATABASE sis_db;
USE sis_db;

-- -----------------------------------------------------
-- categoria
-- -----------------------------------------------------
CREATE TABLE categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (id_categoria)
);

-- -----------------------------------------------------
-- servicio
-- -----------------------------------------------------
CREATE TABLE servicio (
  id_servicio INT NOT NULL AUTO_INCREMENT,
  nombre_servicio VARCHAR(45) NULL,
  id_categoria INT NOT NULL,
  PRIMARY KEY (id_servicio),
  INDEX fk_servicio_categoria1_idx (id_categoria),
  CONSTRAINT fk_servicio_categoria1
    FOREIGN KEY (id_categoria)
    REFERENCES categoria (id_categoria)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- municipio
-- -----------------------------------------------------
CREATE TABLE municipio (
  id_municipio INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (id_municipio)
);

-- -----------------------------------------------------
-- empresa
-- -----------------------------------------------------
CREATE TABLE empresa (
  id_empresa INT NOT NULL AUTO_INCREMENT,
  nit INT NULL,
  nombre VARCHAR(45) NULL,
  direccion VARCHAR(45) NULL,
  telefono VARCHAR(12) NULL,
  zona INT NULL,
  latitud DOUBLE NULL,
  longitud DOUBLE NULL,
  id_municipio INT NOT NULL,
  email VARCHAR(100) NULL,
  password VARCHAR(100) NULL,
  PRIMARY KEY (id_empresa),
  INDEX fk_empresa_municipio1_idx (id_municipio),
  UNIQUE INDEX email_UNIQUE (email),
  UNIQUE INDEX nit_UNIQUE (nit),
  CONSTRAINT fk_empresa_municipio1
    FOREIGN KEY (id_municipio)
    REFERENCES municipio (id_municipio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- lista_servicio
-- -----------------------------------------------------
CREATE TABLE lista_servicio (
  id_empresa INT NOT NULL,
  id_servicio INT NOT NULL,
  precio DOUBLE NULL,
  INDEX fk_lista_servicio_servicio1_idx (id_servicio),
  PRIMARY KEY (id_empresa, id_servicio),
  INDEX fk_lista_servicio_Empresa1_idx (id_empresa),
  CONSTRAINT fk_lista_servicio_servicio1
    FOREIGN KEY (id_servicio)
    REFERENCES servicio (id_servicio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_lista_servicio_Empresa1
    FOREIGN KEY (id_empresa)
    REFERENCES empresa (id_empresa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- forma_pago
-- -----------------------------------------------------
CREATE TABLE forma_pago (
  id_pago INT NOT NULL AUTO_INCREMENT,
  forma VARCHAR(45) NULL,
  PRIMARY KEY (id_pago)
);

-- -----------------------------------------------------
-- usuario
-- -----------------------------------------------------
CREATE TABLE usuario (
  email VARCHAR(100) NOT NULL,
  contrasenia VARCHAR(100) NULL,
  dpi VARCHAR(25) NULL,
  nombre VARCHAR(45) NULL,
  apellido VARCHAR(45) NULL,
  direccion VARCHAR(45) NULL,
  telefono VARCHAR(8) NULL,
  zona INT NULL,
  latitud DOUBLE NULL,
  longitud DOUBLE NULL,
  id_municipio INT NOT NULL,
  INDEX fk_persona_municipio1_idx (id_municipio),
  PRIMARY KEY (email),
  CONSTRAINT fk_persona_municipio1
    FOREIGN KEY (id_municipio)
    REFERENCES municipio (id_municipio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- detalle_contrato
-- -----------------------------------------------------
CREATE TABLE detalle_contrato (
  id_contrato INT NOT NULL AUTO_INCREMENT,
  fecha DATETIME NULL,
  id_empresa INT NOT NULL,
  id_servicio INT NOT NULL,
  id_pago INT NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_contrato),
  INDEX fk_detalle_contrato_lista_servicio1_idx (id_empresa, id_servicio),
  INDEX fk_detalle_contrato_forma_pago1_idx (id_pago),
  INDEX fk_detalle_contrato_usuario1_idx (email),
  CONSTRAINT fk_detalle_contrato_lista_servicio1
    FOREIGN KEY (id_empresa , id_servicio)
    REFERENCES lista_servicio (id_empresa, id_servicio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_detalle_contrato_forma_pago1
    FOREIGN KEY (id_pago)
    REFERENCES forma_pago (id_pago)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT fk_detalle_contrato_usuario1
    FOREIGN KEY (email)
    REFERENCES usuario (email)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- comentario
-- -----------------------------------------------------
CREATE TABLE comentario (
  id_comentario INT NOT NULL AUTO_INCREMENT,
  comentario VARCHAR(250) NULL,
  id_contrato INT NOT NULL,
  PRIMARY KEY (id_comentario),
  INDEX fk_comentario_detalle_contrato1_idx (id_contrato),
  CONSTRAINT fk_comentario_detalle_contrato1
    FOREIGN KEY (id_contrato)
    REFERENCES detalle_contrato (id_contrato)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- calificacion
-- -----------------------------------------------------
CREATE TABLE calificacion (
  id_calificacion INT NOT NULL AUTO_INCREMENT,
  calificacion INT NULL,
  id_contrato INT NOT NULL,
  PRIMARY KEY (id_calificacion),
  INDEX fk_calificacion_detalle_contrato1_idx (id_contrato),
  CONSTRAINT fk_calificacion_detalle_contrato1
    FOREIGN KEY (id_contrato)
    REFERENCES detalle_contrato (id_contrato)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- trabajador
-- -----------------------------------------------------
CREATE TABLE trabajador (
  id_empleado INT NOT NULL AUTO_INCREMENT,
  id_empresa INT NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_empleado),
  INDEX fk_trabajador_Empresa1_idx (id_empresa),
  INDEX fk_trabajador_persona1_idx (email),
  CONSTRAINT fk_trabajador_Empresa1
    FOREIGN KEY (id_empresa)
    REFERENCES empresa (id_empresa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_trabajador_persona1
    FOREIGN KEY (email)
    REFERENCES usuario (email)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- foto
-- -----------------------------------------------------
CREATE TABLE foto (
  id_foto INT NOT NULL AUTO_INCREMENT,
  ruta VARCHAR(250) NULL,
  id_empleado INT NOT NULL,
  PRIMARY KEY (id_foto),
  INDEX fk_foto_trabajador1_idx (id_empleado),
  CONSTRAINT fk_foto_trabajador1
    FOREIGN KEY (id_empleado)
    REFERENCES trabajador (id_empleado)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- video
-- -----------------------------------------------------
CREATE TABLE video (
  id_video INT NOT NULL AUTO_INCREMENT,
  ruta_video VARCHAR(250) NULL,
  id_empleado INT NOT NULL,
  PRIMARY KEY (id_video),
  INDEX fk_video_trabajador1_idx (id_empleado),
  CONSTRAINT fk_video_trabajador1
    FOREIGN KEY (id_empleado)
    REFERENCES trabajador (id_empleado)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- documento
-- -----------------------------------------------------
CREATE TABLE documento (
  id_documento INT NOT NULL AUTO_INCREMENT,
  documento VARCHAR(250) NULL,
  id_empleado INT NOT NULL,
  PRIMARY KEY (id_documento),
  INDEX fk_documento_trabajador1_idx (id_empleado),
  CONSTRAINT fk_documento_trabajador1
    FOREIGN KEY (id_empleado)
    REFERENCES trabajador (id_empleado)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- suscripcion
-- -----------------------------------------------------
CREATE TABLE suscripcion (
  id_suscripcion INT NOT NULL AUTO_INCREMENT,
  total INT NULL,
  fecha_inicio DATE NULL,
  fecha_final DATE NULL,
  limite_servicios INT NULL,
  id_empresa INT NOT NULL,
  PRIMARY KEY (id_suscripcion),
  INDEX fk_subscripcion_empresa1_idx (id_empresa),
  CONSTRAINT fk_subscripcion_empresa1
    FOREIGN KEY (id_empresa)
    REFERENCES empresa (id_empresa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);