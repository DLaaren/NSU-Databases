package nsu.fit.databases.zookeeper.animal;

import jakarta.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id = 0L;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "species_id", nullable = false)
    private long speciesId;

    @Column(name = "cage_id", nullable = false)
    private long cageId;

    @Column(name = "vet_card_id", unique = true, nullable = false)
    private long vetCardId;

    @Column(name = "ration_id", nullable = false)
    private long rationId;

    @Column(name = "need_warm_cage")
    private boolean needWarmCage;

    public Animal(String name, long speciesId, long cageId, long vetCardId, long rationId, boolean needWarmCage) {
        this.name = name;
        this.speciesId = speciesId;
        this.cageId = cageId;
        this.vetCardId = vetCardId;
        this.rationId = rationId;
        this.needWarmCage = needWarmCage;
    }

    public Animal(String name, long speciesId, long cageId, long vetCardId, long rationId) {
        this.name = name;
        this.speciesId = speciesId;
        this.cageId = cageId;
        this.vetCardId = vetCardId;
        this.rationId = rationId;
    }

    public Animal() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getSpeciesId() {
        return speciesId;
    }

    public long getCageId() {
        return cageId;
    }

    public long getVetCardId() {
        return vetCardId;
    }

    public long getRationId() {
        return rationId;
    }

    public boolean getIsNeedWarmCage() {
        return needWarmCage;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeciesId(long speciesId) {
        this.speciesId = speciesId;
    }

    public void setCageId(long cageId) {
        this.cageId = cageId;
    }

    public void setVetCardId(long vetCardId) {
        this.vetCardId = vetCardId;
    }

    public void setRationId(long rationId) {
        this.rationId = rationId;
    }

    public void setNeedWarmCage(boolean needWarmCage) {
        this.needWarmCage = needWarmCage;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + id +
                ", name='" + name + '\'' +
                ", speciesId=" + speciesId +
                ", cageId=" + cageId +
                ", vetCardId=" + vetCardId +
                ", rationId=" + rationId +
                ", needWarmCage=" + needWarmCage +
                '}';
    }
}
