package com.reecesmith.guestbook.service;

import com.reecesmith.guestbook.domain.GuestBookEntry;
import com.reecesmith.guestbook.domain.GuestBookEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GuestBookService
{

   private String[] bannedWords = {"boi","lul"};

    @Autowired
    private GuestBookEntryRepository guestBookEntryRepository;

    public List<GuestBookEntry> findAllEntries()
    {
        return this.guestBookEntryRepository.findAll();
    }

    public GuestBookEntry findGuestBookEntryById (Integer id)
    {
        return this.guestBookEntryRepository.findGuestBookEntryById(id);
    }

    public void deleteGuestBookEntryById(Integer id)
    {
        this.guestBookEntryRepository.deleteById(id);
    }

    public List<GuestBookEntry> findGuestBookEntryByUser(String user)
    {
        return this.guestBookEntryRepository.findGuestBookEntryByUser(user);
    }

    public void save (GuestBookEntry newEntry)

    {
       String comment = newEntry.getComment();
       char[] com = comment.toCharArray();
        for (int i =0; i< com.length;i++)
        {
            switch (com[i])
            {
                case '{':
                    com[i] = ' ';
                    break;

                case '}':
                    com[i] = ' ';
                    break;
                case ';':
                    com[i] = ' ';
                    break;
                case '<':
                    com[i] = ' ';
                    break;
                case '>':
                    com[i] = ' ';
                    break;
            }
        }
        //comment = com.toString();


         comment = String.copyValueOf(com);

        //we then check for banned words/replace them

        for (String word: bannedWords)
        {
           comment = comment.replaceAll(word, "****");

        }






        newEntry.setComment(comment);

        this.guestBookEntryRepository.save(newEntry);
    }

    public GuestBookEntry findOne (Integer id) {
        return this.guestBookEntryRepository.findGuestBookEntryById(id);
    }

    public List<GuestBookEntry> search (String value)
    {
        //list to return
        ArrayList<GuestBookEntry> foundValues = new ArrayList<GuestBookEntry>();
        //all entries
        List<GuestBookEntry> entries = this.guestBookEntryRepository.findAll();

        for (GuestBookEntry entry: entries)
        {
            String comment = entry.getComment();
            if(comment.contains(value))
            {
                foundValues.add(entry);
            }
        }



        return foundValues;
    }

}
