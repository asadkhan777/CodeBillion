
package com.asadkhan.codebillion.code.editor.base.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("id")
    @Expose
    public Integer id;
    
    @SerializedName("description")
    @Expose
    public String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String string = "";

        if (id != null)
            string += "id : " + id;

        if (description != null && !description.isEmpty()) {
            if (!string.equalsIgnoreCase("")) {
                string +=  ", ";
            } else {
                string += "description : " + description;
            }
        }

        if (string.equalsIgnoreCase(""))
            string = "NA";
        return string;
    }
}
