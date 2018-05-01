package com.asadkhan.codebillion.code.editor.base.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenDO {

    public TokenDO() {
    }

    public TokenDO(String id) {
        this.id = id;
    }

    @SerializedName("token")
    @Expose
    public String id;

    public String getToken() {
        return id;
    }

    public TokenDO setToken(String id) {
        this.id = id;
        return this;
    }
}
