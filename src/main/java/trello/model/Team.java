package trello.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity
public class Team {

	@Id
	@SequenceGenerator(name = "team_seq", sequenceName = "team_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
	private long id;
	@Column(nullable = false)
	private String name;
	 @ElementCollection(targetClass=User.class)
	private Set<User> users;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "trello_user_team", joinColumns = {
			@JoinColumn(name = "TEAM_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "USER_ID", nullable = false, updatable = false) })
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
