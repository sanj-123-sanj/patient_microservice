package com.tg.cmd.patient.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
public class Clinic {
	
	@Column(insertable = false, updatable = false)
	private String id;

    private String clinicName;
    private LocalTime startTime;
    private LocalTime endTime;

    // Getters and setters
    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
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


