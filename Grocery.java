package Assignment3;

import java.text.DecimalFormat;

public class Grocery extends Item {
	
	public static final double PREMIUM = 1.20;
	
	protected enum perish{P,NP};
	
	protected perish perishable;
	
	Grocery(String itName, double itPrice, int itQuantity, double itWeight, String perishability){
		super(itName, itPrice, itQuantity, itWeight);
		if(perishability.contentEquals("P")){
			perishable = perish.P;
		}else if(perishability.contentEquals("NP")){
			perishable = perish.NP;
		}
	}
	
	double calculatePrice () 
	{
		double final_price = 0.0;
		final_price = (20*weight)*quantity;
		if(perishable == perish.P){
			final_price *= PREMIUM;
		}
		final_price += ((price*quantity)*SALESTAX);
		return final_price;
	}
	
	void printItemAttributes () 
	{
		DecimalFormat df = new DecimalFormat("0.00"); 
		System.out.println("Item: " + name);
		System.out.println("Price: $" + df.format(price));
		System.out.println("Quantity: " + quantity);
		System.out.println("Weight: " + weight);
		if(perishable == perish.P){
			System.out.println("Perishability: Perishable");
		}else if(perishable == perish.NP){
			System.out.println("Perishability: Not Perishable");
		}
		System.out.println("TOTAL ITEM COST: $" + df.format(calculatePrice()) + "\n");
	}
	
}
