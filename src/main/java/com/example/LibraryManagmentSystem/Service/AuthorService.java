package com.example.LibraryManagmentSystem.Service;

import com.example.LibraryManagmentSystem.Models.Author;
import com.example.LibraryManagmentSystem.Repositories.AuthorRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired

    AuthorRep authorRep;
    public Author createOrGetAuthor(Author author){
        Author retriveAuthor = authorRep.findbyEmailid(author.getEmail());

        if (retriveAuthor != null){
            return retriveAuthor;
        }
        return authorRep.save(author);
    }

    private Author getAuthorByEmail(String email){
        return authorRep.findbyEmailid(email);
    }
}
