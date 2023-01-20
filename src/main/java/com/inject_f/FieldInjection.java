package com.inject_f;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
public class FieldInjection {

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


	class NameModule extends AbstractModule {

	   @Override
	   protected void configure() { 
	      bind(String.class)
	         .annotatedWith(Names.named("Name"))
	         .toInstance("Vishwa Desai");
	   } 
	}

	@ImplementedBy(UserData.class)
	interface Name {
	   public void checkName();
	}


	class UserData implements Name {

	   @Inject @Named("Name")
	   private String name;

	   public UserData(){}

	   @Override
	   public void checkName() { 
	      System.out.println("Inside Name" );
	      System.out.println("------------");
	      System.out.println(name); 
	   }
	}