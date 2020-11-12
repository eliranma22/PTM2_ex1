package Expression;

public class Minus extends BinaryExpression {

	public Minus(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate() {
		// TODO Auto-generated method stub
		return left.calculate()-right.calculate();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+this.left.toString()+"-"+this.right.toString()+")";
	}

}
