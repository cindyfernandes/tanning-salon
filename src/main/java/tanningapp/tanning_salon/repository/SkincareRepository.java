package tanningapp.tanning_salon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tanningapp.tanning_salon.model.SkincareTip;

public interface SkincareRepository extends JpaRepository<SkincareTip, Long> {
    SkincareTip findBySkinTone(String skinTone);
}
