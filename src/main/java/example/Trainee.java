package example;

import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;


@Entity
public class Trainee {

	@Id
	private int id;

	private String name;

	private String module;

	private boolean joshLikesYou;

	@Transient
	private final int randomNumber = ThreadLocalRandom.current().nextInt();
	// ONLY FOR JPA, SHOULDN'T BE USED IN YOUR CODE
	Trainee() {

	}

	public Trainee(int id, String name, String module, boolean joshLikesYou) {
		this.id = id;
		this.name = name;
		this.module = module;
		this.joshLikesYou = joshLikesYou;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Trainee other = (Trainee) obj;
		if (id != other.id) {
			return false;
		}
		if (joshLikesYou != other.joshLikesYou) {
			return false;
		}
		if (module == null) {
			if (other.module != null) {
				return false;
			}
		} else if (!module.equals(other.module)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	public int getId() {
		return id;
	}

	public String getModule() {
		return module;
	}

	public String getName() {
		return name;
	}

	public int getRandomNumber() {
		return randomNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (joshLikesYou ? 1231 : 1237);
		result = prime * result + (module == null ? 0 : module.hashCode());
		result = prime * result + (name == null ? 0 : name.hashCode());
		return result;
	}

	public boolean isJoshLikesYou() {
		return joshLikesYou;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", module=" + module + ", joshLikesYou=" + joshLikesYou + "]";
	}

}
