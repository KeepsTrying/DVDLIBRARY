/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.dvdlibrary.dao;

import com.sguild.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class LibraryDaoFileImpl implements LibraryDao {

    public static final String DVD_LIBRARY = "dvdLibrary.txt";
    public static final String DELIMITER = "::";

    private Map<String, Dvd> library = new HashMap<>();

    @Override
    public List<Dvd> getAllDvds() {
        return new ArrayList<Dvd>(library.values());
    }

    @Override
    public Dvd getDvd(String thisDvd) {
        return library.get(thisDvd);
    }

    @Override
    public List<Dvd> searchAllDvds(String userRequest) {
        List<Dvd> requestsReturned = new ArrayList<>();
        
        Set<String> keySet = library.keySet();
        
        for(String key: keySet) {
            if(key.toLowerCase().contains(userRequest.toLowerCase())){
                requestsReturned.add(library.get(key));
            }
        }
        return requestsReturned;
    }

    @Override
    public Dvd addDvd(String title, Dvd dvd) {
        Dvd newDvd = library.put(title.toLowerCase(), dvd);
        return newDvd;
    }

    @Override
    public Dvd removeDvd(String title) {
        Dvd removedDvd = library.remove(title);
        return removedDvd;
    }

    public void loadLibrary() throws LibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_LIBRARY)));
        } catch (FileNotFoundException e) {
            throw new LibraryDaoException("Could not load DVD Library");
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Dvd currentDvd = new Dvd(currentTokens[0]);
            currentDvd.setDirectorsName(currentTokens[1]);
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setReleaseDate(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setAddlInfo(currentTokens[5]);

            library.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }

    @Override
    public void saveLibrary() throws LibraryDaoException {

        PrintWriter save;

        try {
            save = new PrintWriter(new FileWriter(DVD_LIBRARY));
        } catch (IOException e) {
            throw new LibraryDaoException("Could not save DVD Library", e);
        }

        List<Dvd> library = this.getAllDvds();
        for (Dvd currentDvd : library) {
            save.println(currentDvd.getTitle() + DELIMITER
                    + currentDvd.getDirectorsName() + DELIMITER
                    + currentDvd.getMpaaRating() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getAddlInfo());

            save.flush();

        }
        save.close();
    }
}
