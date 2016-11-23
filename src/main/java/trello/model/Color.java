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
public class Color  {
	@Id
	@SequenceGenerator(name = "color_seq", sequenceName = "color_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_seq")
	private long id;
	@OneToMany
	@JoinColumn(name = "id_color")
	private Set<Label> labels;
	private String color;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
