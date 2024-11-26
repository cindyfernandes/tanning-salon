// package tanningapp.tanning_salon.model;

// import java.time.LocalDate;
// import java.time.LocalTime;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity // Marks this class as a JPA entity and maps it to a database table
// public class SessionHistory {

//     @Id // Specifies the primary key of the entity
//     @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key value
//     private Long id;

//     @Column(nullable = false) // Maps this field to a non-nullable column for the client ID
//     private Long clientId;

//     @Column(nullable = false) // Maps this field to a non-nullable column for the session date
//     private LocalDate sessionDate;

//     @Column(nullable = false) // Maps this field to a non-nullable column for the session time
//     private LocalTime sessionTime;

//     @Column(nullable = false) // Maps this field to a non-nullable column for the tanning bed
//     private String tanningBed;

//     @Column(nullable = false) // Maps this field to a non-nullable column indicating if the session is confirmed
//     private boolean confirmed;

//     // Getters and Setters for accessing and modifying the fields

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getClientId() {
//         return clientId;
//     }

//     public void setClientId(Long clientId) {
//         this.clientId = clientId;
//     }

//     public LocalDate getSessionDate() {
//         return sessionDate;
//     }

//     public void setSessionDate(LocalDate sessionDate) {
//         this.sessionDate = sessionDate;
//     }

//     public LocalTime getSessionTime() {
//         return sessionTime;
//     }

//     public void setSessionTime(LocalTime sessionTime) {
//         this.sessionTime = sessionTime;
//     }

//     public String getTanningBed() {
//         return tanningBed;
//     }

//     public void setTanningBed(String tanningBed) {
//         this.tanningBed = tanningBed;
//     }

//     public boolean isConfirmed() {
//         return confirmed;
//     }

//     public void setConfirmed(boolean confirmed) {
//         this.confirmed = confirmed;
//     }
// }
