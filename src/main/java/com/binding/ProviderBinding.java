package com.binding;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
public class ProviderBinding {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new TextEditorModule1());
	      TextEditor1 editor = injector.getInstance(TextEditor1.class);
	      editor.makeSpellCheck();
	}
}
class TextEditor1 {
	   private SpellChecker spellChecker;
	   @Inject
	   public TextEditor1( SpellChecker spellChecker) {
	      this.spellChecker = spellChecker;
	   }

	   public void makeSpellCheck(){
	      spellChecker.checkSpelling();
	   } 
	}

	//Binding Module
	class TextEditorModule1 extends AbstractModule {

	   @Override
	   protected void configure() {
	      bind(SpellChecker.class)
	         .toProvider(SpellCheckerProvider.class);
	   } 
	}

	//spell checker interface
	interface SpellChecker {
	   public void checkSpelling();
	}

	//spell checker implementation
	class SpellCheckerImpl implements SpellChecker {

	   private String name;
	   private String city;
	  

	   @Inject
	   public SpellCheckerImpl(String name, 
	      String city){
	      this.name = name;
	      this.city = city;
	   } 

	   @Override
	   public void checkSpelling() { 
	      System.out.println("Inside checkSpelling." );
	      System.out.println("---------------------");
	      System.out.print("Name: ");
	      System.out.println(name);
	      System.out.print("City: ");
	      System.out.println(city);
	   }
	}

	class SpellCheckerProvider implements Provider<SpellChecker>{

	   @Override
	   public SpellChecker get() {
	      String dbUrl = "ABC";
	      String user = "Pune";

	      SpellChecker SpellChecker = new SpellCheckerImpl(dbUrl, user);
	      return SpellChecker;
	   }
	}