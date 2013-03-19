package Model.DatabaseEntities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: jflores
 * Date: 3/7/13
 * Time: 12:43 AM
 *
 * Salary entity consists of a compound key using degree and region, the salary, and tax bracket it falls in
 */
@Entity(name = "Salaries")
@Table(name = "Salaries")
public class Salary {

    @EmbeddedId
    public SalaryPk salaryPk;

    @Column(name = "salary", nullable = false)
    int salary;

    @Column(name = "taxBracket")
    private double taxBracket;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getTaxBracket() {
        return taxBracket;
    }

    public void setTaxBracket(double taxBracket) {
        this.taxBracket = taxBracket;
    }
}//end of class