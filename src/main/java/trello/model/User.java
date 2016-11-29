package trello.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity(name = "trello_user")
@JsonIgnoreProperties({ "boards", "login", "password", })
public class User {

	@Id
	@SequenceGenerator(name = "trello_user_seq", sequenceName = "trello_user_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trello_user_seq")
	private long id;
	@Column(nullable = false, unique = true)
	private String login;
	@Column(nullable = false)
	private String password;
	@ElementCollection(targetClass = Board.class)
	private Set<Board> sharedBoards;
	@ElementCollection(targetClass = Team.class)
	private Set<Team> teams;
	@OneToMany(mappedBy = "user")

	private Set<Board> boards;

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

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Board> getSharedBoards() {
		return sharedBoards;
	}

	public void setSharedBoards(Set<Board> boards) {
		this.sharedBoards = boards;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	public Set<Board> getBoards() {
		return boards;
	}

	public void setBoards(Set<Board> boards) {
		this.boards = boards;
	}
}
