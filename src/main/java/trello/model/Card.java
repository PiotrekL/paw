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
public class Card {
	@Id
	@SequenceGenerator(name = "card_seq", sequenceName = "card_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_seq")
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private boolean archived;
	@Column(nullable = false)
	private int position;
	@Column
	private String describe;
	@OneToMany
	@JoinColumn(name = "id_card")
	private Set<UserComment> userComments;
	@OneToMany
	@JoinColumn(name = "id_card")
	private Set<Label> labels;
	@OneToMany
	@JoinColumn(name = "id_card")
	private Set<Attachment> attachments;

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

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getDesc() {
		return describe;
	}

	public void setDesc(String desc) {
		this.describe = desc;
	}

	public Set<UserComment> getComments() {
		return userComments;
	}

	public void setComments(Set<UserComment> userComments) {
		this.userComments = userComments;
	}

	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

	public Set<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}
}
