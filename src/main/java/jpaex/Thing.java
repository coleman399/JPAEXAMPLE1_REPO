package jpaex;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Thing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	Thing() {
	}

	@Override
	public String toString() {
		return "Thing [id=" + id + "]";
	}
}
