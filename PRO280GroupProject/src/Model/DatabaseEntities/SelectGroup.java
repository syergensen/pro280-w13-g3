package Model.DatabaseEntities;

import javax.persistence.*;
import java.util.List;

/**
 * User: jflores
 * Date: 3/5/13
 * Time: 6:23 PM
 *
 * selectGroup entity consists of different select groups such as CarFuel
 */
@Entity
@Table(name = "selectGroup")
public class SelectGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupId", nullable = false, length = 6)
    Integer groupId;

    @Column(name = "description")
    String description;

    @OneToMany(mappedBy = "selectGroup", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    List<SelectItem> selectItems;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List<SelectItem> selectItems) {
        this.selectItems = selectItems;
    }
}//end of class