/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sguild.dvdlibrary.ui;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class UserIOConsoleImpl implements UserIO {

    private Scanner userInput = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        String stringValue = userInput.nextLine();
        boolean isValid = false;
        double thing = -100.0;

        while (!isValid) {
            try {
                thing = Double.parseDouble(stringValue);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid entry.");
                isValid = false;
                stringValue = userInput.nextLine();
            }
        }

        return thing;

    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        String stringValue = userInput.nextLine();
        boolean isValid = false;
        double thing = -100f;

        while (!isValid) {
            try {
                thing = Double.parseDouble(stringValue);
                if (thing >= min || thing <= max) {
                    isValid = true;
                } else {
                    isValid = false;
                    System.out.println("Please input a valid entry.");
                    stringValue = userInput.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid entry.");
                isValid = false;
                stringValue = userInput.nextLine();
            }

        }

        return thing;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        String stringValue = userInput.nextLine();
        float thing = -100f;
        boolean isValid = false;

        while (!isValid) {
            try {
                thing = Float.parseFloat(stringValue);
                isValid = true;
            } catch (NumberFormatException e) {
                isValid = false;
                System.out.println("Please input a valid entry.");
                stringValue = userInput.nextLine();

            }
        }
        return thing;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        String stringValue = userInput.nextLine();
        boolean isValid = false;
        Float thing = -100f;

        while (!isValid) {
            try {
                thing = Float.parseFloat(stringValue);
                if (thing > min || thing < max) {
                    isValid = true;
                } else {
                    isValid = false;
                    System.out.println("Please input a valid entry.");
                    stringValue = userInput.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid entry.");
                isValid = false;
                stringValue = userInput.nextLine();
            }

        }

        return thing;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        String stringValue = userInput.nextLine();
        boolean isValid = false;
        int thing = -100;

        while (!isValid) {
            try {
                thing = Integer.parseInt(stringValue);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid entry.");
                isValid = false;
                stringValue = userInput.nextLine();
            }
        }

        return thing;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        String stringValue = userInput.nextLine();
        boolean isValid = false;
        int thing = -100;

        while (!isValid) {
            try {
                thing = Integer.parseInt(stringValue);
                if (thing > min || thing < max) {
                    isValid = true;
                } else {
                    isValid = false;
                    System.out.println("Please input a valid entry.");
                    stringValue = userInput.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid entry.");
                isValid = false;
                stringValue = userInput.nextLine();
            }

        }

        return thing;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        String stringValue = userInput.nextLine();
        boolean isValid = false;
        long thing = -100;

        while (!isValid) {
            try {
                thing = Long.parseLong(stringValue);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid entry.");
                isValid = false;
                stringValue = userInput.nextLine();
            }
        }

        return thing;

    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        String stringValue = userInput.nextLine();
        boolean isValid = false;
        long thing = -100;

        while (!isValid) {
            try {
                thing = Long.parseLong(stringValue);
                if (thing > min || thing < max) {
                    isValid = true;
                } else {
                    isValid = false;
                    System.out.println("Please input a valid entry.");
                    stringValue = userInput.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid entry.");
                isValid = false;
                stringValue = userInput.nextLine();
            }

        }

        return thing;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return userInput.nextLine();
    }

}
