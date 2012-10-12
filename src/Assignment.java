import java.awt.print.Book;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Assignment {

	static String[] values  = {"a","b","c"};
	
	// test different versions of index
	static int index = 2;  // first index is at 0,  last index is (length - 1)
	//static int index = 0;
	//static int index = 9;
	
	public static void main(String[] args) {

		 Task tasks[] = new Task[5]; 
		 // blank out array
		 for (int i = 0; i < tasks.length; i++) {
			 tasks[i] = new TaskBasic();	
		}
		 
		 tasks[0] = new TaskBasic();
		 tasks[1] = new TaskBasic(new  Date(),"This is a basic task with date");
		 tasks[2] = new TaskBasic("This is a basic task with description only");
		 tasks[3] = new TaskExtended(new Date(), "Extended Task", "Muddy Waters", new Date(), new Date(), false, "New Songs", "Coming in a long time");	 
		 tasks[4] = new TaskDependents(new Date(), "Extended Task", "Muddy Waters", new Date(), new Date(), false, "New Songs", "Coming in a long time","Need to be able to sing", true, false);
		 
		 for (int i = 0; i < tasks.length; i++) {
			 System.out.println("\nShow Basic Data: " + i );
			 System.out.println(tasks[i].ShowBasicData());
			 System.out.println("\nTo String Data: ");
			 System.out.println(tasks[i].toString());
			 	
		}
		 
		 /*
		Task task0 = new Task();
		System.out.println(task0.toString());
		
		Task task1 = new Task(dtDate, strDescription, strPersonName);
		System.out.println(task1.toString());
		*/
		 
	}//main
	
	
	// Assignment homework week 5 - Item 2-2
	 static String getElement(String[] values, int index){
		 // check if index is less than zero, array has no elements 
		 // and index greater than array element length
		if((index < 0 ) || (values.length == 0 ) || (index >= values.length))  {
			System.out.println("Index out of range");
			return null;
		}//index check
		else{
		System.out.println(values[index]);
		return values[index];
		}
	}//getElement
	
	
}//Assignment


////////////////////////////////////////////////////////////////////////////////////////
//Assignment homework week 6 
abstract class Task {
	 
	private Date itemDate;
	 private String itemDescription;
	 
	 Task(){
		 //System.out.println("No arguments");
		 itemDate=null;
		 itemDescription="";		 
	 }// no arguments
	 
	 // Description only
	 Task( String Description){
		 System.out.println("All 3 arguments");
		 itemDate=null;
		 itemDescription=Description;
	 }// Description only

	 Task(Date dt, String Description){
		 System.out.println("All 3 arguments");
		 itemDate=dt;
		 itemDescription=Description;
	 }// all 2 arguments
	 
	 // Accessor methods	 	
	 Date getItemDate (){ return itemDate;}
	 void setItemDate(Date dt){itemDate = dt;}
	 String getItemDescription (){ return itemDescription;}
	 void setItemDescription (String descript){itemDescription=descript;}

	 abstract String ShowBasicData();

}//Task

class TaskBasic extends Task
{
	TaskBasic(){
		super();
	}
	TaskBasic( String desc){
		super(desc);
	}
	
	TaskBasic(Date dt, String desc){
		super(dt,desc);
	}
	
	String ShowBasicData(){
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		String strDate;
		 Date itemDate = getItemDate();
			if(itemDate != null){
				strDate = dateformat.format(itemDate);
			}else{
				strDate = "";
			}
		
		return "\n" +"Task is: \n" + " Description: " +getItemDescription() + "\n" + 
				" Date: " + strDate;//  + " Person: " + itemPersonName + " Date:" + strDate           + "\n")  ;
	}
	
	public String toString(){
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		String strDate;
		 Date itemDate = getItemDate();
			if(itemDate != null){
				strDate = dateformat.format(itemDate);
			}else{
				strDate = "";
			}
		
		return " Task is: Description: " +getItemDescription() +  
				" Date: " + strDate;		
	}
		
		
	
}//TaskBasic

class TaskExtended extends TaskBasic{
	private String itemPersonName;
	 private Date itemCompletionDate;
	 private Date itemDueDate;
	 private Boolean itemIsComplete;
	 private String itemTitle;
	 private String itemComment;
	 
	 TaskExtended(){
			super();
		}
	 TaskExtended( String desc){
			super(desc);
		}
		
	 TaskExtended(Date dt, String desc){
			super(dt,desc);
		}
	 
	 TaskExtended(Date dt, String Description, String PersonName,
			 Date CompletionDate, Date DueDate, Boolean IsComplete,String Title, String Comment	){
		 super(dt,Description);
		 setItemPersonName(PersonName);
		 setItemCompletionDate(CompletionDate);
		 setItemDueDate(DueDate);
		 setItemIsComplete(IsComplete);
		 setItemTitle(Title);
		 setItemComment(Comment);		 
	 }// all items
	 
	 
	 // Accessor methods	 	
	 String getItemPersonName (){ return itemPersonName;}
	 void setItemPersonName (String personName){itemPersonName=personName;}

	 Date getItemCompletionDate (){ return itemCompletionDate;}
	 void setItemCompletionDate(Date compdt){itemCompletionDate = compdt;}

	 Date getItemDueDate (){ return itemDueDate;}
	 void setItemDueDate(Date duedt){itemDueDate = duedt;}

	
	 // Boolean itemIsComplete;
	 Boolean getIsComplete (){ return itemIsComplete;}
	 void setItemIsComplete(Boolean blIsComp){itemIsComplete = blIsComp;}

	 // String itemTitle;
	 String getItemTitle (){ return itemTitle;}
	 void setItemTitle (String strItemTitle){itemTitle=strItemTitle;}
	 
	 // String itemComment;
	 String getItemComment (){ return itemComment;}
	 void setItemComment (String strItemComment){itemComment=strItemComment;}

	 public String toString(){
			DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
			//String strDate = dateformat.format(itemDate);
			String strDate;
			//= dateformat.format(itemDate);
			 Date itemDate = getItemDate();
			if(itemDate != null){
				strDate = dateformat.format(itemDate);
			}else{
				strDate = "";
			}
			
			String itemPersonName = getItemPersonName();
			
			Date itemCompletionDate = getItemCompletionDate();
			String stritemCompletionDate ;
			if(itemCompletionDate != null){
				stritemCompletionDate = dateformat.format(itemCompletionDate);
			}else{
				stritemCompletionDate = "";
			}
			
			Date itemDueDate = getItemDueDate();
			String stritemDueDate ;
			if(itemDueDate != null){
				stritemDueDate = dateformat.format(itemDueDate);
			}else{
				stritemDueDate = "";
			}	
			
			//private Boolean itemIsComplete;

			Boolean itemIsComplete = getIsComplete();
			String strIsComplete ;
			if(itemIsComplete){
				strIsComplete = "Y";
			}else{
				strIsComplete = "N";
			}	
			
			String itemTitle = getItemTitle();
			String 	itemComment = getItemComment();

			return "Task is: Description: " +getItemDescription() + " Date: " + strDate +
					" Person Name: " + itemPersonName + " Completion Date: " + stritemCompletionDate +
					" Due Date: " + stritemDueDate + " Is Complete: " + strIsComplete +
					" Title: " + itemTitle + " Comment: " + itemComment;
		}//toString	

		String ShowBasicData(){
			DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
			String strDate;
			 Date itemDate = getItemDate();
				if(itemDate != null){
					strDate = dateformat.format(itemDate);
				}else{
					strDate = "";
				}

				String itemPersonName = getItemPersonName();
				
				Date itemCompletionDate = getItemCompletionDate();
				String stritemCompletionDate ;
				if(itemCompletionDate != null){
					stritemCompletionDate = dateformat.format(itemCompletionDate);
				}else{
					stritemCompletionDate = "";
				}
				
				Date itemDueDate = getItemDueDate();
				String stritemDueDate ;
				if(itemDueDate != null){
					stritemDueDate = dateformat.format(itemDueDate);
				}else{
					stritemDueDate = "";
				}	
				
				//private Boolean itemIsComplete;

				Boolean itemIsComplete = getIsComplete();
				String strIsComplete ;
				if(itemIsComplete){
					strIsComplete = "Y";
				}else{
					strIsComplete = "N";
				}	
				
				String itemTitle = getItemTitle();
				String 	itemComment = getItemComment();

			return "Task is: Description: " +getItemDescription() + "\n" + 
					" Date: " + strDate +"\n" +
					" Person Name: " + itemPersonName +"\n" + 
					" Completion Date: " + stritemCompletionDate +"\n" +
					" Due Date: " + stritemDueDate + "\n" +
					" Is Complete: " + strIsComplete +"\n" +
					" Title: " + itemTitle + "\n" +
					" Comment: " + itemComment;
		
		}
	 	 
}//TaskExtended

class TaskDependents extends TaskExtended{
	 private String itemDependents;
	 private Boolean itemHasDependents;
	 private Boolean itemIsDependentComplete;
	

	 TaskDependents(){
			super();
		}
	 TaskDependents( String desc){
			super(desc);
		}
		
	 TaskDependents(Date dt, String desc){
			super(dt,desc);
		}
	 
	 TaskDependents(Date dt, String Description, String PersonName,
			 Date CompletionDate, Date DueDate, Boolean IsComplete,String Title, String Comment,
			 String Dependents, Boolean HasDependents, Boolean IsDependentComplete ){
		 super(dt,Description);
		 setItemPersonName(PersonName);
		 setItemCompletionDate(CompletionDate);
		 setItemDueDate(DueDate);
		 setItemIsComplete(IsComplete);
		 setItemTitle(Title);
		 setItemComment(Comment);
		 
		 setItemDependents(Dependents);
		 setItemHasDependents(HasDependents);
  		 setItemIsDependentComplete(IsDependentComplete); 
		 
	 }// all items
	

	 // String itemDependents;
	 String getItemDependents (){ return itemDependents;}
	 void setItemDependents (String strItemDependents){itemDependents=strItemDependents;}
	 
	 
	 // Boolean itemIsComplete;
	 Boolean getHasDependents (){ return itemHasDependents;}
	 void setItemHasDependents(Boolean blHasDependents){itemHasDependents = blHasDependents;}

	 // Boolean itemIsComplete;
	 Boolean getIsDependentComplete (){ return itemIsDependentComplete;}
	 void setItemIsDependentComplete(Boolean blIsDependentComplete){itemIsDependentComplete = blIsDependentComplete;}

	 public String toString(){
			DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
			//String strDate = dateformat.format(itemDate);
			String strDate;
			//= dateformat.format(itemDate);
			 Date itemDate = getItemDate();
			if(itemDate != null){
				strDate = dateformat.format(itemDate);
			}else{
				strDate = "";
			}
			
			String itemPersonName = getItemPersonName();
			
			Date itemCompletionDate = getItemCompletionDate();
			String stritemCompletionDate ;
			if(itemCompletionDate != null){
				stritemCompletionDate = dateformat.format(itemCompletionDate);
			}else{
				stritemCompletionDate = "";
			}
			
			Date itemDueDate = getItemDueDate();
			String stritemDueDate ;
			if(itemDueDate != null){
				stritemDueDate = dateformat.format(itemDueDate);
			}else{
				stritemDueDate = "";
			}	
			
			//private Boolean itemIsComplete;
			Boolean itemIsComplete = getIsComplete();
			String strIsComplete ;
			if(itemIsComplete){
				strIsComplete = "Y";
			}else{
				strIsComplete = "N";
			}	
			
			String itemTitle = getItemTitle();
			String 	itemComment = getItemComment();

			Boolean itemHasDependents = getHasDependents();
			String strHasDependents ;
			if(itemHasDependents){
				strHasDependents = "Y";
			}else{
				strHasDependents = "N";
			}	
			

			Boolean itemIsDependentComplete = getIsDependentComplete();
			String strIsDependentComplete ;
			if(itemIsDependentComplete){
				strIsDependentComplete = "Y";
			}else{
				strIsDependentComplete = "N";
			}	
			
			return "Task is: Description: " +getItemDescription() + " Date: " + strDate +
					" Person Name: " + itemPersonName + " Completion Date: " + stritemCompletionDate +
					" Due Date: " + stritemDueDate + " Is Complete: " + strIsComplete +
					" Title: " + itemTitle + "Comment: " + itemComment +
					" Has Dependents: " + strHasDependents + 
					" Dependents: " + itemDependents +
					" Dependent Complete: " + strIsDependentComplete;
 
	 }//toString	

	 String ShowBasicData(){
			DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
			String strDate;
			 Date itemDate = getItemDate();
				if(itemDate != null){
					strDate = dateformat.format(itemDate);
				}else{
					strDate = "";
				}

				String itemPersonName = getItemPersonName();
				
				Date itemCompletionDate = getItemCompletionDate();
				String stritemCompletionDate ;
				if(itemCompletionDate != null){
					stritemCompletionDate = dateformat.format(itemCompletionDate);
				}else{
					stritemCompletionDate = "";
				}
				
				Date itemDueDate = getItemDueDate();
				String stritemDueDate ;
				if(itemDueDate != null){
					stritemDueDate = dateformat.format(itemDueDate);
				}else{
					stritemDueDate = "";
				}	
				
				//private Boolean itemIsComplete;

				Boolean itemIsComplete = getIsComplete();
				String strIsComplete ;
				if(itemIsComplete){
					strIsComplete = "Y";
				}else{
					strIsComplete = "N";
				}	
				
				String itemTitle = getItemTitle();
				String 	itemComment = getItemComment();


				Boolean itemHasDependents = getHasDependents();
				String strHasDependents ;
				if(itemHasDependents){
					strHasDependents = "Y";
				}else{
					strHasDependents = "N";
				}	
				

				Boolean itemIsDependentComplete = getIsDependentComplete();
				String strIsDependentComplete ;
				if(itemIsDependentComplete){
					strIsDependentComplete = "Y";
				}else{
					strIsDependentComplete = "N";
				}	
				
			return "Task is: Description: " +getItemDescription() + "\n" + 
					" Date: " + strDate +"\n" +
					" Person Name: " + itemPersonName +"\n" + 
					" Completion Date: " + stritemCompletionDate +"\n" +
					" Due Date: " + stritemDueDate + "\n" +
					" Is Complete: " + strIsComplete +"\n" +
					" Title: " + itemTitle + "\n" +
					" Comment: " + itemComment  + "\n" +
					" Has Dependents: " + strHasDependents + "\n" + 
					" Dependents: " + itemDependents +"\n" +
					" Dependent Complete: " + strIsDependentComplete;
		}//ShowBasicData
}//TaskDependents
