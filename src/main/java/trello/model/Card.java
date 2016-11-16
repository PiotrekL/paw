package trello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private long placeOnTheList;

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

	public long getPlaceOnTheList() {
		return placeOnTheList;
	}

	public void setPlaceOnTheList(long placeOnTheList) {
		this.placeOnTheList = placeOnTheList;
	}
}
