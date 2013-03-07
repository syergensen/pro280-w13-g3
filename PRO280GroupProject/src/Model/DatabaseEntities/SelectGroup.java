package Model.DatabaseEntities;

import javax.persistence.*;
import java.util.List;

/**
 * User: jflores
 * Date: 3/5/13
 * Time: 6:23 PM
 * WAZ UP THIS IS MY CREATION DAWG!!! IT IS A BEAN SO COMMENTS ARE USELESS
 */
@Entity(name = "SelectGroup")
@Table(name = "SelectGroup")
public class SelectGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer groupId;

    @Column(name = "description")
    String DESCR;

    @OneToMany(mappedBy = "group", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    List<SelectItem> selectItems;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getDESCR() {
        return DESCR;
    }

    public void setDESCR(String DESCR) {
        this.DESCR = DESCR;
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List<SelectItem> selectItems) {
        this.selectItems = selectItems;
    }
}//end of class