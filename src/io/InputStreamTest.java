package io;

import java.io.*;

public class InputStreamTest {

    public static void main(String[] args) {

        StringBuilder cadena= new StringBuilder();
        try {
            InputStream inputStream= new FileInputStream("file.txt");

            int character;
            while((character = inputStream.read()) != -1){
                cadena.append((char)character);
            }



            OutputStream outputStream = new FileOutputStream("file.txt", true);

            outputStream.write("This is a new textline\n".getBytes());
            outputStream.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(cadena.toString());

    }

}
