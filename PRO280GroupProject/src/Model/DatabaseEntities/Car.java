package Model.DatabaseEntities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: cknox
 * Date: 3/11/13
 */
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId", nullable = false)
    private int carId;

    @Column(name = "type", nullable = false)
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
