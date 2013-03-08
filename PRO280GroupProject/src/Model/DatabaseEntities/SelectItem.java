package Model.DatabaseEntities;

import javax.persistence.*;

/**
 * User: jflores
 * Date: 3/5/13
 * Time: 6:30 PM
 * I Can destroy things with my mind
 */

@Entity
@Table(name = "selectItem")
public class SelectItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    Integer id;

    @Column(name = "itemName", length = 20, nullable = false)
    String itemName;

//    @Column(name = "groupId")
//    Integer groupId;
//
//    @JoinTable(name = "selectGroup", joinColumns = @JoinColumn(name = "groupId", referencedColumnName = "groupId"))
//    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    SelectGroup group;
    @ManyToOne(optional = false)
    @JoinColumn(name = "groupId")
    private SelectGroup selectGroup;



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

    public SelectGroup getSelectGroup() {
        return selectGroup;
    }

    public void setSelectGroup(SelectGroup selectGroup) {
        this.selectGroup = selectGroup;
    }
//    public Integer getGroupId() {
//        return groupId;
//    }
//
//    public void setGroupId(Integer groupId) {
//        this.groupId = groupId;
//    }
//
//    public SelectGroup getGroup() {
//        return group;
//    }
//
//    public void setGroup(SelectGroup group) {
//        this.group = group;
//    }
}//end of class