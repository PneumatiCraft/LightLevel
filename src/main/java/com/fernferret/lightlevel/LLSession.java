package com.fernferret.lightlevel;

import com.avaje.ebean.validation.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "llsession")
public class LLSession {

    @Id
    public int id;

    @NotEmpty
    public String player;

    private boolean wandEnabled;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setPlayer(String name) {
        this.player = name;
    }

    public String getPlayer() {
        return this.player;
    }

    public void setWandEnabled(boolean enabled) {
        this.wandEnabled = enabled;
    }

    public boolean isWandEnabled() {
        return this.wandEnabled;
    }
}
