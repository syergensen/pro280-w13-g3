package Model.DatabaseEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: jflores
 * Date: 3/6/13
 * Time: 6:00 PM
 * All your grades are belong to us.
 */
@Entity
@Table(name = "NuDegrees")
public class NuDegrees {
    @Id
    @Column(name = "degree")
    private String degree;

    @Column(name = "quarters")
    private int quarters;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }
}//end of class