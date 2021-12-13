package com.dependencyinjectionexample;

public class TeslaEngine implements IEngine{
	String company;
	double cost;
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String importOrigin() {
		return "United States";
	}

	@Override
	public double cost() {
		return cost;
	}

	@Override
	public String toString() {
		return "TeslaEngine [company=" + company + ", cost=" + cost + "]";
	}
	

}
