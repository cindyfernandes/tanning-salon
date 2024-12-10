package tanningapp.tanning_salon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "skincare_tips")
public class SkincareTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-increment primary key

    // The type of skin
    @Column(name = "skin_tone", nullable = false)
    private String skinTone; 

    // Tips before tanning
    @Column(name = "pre_tanning_tip", nullable = false, columnDefinition = "TEXT")
    private String preTanningTip; 

    // Tips after tanning
    @Column(name = "post_tanning_tip", nullable = false, columnDefinition = "TEXT")
    private String postTanningTip; 

    // Guidelines for tanning progress
    @Column(name = "tanning_progress", nullable = false, columnDefinition = "TEXT")
    private String tanningProgress; 

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkinTone() {
        return skinTone;
    }

    public void setSkinTone(String skinTone) {
        this.skinTone = skinTone;
    }

    public String getPreTanningTip() {
        return preTanningTip;
    }

    public void setPreTanningTip(String preTanningTip) {
        this.preTanningTip = preTanningTip;
    }

    public String getPostTanningTip() {
        return postTanningTip;
    }

    public void setPostTanningTip(String postTanningTip) {
        this.postTanningTip = postTanningTip;
    }

    public String getTanningProgress() {
        return tanningProgress;
    }

    public void setTanningProgress(String tanningProgress) {
        this.tanningProgress = tanningProgress;
    }
}
