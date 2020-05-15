package ceit.aut.ac.ir.utils;

import ceit.aut.ac.ir.model.Note;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }


    public static String fileReader(File file) {
        StringBuilder sb = new StringBuilder();
        //TODO: Phase1: read content from file
        try (FileReader in = new FileReader(file);
            BufferedReader input = new BufferedReader(in)) {
            String s;
            while ((s = input.readLine() ) != null) {
                sb.append(s + "\n");
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void fileWriter(String content) {
        //TODO: write content on file
        String fileName = getProperFileName(content);
        File file = new File(NOTES_PATH + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileWriter out = new FileWriter(file);
            BufferedWriter output = new BufferedWriter(out)) {
            output.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: Phase1: define method here for reading file with InputStream
    public static String fileInputStreamReader(File file) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream in = new FileInputStream(file)){
            Scanner scanner = new Scanner(in);
            while(scanner.hasNextLine()) {
                sb.append(scanner.nextLine() + "\n");
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    //TODO: Phase1: define method here for writing file with OutputStream
    public static void fileOutputStreamWriter(String content) {
        String fileName = getProperFileName(content);
        File file = new File(NOTES_PATH + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            }catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        try (FileOutputStream stream = new FileOutputStream(file)) {
            PrintStream printer = new PrintStream(stream);
            printer.print(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: Phase2: proper methods for handling serialization
    public static String fileSerializeRead(File file) {
        try (FileInputStream in = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(in)) {
            Note note = (Note)input.readObject();
            StringBuilder sb = new StringBuilder();
            sb.append(note.getTitle());
            sb.append("\n");
            sb.append(getContent(note.getContent()));
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "file damaged";
    }

    public static void fileSerializeWrite(String content) {
        Note note = new Note(getProperFileName(content), content, getDate());
        File file = new File(NOTES_PATH + getProperFileName(content) + getDate());
        if (!file.exists()) {
            System.out.println("here");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileOutputStream out = new FileOutputStream(file, false);
            ObjectOutputStream output = new ObjectOutputStream(out)) {
            output.writeObject(note);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getContent(String content) {
        int a = content.indexOf("\n");
        if (a != -1) {
            return content.substring(a + 1);
        }
        return "";

    }



    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file";
    }

    private static String getDate() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        return f.format(date);
    }
}
