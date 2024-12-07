package tanningapp.tanning_salon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tanningapp.tanning_salon.model.Client;
import tanningapp.tanning_salon.model.SessionHistory;
import tanningapp.tanning_salon.repository.HistoryRepository;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    // Retrieve session history for a specific client
    public List<SessionHistory> getSessionHistoryForClient(Client client) {
        return historyRepository.findByClient(client);
    }

    // Save a new session booking
    public SessionHistory saveSession(SessionHistory sessionHistory) {
        if (sessionHistory == null || sessionHistory.getClient() == null) {
            throw new IllegalArgumentException("Session or Client is null.");
        }
        return historyRepository.save(sessionHistory);
    }
}
