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
    String Degree;
    @Column(name = "Region", nullable = false)
    String Region;
}
