package com.inject_m;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
public class MethodInjection {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new DisplayModule());
	    Display display = injector.getInstance(Display.class);
	    display.displayname();
	}
}
class Display {
	   private Name name;

	   @Inject
	   public Display( Name name) {
	      this.name = name;
	   }

	   public void displayname(){
	      name.checkName();
	   } 
	}


	class DisplayModule extends AbstractModule {

	   @Override
	   protected void configure() { 
	      bind(String.class)
	         .annotatedWith(Names.named("Name"))
	         .toInstance("Vishwa Desai");
	   } 
	}

	@ImplementedBy(NameData.class)
	interface Name {
	   public void checkName();
	}


	class NameData implements Name {
	 
	   private String uname;

	   public NameData(){}
	   
	   @Inject 
	   public void setName(@Named("Name") String uname){
	      this.uname = uname;
	   }

	   @Override
	   public void checkName() { 
	      System.out.println("Inside Name" );
	      System.out.println("-----------");
	      System.out.println(uname); 
	   }
	}
