/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DVDController;

import com.sg.DVDException.DVDDaoException;
import com.sg.dvdlibraber.dao.DVDDaoFileImpl;
import com.sg.dvdlibraber.dao.DVDLibraryDao;
import com.sg.dvdlibraby.dto.DVD;

import com.sg.dvdroster.ui.DVDLibraryView;
import java.util.List;

/**
 *
 * @author Nur
 */
public class DvdController {
        DVDLibraryView view;

    DVDLibraryDao dao;

    public DvdController(DVDLibraryView view, DVDLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() throws DVDDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    listDvd();
                    break;
                case 2:
                    editDvd();
                    break;
                case 3:
                    createDvd();
                    break;
                case 4:
                    removeDvd();
                    break;
                case 5:
                    viewDvd();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DVDDaoException  {
        view.displayCreateDvdBanner();
        DVD newDvd = view.getNewDVDInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateDvdSuccessBanner();
    }

    private void listDvd() throws DVDDaoException  {
        view.displayDisplayAllDvdBanner();
        List<DVD> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DVDDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getTitleChoice();
        DVD dvd = dao.getDVDLibrary(title);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DVDDaoException  {
        view.displayRemoveDvdBanner();
        String title = view.getTitleChoice();
        dao.removeDVDLibrary(title);
        view.displayRemoveDvdSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
    private void editDvd() throws DVDDaoException  {
        view.displayEditBanner();
        String title = view.getTitleChoice();
        dao.removeDVDLibrary(title);
        DVD newDvd = view.getNewDVDInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayEditSuccessBanner();      
}
}
