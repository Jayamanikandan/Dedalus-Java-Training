package Creational;

//Creating abstract and concrete classes
abstract class Pizza {
 public abstract void bakePizza();
}

class CheesePizza extends Pizza {
 @Override 
 public void bakePizza() {
 //TODO
 System.out.println("Bake Cheese Pizza");
}
}

class VeggiePizza extends Pizza {
 @Override 
 public void bakePizza() {
   //TODO
 System.out.println(“Bake Veggie Pizza”);
}
}

//Creating Pizza AbstractFactory interface or abstract class
interface PizzaAbstractFactory {
	public Pizza orderPizza();
}

//Creating Factory class for each subclass
class CheesePizzaFactory implements PizzaAbstractFactory 
{ 
	@Override 
	public Pizza orderPizza() {
		return new CheesePizza();
	}
}

class VeggiePizzaFactory implements PizzaAbstractFactory 
{ 
	@Override 
	public Pizza orderPizza() {
		return new VeggiePizza();
	}
}

//Creating a consumer class that will provide the entry point for the client classes to create sub-classes.
class PizzaFactory {
	public static Pizza getPizza(PizzaAbstractFactory factory){
		return factory.orderPizza();
	}
}

public class AbstractFactoryEx {
	public static void main(String[] args) {
		Pizza cheesePizza = PizzaFactory.getPizza(new CheesePizzaFactory());
		Pizza veggiePizza = PizzaFactory.getPizza(new VeggiePizzaFactory());
	}
}