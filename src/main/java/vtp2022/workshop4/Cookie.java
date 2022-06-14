package vtp2022.workshop4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cookie {

    public static String getRandomCookie (String path){
        File cookieFile = new File(path);
        List<String> cookies = new LinkedList<>();
        String randomCookie = "";
        Scanner scanner;
        try{
            scanner = new Scanner(cookieFile);
            while (scanner.hasNextLine()){
                cookies.add(scanner.nextLine());
            }
            scanner.close();

            System.out.println(cookies);
            Random rand = new Random();
            randomCookie = cookies.get(rand.nextInt(cookies.size()));
            System.out.println(randomCookie);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return randomCookie;
    }
    
    public void open() throws IOException{
        File file= new File("/users/kevin/sdf-workshop4/cookieDB.txt");
        if (!file.exists())
        System.out.printf("The file does not exists");
        else // it is a directory
        for (File f: file.listFiles())
        System.out.printf("filename: %s\n", f.getName());
    }

    public void create() throws IOException{
        try {
            File myObj = new File("/users/kevin/sdf-workshop4/cookieDB.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public void read() throws IOException{
        try {
            File myObj = new File("/users/kevin/sdf-workshop4/cookieDB.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }
    
}
