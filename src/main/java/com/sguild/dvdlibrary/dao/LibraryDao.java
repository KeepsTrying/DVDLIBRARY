/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.dvdlibrary.dao;

import com.sguild.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface LibraryDao {

    /*
    @return String array containing Dvd titles of all Dvds in the library
     */
    List<Dvd> getAllDvds();

    
    
    
    /*
    @return Dvd object associated with title/key, null otherwise
    */
    Dvd getDvd(String title);
    
    
    
    
    
    /*
    @param String userInput, to search database for key word
    @return String array containind Dvd titles of all associated Dvds
    */
    
    List<Dvd> searchAllDvds(String userInput);
    
    
    
    
    
    /*
    @param title which Dvd is associated
    @param dvd to be added to the library
    @return dvd object associated with above info
    */
    Dvd addDvd(String title, Dvd dvd);
   
    
    
    
    /*
    @param the Dvd title/key associated with dvd object desired to be removed
    @return the dvd object removed or null otherwise
    */
    Dvd removeDvd(String title);

    public void saveLibrary() throws LibraryDaoException;

    public void loadLibrary() throws LibraryDaoException;

}
