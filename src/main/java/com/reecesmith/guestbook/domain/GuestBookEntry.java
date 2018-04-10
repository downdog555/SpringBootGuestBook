package com.reecesmith.guestbook.domain;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;


@Entity
@Table (name = "entries")
public class GuestBookEntry
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "entry_id")
    private Integer id;

    @NotEmpty
    private String user;

    @NotEmpty
    private String comment;

    public GuestBookEntry()
    {
    }

    @Override
    public String toString() {
        return "GuestBookEntry{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public GuestBookEntry(@NotEmpty String user, @NotEmpty String comment) {

        this.user = user;
        this.comment = comment;
    }


}
