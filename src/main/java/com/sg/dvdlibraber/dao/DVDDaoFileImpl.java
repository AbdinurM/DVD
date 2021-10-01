/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraber.dao;

import com.sg.DVDException.DVDDaoException;
import com.sg.dvdlibraby.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nur
 */
public class DVDDaoFileImpl implements DVDLibraryDao {
    
    private Map<String, DVD> dvds = new HashMap<>();
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";
    @Override
    public DVD addDvd(String title, DVD dvd) throws DVDDaoException {
        loadRoster();
    DVD prevDVD = dvds.put(title, dvd);
        try {
            writeRoster();
        } catch (IOException ex) {
            Logger.getLogger(DVDDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    return prevDVD;   
    }
    
    public List<DVD> getAllDvds() throws DVDDaoException {
        loadRoster();
        return new ArrayList<>(dvds.values());
    }

    public DVD getDVDLibrary(String title) throws DVDDaoException {
        loadRoster();
        DVD retrievedDVD = dvds.get(title);
        return retrievedDVD;
    }


    public DVD removeDVDLibrary(String title) throws DVDDaoException  {
        loadRoster();
        DVD removedDVD = dvds.remove(title);
        try {
            writeRoster();
        } catch (IOException ex) {
            Logger.getLogger(DVDDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return removedDVD;
    }
    private DVD unmarshallStudent(String DVDAsText){

    String[] DVDTokens = DVDAsText.split(DELIMITER);

    String DVDId = DVDTokens[0];

    DVD DVDFile = new DVD(DVDId);

    DVDFile.setDirectorsName(DVDTokens[1]);


    DVDFile.setMpaaRating(DVDTokens[2]);


    DVDFile.setReleaseDate(DVDTokens[3]);
    
    DVDFile.setStudio(DVDTokens[4]);
    
    DVDFile.setUserRating(DVDTokens[5]);
    
    return DVDFile;
}
    private void loadRoster() throws DVDDaoException {
    Scanner scanner;

    try {

        scanner = new Scanner(
                new BufferedReader(
                        new FileReader(ROSTER_FILE)));
    } catch (FileNotFoundException e) {
        throw new DVDDaoException(
                "-_- Could not load roster data into memory.", e);
    }
   
    String currentLine;
 
    DVD currentDVD;
 
    while (scanner.hasNextLine()) {

        currentLine = scanner.nextLine();

        currentDVD = unmarshallStudent(currentLine);

        dvds.put(currentDVD.getTitle(), currentDVD);
    }

    scanner.close();
}
    private String marshallStudent(DVD aDVD){
    String DVDAsText = aDVD.getDirectorsName()+ DELIMITER;

    DVDAsText += aDVD.getMpaaRating()+ DELIMITER;

    DVDAsText += aDVD.getReleaseDate()+ DELIMITER;

    DVDAsText += aDVD.getStudio()+ DELIMITER;
    
   DVDAsText += aDVD.getTitle() + DELIMITER;
   
   DVDAsText += aDVD.getUserRating() + DELIMITER;


    return DVDAsText;
}
    private void writeRoster() throws DVDDaoException, IOException {

    PrintWriter out;

    try {
        out = new PrintWriter(new FileWriter(ROSTER_FILE));
    } catch (IOException e) {
        throw new DVDDaoException(
                "Could not save student data.", e);  
    }

    String DVDAsText;
    List<DVD> DVDList = this.getAllDvds();
    for (DVD currentDVD : DVDList) {

        DVDAsText = marshallStudent(currentDVD);

        out.println(DVDAsText);

        out.flush();
    }

    out.close();
}
   
public DVD addStudent(String DVDId, DVD dvd) 
 throws DVDDaoException, IOException {
    loadRoster();
    DVD newStudent = dvds.put(DVDId, dvd);
    writeRoster();
    return newStudent;
}
public List<DVD> getAllDVD() 
 throws DVDDaoException {
    loadRoster();
    return new ArrayList(dvds.values());
}
public DVD getDVD(String DVDId) 
 throws DVDDaoException {
    loadRoster();
    return dvds.get(DVDId);
}
public DVD removeDVD(String DVDId) 
 throws DVDDaoException, IOException {
    loadRoster();
    DVD removedDVD = dvds.remove(DVDId);
    writeRoster();
    return removedDVD;
}
}
