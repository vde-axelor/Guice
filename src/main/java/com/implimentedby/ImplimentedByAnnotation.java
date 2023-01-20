package com.implimentedby;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
public class ImplimentedByAnnotation {

	public static void main(String[] args) {
		 Injector injector = Guice.createInjector(new UserModule());
	     User user = injector.getInstance(User.class);
	     user.displayName();
	}

}
class User {
	   private User name;

	   @Inject
	   public User( User name) {
	      this.name = name;
	   }

	   public void displayName(){
	      name.show();
	   } 
	}


	class UserModule extends AbstractModule {

	   @Override
	   protected void configure() { 
	      bind(String.class)
	         .annotatedWith(Names.named("NAME"))
	         .toInstance("Vishwa Desai");
	   } 
	}

	@ImplementedBy(ShowName.class)
	interface Data {
	   public void show();
	}


	class ShowName implements Data {

	   @Inject @Named("NAME")
	   private String name;

	   public ShowName(){}

	   @Override
	   public void show() { 
	      System.out.println("Inside Name." );
	      System.out.println(name); 
	   }
	}