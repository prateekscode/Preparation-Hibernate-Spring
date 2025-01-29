package com.tutorial;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println("Project started");
    	SessionFactory factory=new Configuration().configure().buildSessionFactory();
    	
    	//Creating student 
    	Student st=new Student();
    	st.setId(101);
    	st.setName("Anubhav");
    	st.setCity("Kanpur");
    	
    	//creating object of address class
    	Address ad=new Address();
    	ad.setStreet("Street1");
    	ad.setCity("Kanpur");
    	ad.setOpen(true);
    	ad.setAddedDate(new Date());
    	ad.setX(1234.24);
    	
    	
		/*
		 * Instead of using fis.available(), we can use ByteArrayOutputStream for a more
		 * efficient and reliable approach:
		 * 
		 * FileInputStream fis = new FileInputStream("src/main/java/pic3.jpg"); 
		 * ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 * byte[] buffer = new byte[1024];
		 * int bytesRead;
		 * 
		 * while ((bytesRead = fis.read(buffer)) != -1) 
		 * { 
		 * bos.write(buffer, 0, bytesRead); 
		 * }
		 * 
		 * byte[] data = bos.toByteArray();
		 * fis.close(); 
		 * bos.close(); 
		 * ad.setImage(data);
		 * This ensures large files are read properly in chunks of 1024 bytes.
		 */
    	
    	//reading image
    	FileInputStream fis=new FileInputStream("src/main/java/pic3.jpg");
    	byte[] data=new byte[fis.available()];
    	fis.read(data);
    	ad.setImage(data);
    	
    	System.out.println(st);
    	Session session = factory.openSession();
    	//
    	session.beginTransaction();
    	session.persist(st);
    	session.persist(ad);
    	session.getTransaction().commit();
    
    	session.close();	
    	System.out.println("Done");
    }
}
