/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdroster.ui;

import com.sg.dvdlibraby.dto.DVD;
import java.util.List;

/**
 *
 * @author Nur
 */
public class DVDLibraryView {
        UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVD Collection");
        io.print("2. Edit Existing DVD From Collection ");
        io.print("3. Add DVD From Collections");
        io.print("4. Remove DVD From Collection");
        io.print("5. View Information of DVD");
        io.print("6. EXIT");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter Title");
        String releaseDate = io.readString("Please enter Release Date");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorsName = io.readString("Please enter Directors Name");
        String studio = io.readString("Please enter Studio");
        String userRating = io.readString("Please enter User Rating");
        DVD currentDVDLibrary = new DVD(title);
        currentDVDLibrary.setReleaseDate(releaseDate);
        currentDVDLibrary.setMpaaRating(mpaaRating);
        currentDVDLibrary.setDirectorsName(directorsName);
        currentDVDLibrary.setStudio(studio);
        currentDVDLibrary.setUserRating(userRating);

        return currentDVDLibrary;

    }

    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateDvdSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public void displayDvdList(List<DVD> dvdList) {
        for (DVD currentDVDLibrary : dvdList) {
            io.print(currentDVDLibrary.getTitle() + ": "
                    + currentDVDLibrary.getReleaseDate() + " "
                    + currentDVDLibrary.getMpaaRating()
                    + currentDVDLibrary.getDirectorsName()
                    + currentDVDLibrary.getStudio()
                    + currentDVDLibrary.getUserRating());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllDvdBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display DVD ===");
    }

    public String getTitleChoice() {
        return io.readString("Please enter the Title.");
    }

    public void displayDvd(DVD Dvd) {
        if (Dvd != null) {
            io.print(Dvd.getTitle());
            io.print(Dvd.getReleaseDate());
            io.print(Dvd.getMpaaRating());
            io.print(Dvd.getDirectorsName());
            io.print(Dvd.getStudio());
            io.print(Dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveDvdSuccessBanner() {
        io.readString("Student successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    public void displayEditBanner() {
        io.print("=== Edit Dvd ===");
    }
    public void displayEditSuccessBanner() {
        io.print("Dvd Successfully edited");
        
    }
    public void errorMessage (String error) {
        io.print("ERROR");
        io.print(error);
    }
}
