package tanningapp.tanning_salon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tanningapp.tanning_salon.model.Client;

// Repository for the Client entity
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
    List<Client> findByApproved(boolean approved);

    Client findByEmailAndPassword(String email, String password);
}
