package tanningapp.tanning_salon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tanningapp.tanning_salon.model.SessionHistory;

public class HistoryRepository {
    @Repository
public interface SessionHistoryRepository extends JpaRepository<SessionHistory, Long> {

    @Query("SELECT s FROM SessionHistory s WHERE s.client.email = :email")
    List<SessionHistory> findByClientEmail(@Param("email") String email);
}
}
