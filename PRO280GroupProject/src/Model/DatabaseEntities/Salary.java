package Model.DatabaseEntities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: jflores
 * Date: 3/7/13
 * Time: 12:43 AM
 * Collect your wages, also I call b.s on BSTM's wages
 */
@Entity(name = "Salaries")
@Table(name = "Salaries")
public class Salary {

    @EmbeddedId
    public SalaryPk salaryPk;

    @Column(name = "Salary", nullable = false)
    int salary;


}//end of class