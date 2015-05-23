package ru.aragats.sdm.business.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Aragats.Amirkhanyan on 13.02.2015.
 */
//Data transfer object.
//Exclude null fields
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SomeDTO {

    String id;

    public SomeDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
