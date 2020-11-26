package Expression;

public class Number implements Expression {
	
	private double value;
	
	public Number(double value) {
		this.value =value;
	}
	
	@Override
	public double calculate() {
		// TODO Auto-generated method stub
		return value;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+value;
	}

}
