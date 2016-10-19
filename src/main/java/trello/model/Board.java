package trello.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Board {
	@Id
	@SequenceGenerator(name = "board_seq", sequenceName = "board_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")
	private long id;
	@Column(nullable = false)
	private String name;
	@OneToMany
	@JoinColumn(name = "id_board")
	private Set<List> lists;

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

	public Set<List> getLists() {
		return lists;
	}

	public void setLists(Set<List> lists) {
		this.lists = lists;
	}

}
