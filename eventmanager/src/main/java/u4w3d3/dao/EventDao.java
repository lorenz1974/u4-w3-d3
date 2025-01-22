package u4w3d3.dao;

import u4w3d3.entities.Event;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventDao implements Dao<Event> {

    EntityManager em = EntityManagerUtil.getEntityManager();

    @Override
    public Optional<Event> get(long id) {
        try {
            em.getTransaction().begin();
            Event event = em.find(Event.class, id);
            em.getTransaction().commit();
            if (event != null) {
                return Optional.of(event);
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
    public List<Event> getAll() {
        try {
            em.getTransaction().begin();
            List<Event> events = em.createQuery("SELECT e FROM Event e", Event.class).getResultList();
            em.getTransaction().commit();
            return events;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean save(Event event) {
        try {
            em.getTransaction().begin();
            em.persist(event);
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
    public boolean update(Event event, String[] params) {
        try {
            em.getTransaction().begin();
            // Assuming params contain the fields to update in the correct order
            event.setTitolo(params[0]);
            event.setData(LocalDate.parse(params[1]));
            event.setDescrizione(params[2]);
            event.setTipoEvento(params[3]);
            event.setNumeroMassimoPartecipanti(Integer.parseInt(params[4]));
            event.setLocationId(Integer.parseInt(params[5]));
            em.merge(event);
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
    public boolean delete(Event event) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(event) ? event : em.merge(event));
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
