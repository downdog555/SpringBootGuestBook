package com.reecesmith.guestbook.controller;

import com.reecesmith.guestbook.domain.GuestBookEntry;
import com.reecesmith.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RequestMapping ("/api")
@RestController
public class GuestBookController {

    @Autowired
    private GuestBookService guestBookService;


    @GetMapping("/comments")
    public List<GuestBookEntry> testMapping()
    {
        return guestBookService.findAllEntries();
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Void> deleteGuestBookEntryById(@PathVariable("id") Integer id)
    {
        try
        {
            this.guestBookService.deleteGuestBookEntryById(id);
            return ResponseEntity.ok().build();
        }
        catch (ResourceAccessException e)
        {
            return ResponseEntity.notFound().build();
        }


    }

    @PostMapping("/add")
    public void addComment(@RequestBody GuestBookEntry guestBookEntry)
    {
        this.guestBookService.save(guestBookEntry);
    }
    @GetMapping("/comment/{id}")
    public GuestBookEntry findGuestBookEntryById (@PathVariable ("id") Integer id)
    {
        return this.guestBookService.findGuestBookEntryById(id);
    }

    @GetMapping("/user/{user}")
    public List<GuestBookEntry> findGuestBookEntryByUser(@PathVariable ("user") String user)
    {
        return this.guestBookService.findGuestBookEntryByUser(user);
    }

    @PostMapping("/update")
    public void updateComment(@RequestBody GuestBookEntry guestBookEntry)
    {
        this.guestBookService.save(guestBookEntry);

    }
}
