package com.manning.readinglist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Reader;
import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @GetMapping
    public String readersBooks(Reader reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);

        if(readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
        }

        return "readingList";
    }

    @PostMapping
    public String addToReadingList(Reader reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/";
    }
}
