insert into paciente(paciente_id, tipo_documento, num_documento, nombres, apellidos, edad,estado) values(RANDOM_UUID(), 4,'4444444','MARIA JULIA', 'QUISPE LOPEZ', 33,'ACTIVO');


insert into especialidades (id, costo, nombre) values('2ebdbb82-1195-4806-ab52-fb65bc9df743', 33, 'Endocrino');
insert into especialidades (id, costo, nombre) values(RANDOM_UUID(), 50, 'Odontologia');
insert into especialidades (id, costo, nombre) values(RANDOM_UUID(), 80, 'Cardiologia');

 
select * from citas;
select * from doctores;
select * from especialidades;
select * from paciente;