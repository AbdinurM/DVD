/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.DVDlibrary;

import com.sg.DVDController.DvdController;
import com.sg.DVDException.DVDDaoException;
import com.sg.dvdlibraber.dao.DVDDaoFileImpl;
import com.sg.dvdlibraber.dao.DVDLibraryDao;
import com.sg.dvdroster.ui.DVDLibraryView;
import com.sg.dvdroster.ui.UserIO;
import com.sg.dvdroster.ui.UserIOConsoleImpl;

/**
 *
 * @author Nur
 */
public class App {
    
 public static void main(String[] args) throws DVDDaoException {
     
     UserIO userIo = new UserIOConsoleImpl();
     
     DVDLibraryView view = new DVDLibraryView(userIo);
     
     DVDLibraryDao dao = new DVDDaoFileImpl();
	        
     DvdController controller = new DvdController(view, dao);
     
     controller.run();
 }
}
