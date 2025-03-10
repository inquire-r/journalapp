package net.inquirer.journalApp.service;

import net.inquirer.journalApp.entities.Journal;
import net.inquirer.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.util.OptionalInt;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(Journal journal){
        journalEntryRepository.save(journal);
    }

    public Journal getById(ObjectId id){
        return journalEntryRepository.findById(id).get();
    }
    public List<Journal> getAllJournals() {
        return journalEntryRepository.findAll();
    }
    public boolean updateJournal(ObjectId id,Journal newjournal) {
        Optional<Journal> journal = journalEntryRepository.findById(id);
        if (journal.isPresent()){
            Journal j = journal.get();
            if(!newjournal.getTitle().equals(j.getTitle())){
                j.setTitle(newjournal.getTitle());
                j.setDate(new Date());
                return true;
            }
            if(!newjournal.getDescription().equals(j.getDescription())){
                j.setDescription(newjournal.getDescription());
                j.setDate(new Date());
                return true;
            }
            return false;
        }
        return false;
    }
    public boolean deleteJournal(ObjectId id){
        if(journalEntryRepository.findById(id).isPresent()){
            journalEntryRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
