package Expression;

public class Mul extends BinaryExpression {

	public Mul(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate() {
		// TODO Auto-generated method stub
		return left.calculate()*
				right.calculate();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+this.left.toString()+"*"+this.right.toString()+")";
	}

}
