package me.mrtoke.fbook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Component {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="componen_seq")
	@SequenceGenerator(name="component_seq", allocationSize=1)
	private long id;
	private CompType compType;
	private String value;
	
	public Component(CompType compType, String value) {
		super();
		this.compType = compType;
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CompType getCompType() {
		return compType;
	}

	public void setCompType(CompType compType) {
		this.compType = compType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
