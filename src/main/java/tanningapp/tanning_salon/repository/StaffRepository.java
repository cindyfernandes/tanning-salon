package tanningapp.tanning_salon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tanningapp.tanning_salon.model.Staff;

// Repository for managing Staff entities.
public interface StaffRepository extends JpaRepository<Staff, Long> {

    // Finds a staff member by their username.
    Staff findByUsername(String username);
}
