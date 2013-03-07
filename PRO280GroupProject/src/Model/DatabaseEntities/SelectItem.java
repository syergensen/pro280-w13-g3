package Model.DatabaseEntities;

import javax.persistence.*;

/**
 * User: jflores
 * Date: 3/5/13
 * Time: 6:30 PM
 * I Can destroy things with my mind
 */

@Entity
@Table(name = "SelectItem")
public class SelectItem {
    @Id
    @GeneratedValue
    Integer id;

    @Column(name = "itemName", length = 20, nullable = false)
    String itemName;

    @Column(name = "groupId")
    Integer groupId;

    @JoinTable(name = "SelectGroup", joinColumns = @JoinColumn(name = "groupId", referencedColumnName = "groupId"))
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    SelectGroup group;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public SelectGroup getGroup() {
        return group;
    }

    public void setGroup(SelectGroup group) {
        this.group = group;
    }
}//end of class