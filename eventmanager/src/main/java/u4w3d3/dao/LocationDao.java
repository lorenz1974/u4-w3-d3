package u4w3d3.dao;

import u4w3d3.entities.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;

public class LocationDao implements Dao<Location> {

    EntityManager em = EntityManagerUtil.getEntityManager();

    @Override
    public Optional<Location> get(long id) {
        try {
            em.getTransaction().begin();
            Location location = em.find(Location.class, id);
            em.getTransaction().commit();
            if (location != null) {
                return Optional.of(location);
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
    public List<Location> getAll() {
        try {
            em.getTransaction().begin();
            List<Location> locations = em.createQuery("SELECT l FROM Location l", Location.class).getResultList();
            em.getTransaction().commit();
            return locations;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean save(Location location) {
        try {
            em.getTransaction().begin();
            em.persist(location);
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
    public boolean update(Location location, String[] params) {
        try {
            em.getTransaction().begin();
            location.setNome(params[0]);
            location.setCitta(params[1]);
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
    public boolean delete(Location location) {
        try {
            em.getTransaction().begin();
            em.remove(location);
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
