package j8.nio2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

class ImportantBook implements Serializable{
    private String author; 
    private String isbn;
    private int authorAge; // effectively 'transient'
    private static final long serialVersionUID = 1234567L;
    
    // The following ObjectStreamField[] states what fields are to be serialised.
    // Any field left out is essentially 'transient'.
    // Thus, 'authorAge' is not serialised as it is not listed.
    private static final ObjectStreamField[] fieldsToSerialise = {
        new ObjectStreamField("author", String.class),
        new ObjectStreamField("isbn", String.class)
    };
    
    ImportantBook(String author, String isbn, int authorAge) {
        this.author = author;
        this.isbn = isbn;
        this.authorAge = authorAge;
    }

    @Override
    public String toString() {
        return author + "; " + isbn + ";" + authorAge ;
    }

    // custom code
    private void writeObject(ObjectOutputStream oos) throws Exception{
        ObjectOutputStream.PutField fields = oos.putFields();
        // if we were concerned with security, we could encrpyt the data first...
        fields.put("author", author);
        fields.put("isbn", isbn);
        oos.writeFields();
    }
    private void readObject(ObjectInputStream ois) throws Exception{
        ObjectInputStream.GetField fields = ois.readFields();
        // if 'author' has no value, 'null' will be used
        // if we had encrpyted the data first, now we would decrypt it...
        author = (String)fields.get("author", null); 
        isbn   = (String)fields.get("isbn", null); 
    }
}

public class CustomSerialisation {
    public static void main(String[] args) {
        // Serialise an ImportantBook
        // Creates file here: C:\Users\skennedy\Documents\NetbeansProjects\Udemy    (Windows)
        //                  : /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot   (Mac)
        try(var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("important_book.ser")))){
            ImportantBook nbBook = new ImportantBook("Joe Bloggs", "111-2-333-55555-1", 35);
            System.out.println("BEFORE: "+nbBook);
            out.writeObject(nbBook);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Deserialise an ImportantBook
        try(var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("important_book.ser")))){
            ImportantBook nbBook = (ImportantBook)in.readObject();
            System.out.println("AFTER: "+nbBook);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
