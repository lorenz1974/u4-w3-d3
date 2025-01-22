package u4w3d3.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import u4w3d3.entities.Partecipazione;
import u4w3d3.entities.Persona;

public class PartecipazioneDao implements Dao {

    EntityManager em = EntityManagerUtil.getEntityManager();

    @Override
    public Optional get(long id) {
        try {
            em.getTransaction().begin();
            Partecipazione partecipazione = em.find(Partecipazione.class, id);
            em.getTransaction().commit();
            if (partecipazione != null) {
                return Optional.of(partecipazione);
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
    public List<ArrayList> getAll() {
        try {
            return em.createQuery("SELECT p FROM Partecipazione p", ArrayList.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean save(Object t) {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Object t, String[] params) {
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean delete(Object t) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(t) ? t : em.merge(t));
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

}
