package nsu.fit.databases.zookeeper.animal;

import jakarta.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {
    @Id @GeneratedValue
    @Column(name = "animal_id")
    private long animalId = 0L;

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


    public long getAnimalId() {
        return animalId;
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

    public boolean isNeedWarmCage() {
        return needWarmCage;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", name='" + name + '\'' +
                ", speciesId=" + speciesId +
                ", cageId=" + cageId +
                ", vetCardId=" + vetCardId +
                ", rationId=" + rationId +
                ", needWarmCage=" + needWarmCage +
                '}';
    }
}
