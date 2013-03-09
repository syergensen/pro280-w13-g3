package Model.DatabaseEntities;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * User: jflores
 * Date: 3/7/13
 * Time: 12:43 AM
 * This class well serves as the primary key for the salaries object, I just want to test it out
 */
@Embeddable
public class SalaryPk implements Serializable {
    @Column(name = "degree", nullable = false)
    String degree;

    @Column(name = "region", nullable = false)
    String region;

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
