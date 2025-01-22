package u4w3d3.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String evento;

    @Column
    private boolean stato;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "persona_id")
    List<Persona> persone = new ArrayList<Persona>();

    Location location = new Location();

    public Partecipazione() {
    }

    public Partecipazione(String evento, boolean stato) {
        this.evento = evento;
        this.stato = stato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public boolean isStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

}
