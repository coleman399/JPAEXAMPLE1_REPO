package jpaex;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@NamedQuery(name = "findByUsername", query = "SELECT u FROM User u WHERE u.username = :name")

@Entity
@Table(name = "MyUsers")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, unique = true)
	private String username;

	private boolean adminRights;

	// JPA CONSTRUCTOR
	User() {

	}

	public User(final String username, final boolean adminRights) {
		this.username = username;
		this.adminRights = adminRights;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAdminRights() {
		return adminRights;
	}

	public void setAdminRights(final boolean adminRights) {
		this.adminRights = adminRights;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", adminRights=" + adminRights + "]";
	}

}
