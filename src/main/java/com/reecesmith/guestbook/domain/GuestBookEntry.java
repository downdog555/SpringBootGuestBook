package com.reecesmith.guestbook.domain;



import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime.*;
import java.time.LocalDateTime;
import java.util.Date;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;


@Entity
@EntityListeners(AuditingEntityListener.class)
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


    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;

    public GuestBookEntry()
    {
    }

    public GuestBookEntry(@NotEmpty String user, @NotEmpty String comment) {
        this.user = user;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "GuestBookEntry{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", comment='" + comment + '\'' +
                ", created=" + created +
                ", modified=" + modified +
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
