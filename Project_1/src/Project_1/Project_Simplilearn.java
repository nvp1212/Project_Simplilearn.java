package Project_1;

import java.io.*;
import java.util.Scanner;

import javax.crypto.Mac;
import javax.tools.Tool;


class File_Handling
{
   
String Filename,SearchFile;
   int choose,choose1,choose2,option;
   boolean flag=false;
   
   
   void Welcome()
   {
	   System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
	   System.out.println("-> Welcome to LockedMe.com");
	   System.out.println("-> Developed by:Neha Verma.\n");
	   System.out.println("                               <<----------------Application Highlights-------------------->>");
	   System.out.println("-> This Application is used for handling file operations i.e Creation & Deletion of Folder/File alongwith Searching.");
	   System.out.println("-> Press (Enter key) to continue....");
	   System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
	   try
	   {        
		   System.in.read();
		   DisplayInitial();
	   }
	   catch(Exception e)
	   {	e.printStackTrace();
	   }
   }
   
   void DisplayInitial()
   {
	   Scanner opr = new Scanner(System.in);
	   try
	   {
	     int i=5;
	     do
		{
	   System.out.println("Press 1 to Retrive Folder 'Parent' & Display the contents inside it(in asc.order).");
	   System.out.println("Press 2 to Perform File Operations.");
	   System.out.println("Press 3 to Terminate application.");
	  
	   choose1 = opr.nextInt();
	   if(choose1==1)
	   {
		   RetrieveDir();
		   DisplayInitial();
		   break;  
	   }
	   else if(choose1==2)
	   {
		   Operations();
		   break;
	   }
	   else if(choose1==3)
	   {
		   terminate();
		   break;
	   }
	   else 
	   {
		   System.out.println("Please choose correct option to Continue!");
	   }
	   }	  
		while(i<6);
	   }
	   catch(Exception e)
	   {
		   DisplayInitial();
	   }
	   opr.close();
   }
   
   void RetrieveDir()
   { 
     File dir = new File("C:\\Lockedme\\");
     File array[]=dir.listFiles();
    
     if(array.length>0)
     {
     for (int i=0;i<array.length;i++)
     {
    	 if(array[i].isFile())
    	 {
    	 System.out.println("File:-"+array[i]);
    	 }
    	 else if(array[i].isDirectory())
    	 {
    		 System.out.println("Directory:-"+array[i]);
    	 }
     }
     }
     else
     {
    	 System.out.println("There is no files in Directory.");
     }
	   
   }
   
   void Searchtxt()
   
   {Scanner input = new Scanner(System.in);  
   File dir = new File("C:\\Lockedme\\");
	
   String[] array = dir.list();
   System.out.println("Please Enter File/Folder name, which you want to search in 'Parent'!");
   
   SearchFile=input.next();	
   String txt= SearchFile;
  if (array.length!=0)
  {
	  
     try
     {	
    	 int j = 0;
     for (int i=0;i<array.length;i++)
     {
    	 if(array[i].startsWith(txt))
	    	{
	    	 System.out.println("File/Folder Found:- " +array[i]);
	    	 j=1;
	    	}
     }
     if (j!=1) {
    	 System.out.println("Your search result not found");
    	 Operations();
     }
     Operations();
     }
     catch (Exception e)
     {
    	 Operations();
     }
     input.close();
     
  } 
 
  else {
	  System.out.println("Directory is empty!");
	  Operations();
  }
}

   void terminate()
   {
	   Scanner scnr = new Scanner(System.in);
	   try
	   {
	   System.out.println("Are you sure!then press 1.");
	   
	   choose2= scnr.nextInt();
       switch (choose2) 
       {
       case 1:
           System.out.println("Thanks For Using this Application,Program Terminated Sucessfully!");
           System.exit(0);
           break;
           
       default:
    	   System.out.println("Please Input Correct Value to Terminate or choose another option to continue!");
    	   DisplayInitial();
       }
	   }
       catch(Exception e)
	   {
       System.out.println("Please Input Correct Value to Terminate or choose another option to continue!");
	   DisplayInitial();
	   //e.printStackTrace();
	   }   
	   scnr.close();
   }
   
   void Operations() 
   {
	   Scanner opr = new Scanner(System.in);
	   try
		  {
	   int i=5;
		do
		{
	   System.out.println("Press 1 For Creation of New Folder/File in 'Parent' Directory.");
	   System.out.println("Press 2 For Deleting of Existing Folder/File in 'Parent' Directory.");
	   System.out.println("Press 3 For Searching File in 'Parent' Directory.");
	   System.out.println("Press 4 To Return to Previous Menu.");
	   System.out.println("Press 5 to Terminate application. ");
	   
	   
	   choose = opr.nextInt();
	   
	   if(choose==1)
	   {
		   creating_File();
		   break;
		   
	   }
	   else if(choose==2)
	   {
		   Deleting_File();
		   break;
	   }
	   else if(choose==3)
	   {
		   Searchtxt();
		   break;
	   }
	   else if(choose==4)
	   {
		   
		   DisplayInitial() ;
		   break;
	   }
	   else if(choose==5)
	   {
		   terminate();
		   break;
	   }
	   else 
	   {
		   System.out.println("Please choose correct option to Continue!");
	   }
		}
		while(i<6);
		  }
	   catch (Exception e)
	   {
		   System.out.println("Please choose correct option to Continue!");
	        Operations() ;
	   }
		  opr.close();
   }
   
	void creating_File()
	{
		Scanner opr = new Scanner(System.in);
		int i=5;
		do
		{
	   System.out.println("Press 1 to creating Directory.");
	   System.out.println("Press 2 to creating File.");
	   
	   option = opr.nextInt();
	   
	   if(option==1)
	   {
        boolean success = false;
        //Taking User input For creation of Directory
        System.out.println("Enter the name of directory to be created");
        Scanner reader = new Scanner(System.in);
        String dir = reader.nextLine();
        // Checking whether directory created or not
        File directory = new File("C:\\Lockedme\\"+dir);
        if (directory.exists()) 
        {
            System.out.println("Directory already exists ...");
            Operations() ;
        } else 
        {
            System.out.println("Directory not exists, creating now");

            success = directory.mkdir();
            if (success) 
            {
                System.out.printf("Successfully created new directory : %s%n", dir);
                Operations() ;
            } 
            else 
            {
                System.out.printf("Failed to create new directory: %s%n", dir);
                Operations() ;
            }
        }
        reader.close();
	   }
	   else if(option==2)
	   {  
		boolean success = false;
	    Scanner reader = new Scanner(System.in);
        // For Creating New File
        System.out.println("Enter file name to be created. ");
        String filename = reader.nextLine();
        // Checking whether File created or not
        File f = new File("C:\\Lockedme\\"+filename+".txt");
        if (f.exists() ) 
        {
            System.out.println("File already exists.");
            Operations() ;
        }
        else 
        {
            System.out.println("No such file exists, creating now..");
            try 
            {
				success = f.createNewFile();
			} 
            catch (IOException e) 
            {
				
				e.printStackTrace();
			}
            if (success) 
            {
                System.out.printf("Successfully created new file: %s%n", f);
                Operations() ;
            } 
            else 
            {
                System.out.printf("Failed to create new file: %s%n", f);
                Operations() ;
            }
        }
        reader.close();
		}
	   else {
		   System.out.println("Invalid input!");
		   Operations();
	   }
		}
	   while(i<6);
	   opr.close();  
	}
	
	
	void Deleting_File()
	{
		Scanner opr = new Scanner(System.in);
		int i=5;
		do
		{
	   System.out.println("Press 1 to Deleting Directory.");
	   System.out.println("Press 2 to Deleting File.");
	   
	   option = opr.nextInt();
	   
	   if(option==1)
	   {
		Scanner reader = new Scanner(System.in);
        boolean success = false;
        // User Input For Directory Deleting
        System.out.println("Enter the name of directory to be Deleted:");
        String dir = reader.nextLine();

        File directory = new File("C:\\Lockedme\\"+dir);
        //Checking whether directory Present or not
        if (directory.exists()) 
        {
        	success = directory.delete();
             if (success) 
             {
                 System.out.printf("Successfully Deleted directory : %s%n", dir);
                 Operations() ;
             } 
             else 
             {
                 System.out.printf("Failed to delete directory,First Delete the file inside Directory then delete the folder.: %s%n", dir);
                 Operations() ;
             }

        } 
        else 
        {
            System.out.println("No Such Directory Exists.");
            Operations() ;
        }
        reader.close();
	   }
        
	   else if(option==2)
	   {  
		boolean success = false;
	    Scanner reader = new Scanner(System.in);
        // User Input For File Deleting
        System.out.println("Enter file name to be Deleted:");
        String filename = reader.nextLine();
        //Checking whether File Present or not
        File f = new File("C:\\Lockedme\\"+filename+".txt");
        if (f.exists()  ) 
        {	
        	success = f.delete();
			 if (success ) 
	            {
	                System.out.printf("Successfully deleted file: %s%n", f);
	                Operations() ;
	            } 
	            else 
	            {
	                System.out.printf("Failed to delete file: %s%n", f);
	                Operations() ;
	            }
        } 
        else 
        {
            System.out.println("No such File exists!");
            Operations() ; 
        }

        reader.close();
	   }
	   else {
		   System.out.println("Invalid input!");
		   Operations();
	   }
		}
		   while(i<6);
		opr.close();
	}
	
	void MainDirectory()
	{
        boolean success = false;

        String dir = "Parent";
        //Creating Directory At the beginning of Application
        File directory = new File("C:\\Lockedme\\"+dir);
        if (directory.exists()) 
        { //No Message

        } else 
        {
           // No Message
            success = directory.mkdir();
            if (success) 
            {
               //No Message
            } 
        }
	}
}

public class Project_Simplilearn {
	
	public static void main(String[] args)
	{
		File_Handling fh = new File_Handling();
		//Called this function from Library class to check if directory does not exist then create one.
		fh.MainDirectory();
		fh.Welcome() ;
	}

}
