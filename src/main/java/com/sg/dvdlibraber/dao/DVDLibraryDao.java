/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraber.dao;

import com.sg.DVDException.DVDDaoException;
import com.sg.dvdlibraby.dto.DVD;

import java.util.List;

/**
 *
 * @author Nur
 */
public interface DVDLibraryDao {
    DVD addDvd(String title, DVD dvd)
    throws DVDDaoException;
    List<DVD> getAllDvds()
    throws DVDDaoException;
    DVD getDVDLibrary(String title)
    throws DVDDaoException;
    DVD removeDVDLibrary(String title)
    throws DVDDaoException;

}
