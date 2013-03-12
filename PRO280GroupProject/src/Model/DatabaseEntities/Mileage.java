package Model.DatabaseEntities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: cknox
 * Date: 3/11/13
 */
@Entity
@Table(name = "mileage")
public class Mileage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mileageId", nullable = false)
    private int mileageId;

    @Column(name = "quality", nullable = false)
    private String quality;

    @Column(name = "cost", nullable = false)
    private int cost;

    public int getMileageId() {
        return mileageId;
    }

    public void setMileageId(int mileageId) {
        this.mileageId = mileageId;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
