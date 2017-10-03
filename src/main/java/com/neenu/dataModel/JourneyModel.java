package com.neenu.dataModel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JOURNEYMODEL")
@SequenceGenerator(name="ID_SEQ", initialValue=1, allocationSize=100)
public class JourneyModel {


	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_SEQ")
	@Column(name = "ID", nullable = false)
	private long id;
	
	@Column(name = "CARD_NUMBER", nullable = false)
	private String cardno;
	
	@Column(name = "ORIGIN", nullable = false)
	private String origin;
	
	@Column(name = "DESTINATION")
	private String destination;
	
	@Column(name = "EXECUTION_TIME", nullable = false)
	private Date executionTime;




	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}





	
	



	

}
