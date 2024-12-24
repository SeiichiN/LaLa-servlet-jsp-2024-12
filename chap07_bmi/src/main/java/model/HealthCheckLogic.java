package model;

public class HealthCheckLogic {
	public void execute(Health health) {
		double weight = health.getWeight();
		double height = health.getHeight();
		height = height / 100.0;
		double bmi = weight / (height * height);
		health.setBmi(bmi);
		
		String bodyType;
		if (bmi < 18.5) {
			bodyType = "やせ型";
		} else if (bmi < 25.0) {
			bodyType = "普通";
		} else {
			bodyType = "肥満";
		}
		health.setBodyType(bodyType);
	}
}
