package Model.DatabaseEntities;

import javax.persistence.*;

@Entity
@Table(name = "app_properties_table")
public class appProperty {
    @Id
    @Column(name = "file_name")
    String fileName;

    @Column(name = "file_value")
    String fileContents;

    public appProperty(){}

    public String getFileContents() {
        return fileContents;
    }

    public void setFileContents(String fileContents) {
        this.fileContents = fileContents;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}//end of class