package Expression;

public class Plus extends BinaryExpression {

	public Plus(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+this.left.toString()+"+"+this.right.toString()+")";
	}

	@Override
	public double calculate() {
		// TODO Auto-generated method stub
		return left.calculate()+right.calculate();
	}

}
