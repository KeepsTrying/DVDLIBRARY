/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.dvdlibrary.ui;

import com.sguild.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class LibraryView {

    UserIO io;

    public LibraryView(UserIO io) {
        this.io = io;
    }

    public int printMainMenuAndGetSelection() {

        displayBanner("Main Menu");

        io.print("1)  List All DVD's");
        io.print("2)  Display Individual DVD Info and Editing Menu");
        io.print("3)  Search by Title");
        io.print("4)  Add a DVD");
        io.print("5)  Remove a DVD");
        io.print("6)  Save File");
        io.print("7)  Load File");
        io.print("8)  Exit");
        io.print("");

        return io.readInt("Please enter selection, 1-8", 1, 8);
    }

    public Dvd getNewDvdInfo() {
        displayBanner("Adding a New DVD");
        String title = io.readString("Please enter a Title.");
        String director = io.readString("Please enter the Director's name.");
        String mpaaRating = io.readString("Please enter the MPAA Rating.");
        String releaseDate = io.readString("Please enter a Release Date:  mo/yr");
        String studio = io.readString("Please enter the production Studio");
        String addlInfo = io.readString("Please enter any additional info.");

        Dvd currentDvd = new Dvd(title);
        currentDvd.setDirectorsName(director);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setStudio(studio);
        currentDvd.setAddlInfo(addlInfo);

        return currentDvd;
    }

    public void displayBanner(String bannerTitle) {
        io.print("=== " + bannerTitle + " ===");
        io.print("---------------------------");
    }

    public void displayDvdLibrary(List<Dvd> library) {
        displayBanner("DVD Library");
        if(library.size() == 0) {
            io.print("There are no DVD's in this Library.");
        } else {
        int slotNum = 0;
        for (Dvd currentDvd : library) {
            slotNum++;
            io.print(slotNum + ")  Title:           " + currentDvd.getTitle());
            io.print(slotNum + ")  Directors:       " + currentDvd.getDirectorsName());
            io.print(slotNum + ")  MPAA Rating:     " + currentDvd.getMpaaRating());
            io.print(slotNum + ")  Release Date:    " + currentDvd.getReleaseDate());
            io.print(slotNum + ")  Studio:          " + currentDvd.getStudio());
            io.print(slotNum + ")  Additional Info: " + currentDvd.getAddlInfo());
            io.print("");
        }
        io.readString("Please hit enter to continue.");
    }
    }

    public String getSingleDvdChoice() {
        return io.readString("Which DVD would you like to view?");
    }

    public Dvd displayDvd(Dvd singleDvd) {
        if (singleDvd.getTitle() != null) {
            displayBanner("Your DVD's Information:");
            io.print("Title:           " + singleDvd.getTitle());
            io.print("Directors:       " + singleDvd.getDirectorsName());
            io.print("MPAA Rating:     " + singleDvd.getMpaaRating());
            io.print("Release Date:    " + singleDvd.getReleaseDate());
            io.print("Studio:          " + singleDvd.getStudio());
            io.print("Additional Info: " + singleDvd.getAddlInfo());
            io.print("");
        } else {
            io.print("No DVD found with that Title.");
        }
        return singleDvd;
    }

    public boolean requestEdit() {
        int answer = io.readInt("Would you like to Edit this DVD's info?  1) Yes      2)  No ", 1, 2);
        boolean booleanAnswer = false;
        if (answer == 1) {
            booleanAnswer = true;
        } else if (answer == 2) {
            booleanAnswer = false;
        }
        return booleanAnswer;
    }

    public int whichField() {
        displayBanner("Which field would you like to edit?");
        io.print("1)  Title");
        io.print("2)  Director's Name");
        io.print("3)  MPAA Rating");
        io.print("4)  Release Date");
        io.print("5)  Studio");
        io.print("6)  Additional Info");
        io.print("7)  Exit to Main Menu");
        io.print("");

        return io.readInt("Please select 1-7 from the options above.", 1, 7);
    }

    public String editTitle() {
        return io.readString("What would you like to change the Title to?");
    }

    public String editDirector() {
        return io.readString("What would you like to change the Director's name to?");
    }

    public String editRating() {
        return io.readString("What would you like to change the Rating to?");
    }

    public String editReleaseDate() {
        return io.readString("What would you like the Release Date to be?");
    }

    public String editStudio() {
        return io.readString("What would you like to change the Studio to?");
    }

    public String editAddlInfo() {
        return io.readString("What would you like to change the Additional Info to?");
    }

    public String removeDvd() {
        return io.readString("Which DVD would you like to Remove?");
    }

    public void displayErrorMessage(String errorMsg) {
        displayBanner("ERROR");
        io.print(errorMsg);
    }
    
    public void displaySearchResults(List<Dvd> request) {
        io.print("");
        displayBanner("Search Results");
        for (Dvd dvd : request){
            io.print(dvd.getTitle());
        }
            
    }
    
    
    
    public void printEmptyLine() {
        io.print("");
    }
    
    
    
    public boolean requestSave() {
        int answer = io.readInt("Would you like to Save this Library?  1) Yes      2)  No ", 1, 2);
        boolean booleanAnswer = false;
        if (answer == 1) {
            booleanAnswer = true;
        } else if (answer == 2) {
            booleanAnswer = false;
        }
        return booleanAnswer;
    }
    
    
    
    

    /* get new property (string newproperty)
    grab property
    
    
    dvdlowercase.setRealseDate(view.getnewproperty(releaseDate)
    
    
    
    
    title.toLowercase
    input
    title.contains
    
     */
 /*
        switch (whichField){
            case 1:
                Dvd.setTitle(String title){
                String title = 
          
     */
}
