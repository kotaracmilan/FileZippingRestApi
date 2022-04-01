package com.milan.demo.zip.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class UsageStatistics implements Serializable{

	
	@EmbeddedId
	private UsageId ipAndDate;
	private int count;
}
