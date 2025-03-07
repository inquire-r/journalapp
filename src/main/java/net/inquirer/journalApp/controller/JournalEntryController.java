package net.inquirer.journalApp.controller;

import net.inquirer.journalApp.entities.Journal;
import net.inquirer.journalApp.repository.JournalEntryRepository;
import net.inquirer.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    @Autowired
    JournalEntryService journalEntryService;
    @GetMapping
    public List<Journal> getJournalEntry() {
        return new ArrayList<>();
    }

    @GetMapping("/id/{id}")
    public Journal getByID(@PathVariable ObjectId objectId){
        return new Journal();
    }
    @PostMapping
    public void saveJournal(@RequestBody Journal journal){
        journalEntryService.saveEntry(journal);
    }
    @PutMapping("/id/{id}")
    public void updateJournal(@PathVariable ObjectId id){

    }
    @DeleteMapping("/id/{id}")
    public void deleteMapping(@PathVariable ObjectId id){

    }

}
