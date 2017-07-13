/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.dvdlibrary.controller;

import com.sguild.dvdlibrary.dao.LibraryDao;
import com.sguild.dvdlibrary.dao.LibraryDaoException;
import com.sguild.dvdlibrary.dto.Dvd;
import com.sguild.dvdlibrary.ui.LibraryView;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class LibraryController {
    
    private LibraryView view;
    private LibraryDao dao;

    public LibraryController(LibraryDao dao, LibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int mainMenuSelection = 0;

        try {
            while (keepGoing) {

                mainMenuSelection = getMainMenuSelection();

                switch (mainMenuSelection) {

                    case 1:
                        listLibrary();
                        view.printEmptyLine();
                        break;
                    case 2:
                        viewSingleDvdInfo();
                        view.printEmptyLine();
                        break;
                    case 3:
                        searchTitles();
                        view.printEmptyLine();
                        break;
                    case 4:
                        addNewDvd();
                        view.printEmptyLine();
                        break;
                    case 5:
                        removeDvd();
                        view.printEmptyLine();
                        break;
                    case 6:
                        saveFile();
                        view.displayBanner("File Saved");
                        break;
                    case 7:
                        loadFile();
                        view.displayBanner("File Loaded");
                        break;
                    case 8:
                        view.displayBanner("Make sure to Save before Exiting!");
                        boolean wantToSave = view.requestSave();
                        if (wantToSave) {
                            dao.saveLibrary();
                            view.displayBanner("Library Saved");
                            wantToSave = false;
                            keepGoing = false;
                            break;
                        }

                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();

                }

            }

            exitMessage();
        } catch (LibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMainMenuSelection() {
        return view.printMainMenuAndGetSelection();
    }

    private void listLibrary() {
        List<Dvd> library = dao.getAllDvds();
        view.displayDvdLibrary(library);
    }

    private void viewSingleDvdInfo() {
        String title = view.getSingleDvdChoice();
        Dvd singleDvdInfo = dao.getDvd(title);
        view.displayDvd(singleDvdInfo);
        if (singleDvdInfo != null){
        boolean willEdit = view.requestEdit();
        while (willEdit) {
            int editField = getEditInfoSelection();

            switch (editField) {

                case 1:
                    String newTitle = view.editTitle();
                    String oldTitle = singleDvdInfo.getTitle();
                    dao.removeDvd(oldTitle);
                    singleDvdInfo.setTitle(newTitle);
                    dao.addDvd(newTitle, singleDvdInfo);
                    view.displayBanner("Title Changed");
                    break;
                case 2:
                    String newDirector = view.editDirector();
                    singleDvdInfo.setDirectorsName(newDirector);
                    view.displayBanner("Director Changed");
                    break;
                case 3:
                    String newRating = view.editRating();
                    singleDvdInfo.setMpaaRating(newRating);
                    view.displayBanner("MPAA Rating Changed");
                    break;
                case 4:
                    String newReleaseDate = view.editReleaseDate();
                    singleDvdInfo.setReleaseDate(newReleaseDate);
                    view.displayBanner("Release Date Changed");
                    break;
                case 5:
                    String newStudio = view.editStudio();
                    singleDvdInfo.setStudio(newStudio);
                    view.displayBanner("Studio Changed");
                    break;
                case 6:
                    String newAddlInfo = view.editAddlInfo();
                    singleDvdInfo.setAddlInfo(newAddlInfo);
                    view.displayBanner("Additional Info Changed");
                case 7:
                    view.displayBanner("Reloading Main Menu");
                    willEdit = false;
                    break;
                default:
                    view.displayBanner("Quit Breakin Stuff");

            }

        }
    }
    }

    private List<Dvd> searchTitles() {
        view.displayBanner("Search Titles");
        String request = view.getSingleDvdChoice();
        List<Dvd> requests = dao.searchAllDvds(request);
        if (requests.size() == 0){
            view.displayBanner("No Results Match");
        } else {
            view.displaySearchResults(requests);
        }
        return requests;
    }

    private int getEditInfoSelection() {
        return view.whichField();
    }

    private void addNewDvd() {
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayBanner("DVD Added");
    }

    private void removeDvd() {
        dao.removeDvd(view.removeDvd());
        view.displayBanner("DVD Removed");
    }

    private void unknownCommand() {
        view.displayBanner("Unknown Command");
    }

    private void exitMessage() {
        view.displayBanner("Good Bye!");
    }

    private void saveFile() throws LibraryDaoException {
        dao.saveLibrary();
    }

    private void loadFile() throws LibraryDaoException {
        dao.loadLibrary();
    }

}
