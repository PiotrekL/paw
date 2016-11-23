package trello.model;

import java.sql.Blob;
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
public class Board {
	@Id
	@SequenceGenerator(name = "board_seq", sequenceName = "board_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private boolean favourite;
	@OneToMany
	@JoinColumn(name = "id_board")
	private Set<List> lists;
	@OneToMany
	@JoinColumn(name = "id_board")
	private Set<Activity> activities;
	@OneToMany
	@JoinColumn(name = "id_board")
	private Set<Attachment> attachments;
	@OneToMany
	@JoinColumn(name = "id_board")
	private Set<Team> teams;
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

	public Set<List> getLists() {
		return lists;
	}

	public void setLists(Set<List> lists) {
		this.lists = lists;
	}

	public Set<Attachment> getAttachment() {
		return attachments;
	}

	public void setAttachment(Set<Attachment> attachment) {
		this.attachments = attachment;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public boolean isFavourite() {
		return favourite;
	}

	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}

	public Set<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "trello_user_board", joinColumns = {
			@JoinColumn(name = "BOARD_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "USER_ID", nullable = false, updatable = false) })
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
