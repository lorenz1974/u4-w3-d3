package u4w3d3.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String email;
    @Column
    private LocalDate data_di_nascita;
    @Column
    private String sesso;

    // @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    // @JoinColumn(name = "persona_id")
    // private List<Partecipazione> partecipazioni = new ArrayList<>();

    public Persona() {
    }

    public Persona(String nome, String cognome, LocalDate data_di_nascita, String email, String sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_di_nascita = data_di_nascita;
        this.sesso = sesso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return data_di_nascita;
    }

    public void setDataDiNascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    @Override
    public String toString() {
        return "Persona[nome=" + nome + ", cognome=" + cognome + ", data_di_nascita=" + data_di_nascita + ", email="
                + email + ", sesso=" + sesso + "]";
    }
}
