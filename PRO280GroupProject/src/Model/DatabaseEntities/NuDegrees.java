package Model.DatabaseEntities;

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
    String Degree;

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }
}//end of class