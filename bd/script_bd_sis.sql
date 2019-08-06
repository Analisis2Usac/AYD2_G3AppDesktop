
-- -----------------------------------------------------
-- sis_db
-- -----------------------------------------------------
CREATE DATABASE sis_db;
USE sis_db;

-- -----------------------------------------------------
-- categoria
-- -----------------------------------------------------
CREATE TABLE categoria (
  idcategoria INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (idcategoria)
);

-- -----------------------------------------------------
-- persona
-- -----------------------------------------------------
CREATE TABLE persona (
  dpi VARCHAR(25) NOT NULL,
  nombre VARCHAR(45) NULL,
  apellido VARCHAR(45) NULL,
  direccion VARCHAR(45) NULL,
  telefono VARCHAR(8) NULL,
  email VARCHAR(45) NULL,
  PRIMARY KEY (dpi),
  UNIQUE INDEX email_UNIQUE (email)
);

-- -----------------------------------------------------
-- usuario
-- -----------------------------------------------------
CREATE TABLE usuario (
  dpi VARCHAR(25) NOT NULL,
  password VARCHAR(45) NULL,
  PRIMARY KEY (dpi),
  CONSTRAINT fk_Usuario_persona1
    FOREIGN KEY (dpi)
    REFERENCES persona (dpi)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- servicio
-- -----------------------------------------------------
CREATE TABLE servicio (
  idservicio INT NOT NULL AUTO_INCREMENT,
  nombre_servicio VARCHAR(45) NULL,
  idcategoria INT NOT NULL,
  PRIMARY KEY (idservicio),
  INDEX fk_servicio_categoria1_idx (idcategoria),
  CONSTRAINT fk_servicio_categoria1
    FOREIGN KEY (idcategoria)
    REFERENCES categoria (idcategoria)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- empresa
-- -----------------------------------------------------
CREATE TABLE empresa (
  idempresa INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  direccion VARCHAR(45) NULL,
  PRIMARY KEY (idempresa)
);

-- -----------------------------------------------------
-- lista_servicio
-- -----------------------------------------------------
CREATE TABLE lista_servicio (
  idempresa INT NOT NULL,
  idservicio INT NOT NULL,
  precio DOUBLE NULL,
  INDEX fk_lista_servicio_servicio1_idx (idservicio),
  PRIMARY KEY (idempresa, idservicio),
  INDEX fk_lista_servicio_Empresa1_idx (idempresa),
  CONSTRAINT fk_lista_servicio_servicio1
    FOREIGN KEY (idservicio)
    REFERENCES servicio (idservicio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_lista_servicio_Empresa1
    FOREIGN KEY (idempresa)
    REFERENCES empresa (idempresa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- detalle_contrato
-- -----------------------------------------------------
CREATE TABLE detalle_contrato (
  idcontrato INT NOT NULL AUTO_INCREMENT,
  fecha DATETIME NULL,
  dpi VARCHAR(25) NOT NULL,
  idempresa INT NOT NULL,
  idservicio INT NOT NULL,
  INDEX fk_detalle_contrato_Usuario1_idx (dpi),
  PRIMARY KEY (idcontrato),
  INDEX fk_detalle_contrato_lista_servicio1_idx (idempresa, idservicio),
  CONSTRAINT fk_detalle_contrato_Usuario1
    FOREIGN KEY (dpi)
    REFERENCES usuario (dpi)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_detalle_contrato_lista_servicio1
    FOREIGN KEY (idempresa , idservicio)
    REFERENCES lista_servicio (idempresa , idservicio)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- comentario
-- -----------------------------------------------------
CREATE TABLE comentario (
  idcomentario INT NOT NULL AUTO_INCREMENT,
  comentario VARCHAR(250) NULL,
  idcontrato INT NOT NULL,
  PRIMARY KEY (idcomentario),
  INDEX fk_comentario_detalle_contrato1_idx (idcontrato),
  CONSTRAINT fk_comentario_detalle_contrato1
    FOREIGN KEY (idcontrato)
    REFERENCES detalle_contrato (idcontrato)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- calificacion
-- -----------------------------------------------------
CREATE TABLE calificacion (
  idcalificacion INT NOT NULL AUTO_INCREMENT,
  calificacion INT NULL,
  idcontrato INT NOT NULL,
  PRIMARY KEY (idcalificacion),
  INDEX fk_calificacion_detalle_contrato1_idx (idcontrato),
  CONSTRAINT fk_calificacion_detalle_contrato1
    FOREIGN KEY (idcontrato)
    REFERENCES detalle_contrato (idcontrato)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- trabajador
-- -----------------------------------------------------
CREATE TABLE trabajador (
  idtrabajador INT NOT NULL AUTO_INCREMENT,
  dpi VARCHAR(25) NOT NULL,
  idempresa INT NOT NULL,
  PRIMARY KEY (idtrabajador),
  INDEX fk_trabajador_Empresa1_idx (idempresa),
  CONSTRAINT fk_trabajador_persona1
    FOREIGN KEY (dpi)
    REFERENCES persona (dpi)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_trabajador_Empresa1
    FOREIGN KEY (idempresa)
    REFERENCES empresa (idempresa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- foto
-- -----------------------------------------------------
CREATE TABLE foto (
  idfoto INT NOT NULL AUTO_INCREMENT,
  ruta VARCHAR(45) NULL,
  dpi VARCHAR(25) NOT NULL,
  PRIMARY KEY (idfoto),
  INDEX fk_foto_persona1_idx (dpi ASC) VISIBLE,
  CONSTRAINT fk_foto_persona1
    FOREIGN KEY (dpi)
    REFERENCES persona (dpi)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- video
-- -----------------------------------------------------
CREATE TABLE video (
  idvideo INT NOT NULL AUTO_INCREMENT,
  ruta_video VARCHAR(45) NULL,
  dpi VARCHAR(25) NOT NULL,
  PRIMARY KEY (idvideo),
  INDEX fk_video_persona1_idx (dpi ASC) VISIBLE,
  CONSTRAINT fk_video_persona1
    FOREIGN KEY (dpi)
    REFERENCES persona (dpi)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- documento
-- -----------------------------------------------------
CREATE TABLE documento (
  iddocumento INT NOT NULL AUTO_INCREMENT,
  documento VARCHAR(45) NULL,
  dpi VARCHAR(25) NOT NULL,
  PRIMARY KEY (iddocumento),
  INDEX fk_documento_persona1_idx (dpi),
  CONSTRAINT fk_documento_persona1
    FOREIGN KEY (dpi)
    REFERENCES persona (dpi)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);