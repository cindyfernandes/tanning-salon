package tanningapp.tanning_salon.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SessionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false) // Relaciona ao cliente pelo ID
    private Client client;

    @Column(nullable = false)
    private LocalDate sessionDate;

    @Column(nullable = false)
    private LocalTime sessionTime;

    @Column(nullable = false)
    private String tanningBed;

    @Column(nullable = false)
    private boolean confirmed;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public LocalTime getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(LocalTime sessionTime) {
        this.sessionTime = sessionTime;
    }

    public String getTanningBed() {
        return tanningBed;
    }

    public void setTanningBed(String tanningBed) {
        this.tanningBed = tanningBed;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
