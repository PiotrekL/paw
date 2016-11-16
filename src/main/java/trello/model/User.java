package trello.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity(name="trello_user")
public class User {

	
	@Id
	@SequenceGenerator(name = "trello_user_seq", sequenceName = "trello_user_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trello_user_seq")
	private long id;
	@Column(nullable = false, unique=true)
	private String login;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Board> getBoards() {
		return boards;
	}
	public void setBoards(Set<Board> boards) {
		this.boards = boards;
	}
	@Column(nullable = false)
	private String password;
	@OneToMany
	@JoinColumn(name = "id_user")
	private Set<Board> boards ;
	
private Set<Team> teams;


@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
public Set<Team> getTeams() {
	return teams;
}
public void setTeams(Set<Team> teams) {
	this.teams = teams;
}
}
