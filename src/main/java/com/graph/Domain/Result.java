package com.graph.Domain;

import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class Result implements Serializable {
    private String artname;
    private String artinfo;
    private String artclass;

    public String getArtname() {
        return artname;
    }

    public void setArtname(String artname) {
        this.artname = artname;
    }

    public String getArtinfo() {
        return artinfo;
    }

    public void setArtinfo(String artinfo) {
        this.artinfo = artinfo;
    }

    public String getArtclass() {
        return artclass;
    }

    public void setArtclass(String artclass) {
        this.artclass = artclass;
    }
}
