package example;

public class TraineeFactory {

	public Trainee create(int id, String name, String module, boolean joshLikesYou) {
		return new Trainee(id, name, module, joshLikesYou);
	}

}
