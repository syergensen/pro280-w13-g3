package Model.DatabaseEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: jflores
 * Date: 3/6/13
 * Time: 5:56 PM
 * Classics
 */
@Entity(name = "Regions")
@Table(name = "Regions")
public class Region {
    @Id
    @Column(name = "regionName")
    private String regionName;

    @Column(name = "rent")
    private int rent;

    @Column(name = "mortgage")
    private int mortgage;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getMortgage() {
        return mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }
}//end of class