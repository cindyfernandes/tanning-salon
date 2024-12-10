package tanningapp.tanning_salon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tanningapp.tanning_salon.model.Client;

// Repository interface for managing Client entities.
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Find a client by their email.
    Client findByEmail(String email);

    // Find clients based on their approval status.
    List<Client> findByApproved(boolean approved);

    // Find a client by their email and password.
    Client findByEmailAndPassword(String email, String password);

    // Search for clients by firstname, lastname, or email (case-insensitive).
    List<Client> findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String firstname, String lastname, String email);
}
