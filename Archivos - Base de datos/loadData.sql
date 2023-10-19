INSERT INTO public.Institucion(idInstitucion, nombreInstitucion, correoInstitucion, contraseniaInstitucion ) VALUES(1, 'Conaf', 'Conaf@gmail.com', '123'  );

INSERT INTO public.Voluntario(idVoluntario, emailVoluntario, rutVoluntario, nombreCompletoVoluntario, contraseniaVoluntario) VALUES(1, 'ludwing@gmail.com', '20345687', 'Ludwing chamakito', 'nose');

INSERT INTO public.Habilidad(idHabilidad, nombre_habilidad) VALUES(1, 'El mangera');

INSERT INTO public.Emergencia(idEmergencia, nombreEmergencia, idInstitucion) VALUES(1, 'Fuego en domicilio', 1);

INSERT INTO public.EmeHabilidad(idEmehabilidad, idEmergencia, idHabilidad) VALUES(1, 1, 1);

INSERT INTO public.EstadoTarea(idEstadoTarea, estadoTarea) VALUES(1, False);

INSERT INTO public.Tarea(idTarea, nombreTarea, idEstadoTarea) VALUES(1, 'apagar', 1);

INSERT INTO public.VoluntarioHabilidad(idVoluntarioHabilidad, idVoluntario, idHabilidad) VALUES(1, 1, 1);

INSERT INTO public.Ranking(idRanking, nombreRanking, idVoluntario, idTarea) VALUES(1, 'Fuegos', 1, 1);

INSERT INTO public.TareaHabilidad(idTareaHabilidad, idTarea, idHabilidad) VALUES(1, 1, 1);