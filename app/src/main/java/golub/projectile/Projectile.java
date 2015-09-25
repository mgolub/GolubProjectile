package golub.projectile;

public class Projectile {

	private final double angle;
	private final double velocity;
	private double time;
	private final double radians;

	public Projectile(double angle, double velocity, double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
		radians = Math.toRadians(this.angle);

	}

	public void setTime() {
		for (int time = 0; time < 11; time++) {
			this.time = time;

		}
	}

	public double getX() {

		final double formulaX = Math.sin(radians) * velocity * time;
		return formulaX;
	}

	public double getY() {

		final double formulaY = (Math.cos(radians) * velocity * time) - (.5 * 9.8 * (time * time));
		return formulaY;
	}
}
