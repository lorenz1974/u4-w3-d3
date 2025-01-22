package u4w3d3;

import java.time.LocalDate;

import u4w3d3.dao.PersonaDao;
import u4w3d3.entities.Persona;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Lorenzo", "Lione", LocalDate.parse("1974-09-07"), "l.lione@email.com", "M");
        PersonaDao personaDao = new PersonaDao();
        personaDao.save(persona);
        System.out.println(persona);

    }
}