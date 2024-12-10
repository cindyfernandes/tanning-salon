package tanningapp.tanning_salon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tanningapp.tanning_salon.model.Client;
import tanningapp.tanning_salon.model.SessionHistory;

@Repository
public interface HistoryRepository extends JpaRepository<SessionHistory, Long> {

    // Retrieves session history for a specific client.
    List<SessionHistory> findByClient(Client client);
}
