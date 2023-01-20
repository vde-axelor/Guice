package com.inject_o;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
public class OptionalInjection {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new NameModule());
	    Display display = injector.getInstance(Display.class);
	    display.displayName();
	}
}
class Display {
	   private Name name;

	   @Inject
	   public Display( Name name) {
	      this.name = name;
	   }

	   public void displayName(){
	      name.checkName();
	   } 
	}

	//Binding Module
	class NameModule extends AbstractModule {

	   @Override
	   protected void configure() {} 
	}

	@ImplementedBy(UserData.class)
	interface Name {
	   public void checkName();
	}

	//spell checker implementation
	class UserData implements Name {

	   private String name = "Vishwa Desai";

	   public UserData(){}
	   
	   @Inject(optional=true)
	   public void setDbUrl(@Named("Name") String name){
	      this.name = name;
	   }

	   @Override
	   public void checkName() { 
	      System.out.println("Inside Name" );
	      System.out.println("------------");
	      System.out.println(name); 
	   }
	}