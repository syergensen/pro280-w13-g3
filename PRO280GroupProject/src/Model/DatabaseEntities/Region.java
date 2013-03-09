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
    String regionName;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}//end of class