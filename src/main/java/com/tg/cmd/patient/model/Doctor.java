package com.tg.cmd.patient.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
public class Doctor {
	
	@Column(insertable = false, updatable = false)
	private String id;

    // Name of the doctor
    private String name;

    // Availability status of the doctor (true if available, false if not)
    private Boolean isAvailable;

    // Getter for doctor name
    public String getName() {
        return name;
    }

    // Setter for doctor name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for doctor availability
    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter for doctor availability
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
    
}

