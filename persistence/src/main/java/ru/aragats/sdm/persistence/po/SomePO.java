
package ru.aragats.sdm.persistence.po;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Example of PO for MongoDB with spring and morphia annotations.
 */
@Entity(value = "somes", noClassnameStored = true) // Morphia
@Document(collection = "somes") // Spring Mongo
public class SomePO {

    @Id // Morphia ID
    @org.springframework.data.annotation.Id // Spring Mongo
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    String id;

    //CreatedTime
    @org.springframework.data.mongodb.core.index.Indexed // Spring Mongo
    @Indexed // Morphia
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Date createdDate;

    public SomePO() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
