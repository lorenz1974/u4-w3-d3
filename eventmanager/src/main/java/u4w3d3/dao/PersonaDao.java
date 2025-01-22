package u4w3d3.dao;

import u4w3d3.entities.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;

public class PersonaDao implements Dao {

    EntityManager em = EntityManagerUtil.getEntityManager();

    @Override
    public Optional<Persona> get(long id) {
        try {
            em.getTransaction().begin();
            Persona persona = em.find(Persona.class, id);
            em.getTransaction().commit();
            if (persona != null) {
                return Optional.of(persona);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Persona> getAll() {
        try {
            em.getTransaction().begin();
            List<Persona> persone = em.createQuery("SELECT * FROM persona", Persona.class).getResultList();
            em.getTransaction().commit();
            return persone;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Persona>();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean save(Object t) {
        try {
            Persona persona = (Persona) t;
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Object t, String[] params) {
        try {
            Persona persona = (Persona) t;
            em.getTransaction().begin();
            persona.setNome(params[0]);
            persona.setCognome(params[1]);
            persona.setEmail(params[2]);
            persona.setDataDiNascita(LocalDate.parse(params[3]));
            persona.setSesso(params[4]);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean delete(Object t) {
        try {
            Persona persona = (Persona) t;
            em.getTransaction().begin();
            em.remove(persona);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

}
