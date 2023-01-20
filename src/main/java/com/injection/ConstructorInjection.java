package com.injection;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
public class ConstructorInjection {

	public static void main(String[] args) {
		 Injector injector = Guice.createInjector(new DisplayModule());
	     Display display = injector.getInstance(Display.class);
	     display.displayname(); 
	}
}
class Display {
	   private Name name;

	   @Inject
	   public Display(Name name) {
	      this.name = name;
	   }

	   public void displayname(){
	      name.checkName();
	   }
	}


	class DisplayModule extends AbstractModule {

	   @Override
	   protected void configure() {
	      bind(Name.class).to(NameData.class);
	   } 
	}


	interface Name {
	   public void checkName();
	}



	class NameData implements Name {

	   @Override
	   public void checkName() {
	      System.out.println("Vishwa Desai" );
	   } 
	}