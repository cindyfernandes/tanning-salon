package tanningapp.tanning_salon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tanningapp.tanning_salon.model.SkincareTip;

// Repository for managing SkincareTip entities.
public interface SkincareRepository extends JpaRepository<SkincareTip, Long> {

    // Find a skincare tip by their skin tone.
    SkincareTip findBySkinTone(String skinTone);
}
