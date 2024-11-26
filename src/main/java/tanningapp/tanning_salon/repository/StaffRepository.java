package tanningapp.tanning_salon.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import tanningapp.tanning_salon.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByUsername(String username);
}
