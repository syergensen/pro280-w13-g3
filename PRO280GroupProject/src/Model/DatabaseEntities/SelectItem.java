package Model.DatabaseEntities;

import javax.persistence.*;

/**
 * User: jflores
 * Date: 3/5/13
 * Time: 6:30 PM
 *
 * SelectItem consists of specific items in the select groups
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