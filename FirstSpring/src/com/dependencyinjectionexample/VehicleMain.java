package com.dependencyinjectionexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VehicleMain {
	IEngine engine;
	Tyres tyre;
	
	public IEngine getEngine() {
		System.out.println("Engine throuhg getter method: "+engine);
		return engine;
	}

	public void setEngine(IEngine engine) {
//		System.out.println("Engine instantiated with setter method.");
		System.out.println("Engine throuh setter method: "+engine);
		this.engine = engine;
	}

	public Tyres getTyre() {
		System.out.println("Tyre: "+tyre);
		return tyre;
	}

	public void setTyre(Tyres tyre) {
//		System.out.println("Tyre instantiated with setter method.");
		System.out.println("Tyre throuh setter method: "+tyre);
		this.tyre = tyre;
	}

	public VehicleMain() {}
	
	public VehicleMain(IEngine engine) {
//		System.out.println("Engine instantiated with constructor with only one argument..");
		System.out.println("Engine through constructor :"+engine);
		this.engine = engine;
		
	}
	
	public VehicleMain(IEngine engine, Tyres tyre) {
//		System.out.println("Engine and tyres instantiated with coonstructor");
		System.out.println("Engine: "+engine+" Tyre: "+tyre);
		this.engine = engine;
		this.tyre = tyre;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		VehicleMain vehicleConstructor = (VehicleMain) context.getBean("injectionThroughConstructor");
		VehicleMain vehicleConstructor1 = (VehicleMain) context.getBean("injectionThroughConstructor1");
		VehicleMain vehicleSetter = (VehicleMain) context.getBean("injectionThroughSetter");
		
		System.out.println("\nDependency injection using constructor :\n"+vehicleConstructor);
		System.out.println("\nDependency injection using constructor with one argument: \n"+vehicleConstructor1);
		System.out.println("\nDependency injection using setter method: \n"+vehicleSetter);
	}

}
