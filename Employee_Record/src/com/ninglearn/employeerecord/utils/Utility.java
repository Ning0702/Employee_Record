package com.ninglearn.employeerecord.utils;

import java.util.*;

public class Utility {

private static Scanner scanner = new Scanner(System.in);


/**
 * Function: read the menu
 * @return 1-5
 */
public static char readMenuSelection() {
    char c;
    for (; ; ) {
        String str = readKeyBoard(1, false);//get String
        c = str.charAt(0);//change into char
        if (c != '1' && c != '2' && 
            c != '3' && c != '4' && c != '5') {
            System.out.print("Wrong input. Please input your choice again:");
        } else break;
    }
    return c;
} 

/**
 * Function：read a char from the keyboard input
 * @return char
 */
public static char readChar() {
    String str = readKeyBoard(1, false);
    return str.charAt(0);
}
/**
 * Function：input a char by the keyboard. If press Enter button directly, the default value will be returned;
 * Otherwise return the char
 * @param defaultValue 
 * @return default value or the char
 */

public static char readChar(char defaultValue) {
    String str = readKeyBoard(1, true);
    return (str.length() == 0) ? defaultValue : str.charAt(0);
}

/**
 * Function：read the integer input
 * @return: integer
 */
public static int readInt() {
    int n;
    for (; ; ) {
        String str = readKeyBoard(10, false);//length<=10
        try {
            n = Integer.parseInt(str);
            break;
        } catch (NumberFormatException e) {
            System.out.print("Wrong input. Please input again: ");
        }
    }
    return n;
}
/**
 * Function: read the integer or default value. If the Enter button is pressed, the default value will be returned.
 * Otherwise the integer will be returned.
 * @param defaultValue
 * @return integer or default value
 */
public static int readInt(int defaultValue) {
    int n;
    for (; ; ) {
        String str = readKeyBoard(10, true);
        if (str.equals("")) {
            return defaultValue;
        }
		
		//Exception
        try {
            n = Integer.parseInt(str);
            break;
        } catch (NumberFormatException e) {
            System.out.print("Wrong input. Please input again: ");
        }
    }
    return n;
}

/**
 * Function: read the assigned-length String
 * @param limit the length
 * @return the assign-length String
 */

public static String readString(int limit) {
    return readKeyBoard(limit, false);
}

/**
 * Function: read the assigned-length String or default value.
 * If the Enter button is pressed, the default value will be returned.
 * Otherwise the String will be returned.
 * @param limit the length
 * @param defaultValue 
 * @return the assigned-length String or default value
 */

public static String readString(int limit, String defaultValue) {
    String str = readKeyBoard(limit, true);
    return str.equals("")? defaultValue : str;
}


/**
 * Function: read Y/N choice from the keyboard
 * 
 * @return Y or N
 */
public static char readConfirmSelection() {
    System.out.print("Please input your choice(Y/N)");
    char c;
    for (; ; ) {//loop
    	//change the input letter into upper capitalized
    	//y => Y n=>N
        String str = readKeyBoard(1, false).toUpperCase();
        c = str.charAt(0);
        if (c == 'Y' || c == 'N') {
            break;
        } else {
            System.out.print("Wrong input. Please input again: ");
        }
    }
    return c;
}

/**
 * Function: read a String
 * @param limit the length
 * @param blankReturn If true, the blank String can be read.
 * 					  If false, the blank String cannot be read.
 * 	If the input is blank, or passes the length limit, it needs to input again.	
 * @return String
 */
private static String readKeyBoard(int limit, boolean blankReturn) {
    
	//define the String
	String line = "";

	//scanner.hasNextLine(): see whether there is a next line
    while (scanner.hasNextLine()) {
        line = scanner.nextLine();//read this line
       
		//If line.length=0, no input, press Enter directly
		if (line.length() == 0) {
            if (blankReturn) return line;//If blankReturn=true, return the blank String
            else continue; //If blankReturn=false, the blank String is not accepted, it needs to input again，
        }

		//If the input length passes the limit, the input sign is given.  
		//If the input >0 <= limit, it is accepted.
        if (line.length() < 1 || line.length() > limit) {
            System.out.print("The input length (cannot pass " + limit + ")is over the scope，Please input again: ");
            continue;
        }
        break;
    }

    return line;
}
}

