/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.dvdlibrary;

import com.sguild.dvdlibrary.controller.LibraryController;
import com.sguild.dvdlibrary.dao.LibraryDao;
import com.sguild.dvdlibrary.dao.LibraryDaoFileImpl;
import com.sguild.dvdlibrary.ui.LibraryView;
import com.sguild.dvdlibrary.ui.UserIO;
import com.sguild.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author apprentice
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UserIO myIo = new UserIOConsoleImpl();
        LibraryView myView = new LibraryView(myIo);
        LibraryDao myDao = new LibraryDaoFileImpl();

        LibraryController controller = new LibraryController(myDao, myView);

        controller.run();

    }

}
