package com.inject_d;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class OnDemandInjection {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new NameModule());
		Name spellChecker = new NameData();
		injector.injectMembers(spellChecker);

		Display editor = injector.getInstance(Display.class);
		editor.displayName();
	}
}
class Display {
	   private Name name;

	   @Inject
	   public void setSpellChecker(Name name){
	   this.name = name;
	   }
	   public Display() { }

	   public void displayName(){
	      name.checkName();
	   } 
	}

	//Binding Module
	class NameModule extends AbstractModule {

	   @Override
	   protected void configure() {      
	   } 
	}

	@ImplementedBy(NameData.class)
	interface Name {
	   public void checkName();
	}

	//spell checker implementation
	class NameData implements Name {

	   public NameData(){}
	   
	   @Override
	   public void checkName() { 
	      System.out.println("Hello..." );
	   }
	}