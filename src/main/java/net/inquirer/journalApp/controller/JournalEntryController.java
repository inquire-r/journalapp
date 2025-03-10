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
        return journalEntryService.getAllJournals();
    }
    @GetMapping("/id/{id}")
    public Journal getByID(@PathVariable ObjectId objectId){
        return journalEntryService.getById(objectId);
    }
    @PostMapping
    public void saveJournal(@RequestBody Journal journal){
        journalEntryService.saveEntry(journal);
    }
    @PutMapping("/id/{id}")
    public boolean updateJournal(@PathVariable ObjectId id, @RequestBody Journal journal){
        return journalEntryService.updateJournal(id,journal);
    }
    @DeleteMapping("/id/{id}")
    public boolean deleteMapping(@PathVariable ObjectId id){
        return journalEntryService.deleteJournal(id);
    }

}
