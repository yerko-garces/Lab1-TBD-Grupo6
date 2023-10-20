INSERT INTO public.Institucion(nombreInstitucion, correoInstitucion, contraseniaInstitucion) VALUES('Conaf', 'Conaf@gmail.com', '123');

INSERT INTO public.Voluntario(emailVoluntario, rutVoluntario, nombreCompletoVoluntario, contraseniaVoluntario) VALUES('ludwing@gmail.com', '20345687', 'Ludwing chamakito', 'nose');

INSERT INTO public.Habilidad(nombreHabilidad) VALUES('El mangera');

INSERT INTO public.Emergencia(nombreEmergencia, idInstitucion) VALUES('Fuego en domicilio', 1);

INSERT INTO public.EmeHabilidad(idEmergencia, idHabilidad) VALUES(1, 1);

INSERT INTO public.EstadoTarea(estadoTarea) VALUES(False);

INSERT INTO public.Tarea(nombreTarea, idEstadoTarea, idEmergencia) VALUES('apagar', 1, 1);

INSERT INTO public.VoluntarioHabilidad(idVoluntario, idHabilidad) VALUES(1, 1);

INSERT INTO public.Ranking(nombreRanking, idVoluntario, idTarea) VALUES('Fuegos', 1, 1);

INSERT INTO public.TareaHabilidad(idTarea, idHabilidad) VALUES(1, 1);