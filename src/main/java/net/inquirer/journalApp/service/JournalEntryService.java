package net.inquirer.journalApp.service;

import net.inquirer.journalApp.entities.Journal;
import net.inquirer.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(Journal journal){
        journalEntryRepository.save(journal);
    }

}
