package com.binding;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provides;
public class ProvidesAnnotation {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new TextEditorModule());
	    TextEditor editor = injector.getInstance(TextEditor.class);
	    editor.makename();
	}
}
class TextEditor {
	   private Name name;
	   @Inject
	   public TextEditor( Name name) {
	      this.name = name;
	   }
	   public void makename(){
	      name.ShowName();
	   } 
	}


	class TextEditorModule extends AbstractModule {

	   @Override
	   protected void configure() {} 

	   @Provides
	   public Name provideName(){

	      String fname = "Vishwa";
	      String lname = "Desai";

	      Name n1 = new EnterName(fname, lname);
	      return n1;
	   }
	}


	interface Name {
	public void ShowName();
	}

	
	class EnterName implements Name {

	   private String fname;
	   private String lname;

	   @Inject
	   public EnterName(String fname, 
	      String lname){
	      this.fname = fname;
	      this.lname = lname;
	   } 

	   @Override
	   public void ShowName() { 
	      System.out.println("Inside ShowName." );
	      System.out.println("-----------------");
	      System.out.print("First Name:");
	      System.out.println(fname);
	      System.out.print("Last Name:");
	      System.out.println(lname);
	   }
	}