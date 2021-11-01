
CREATE DATABASE Proyecto2;

use Proyecto2;

create table Cliente (
       nombre varchar(30) not null,  
       password  varchar(30)  not null,
       Primary Key (nombre)         
     );


ALTER TABLE Cliente ADD Foreign Key (cliente) REFERENCES Cliente(nombre);
