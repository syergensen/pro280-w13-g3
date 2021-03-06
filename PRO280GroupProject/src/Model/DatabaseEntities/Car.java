package Model.DatabaseEntities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: cknox
 * Date: 3/11/13
 *
 * Cars entity consists of the car type(quality) and price for quality(high, middle, low)
 */
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId", nullable = false)
    private int carId;

    //Called quality instead of type because type is reserved
    @Column(name = "quality", nullable = false)
    private String quality;

    @Column(name = "high", nullable = false)
    private int high;

    @Column(name = "middle", nullable = false)
    private int middle;

    @Column(name = "low", nullable = false)
    private int low;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getMiddle() {
        return middle;
    }

    public void setMiddle(int middle) {
        this.middle = middle;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }
}
