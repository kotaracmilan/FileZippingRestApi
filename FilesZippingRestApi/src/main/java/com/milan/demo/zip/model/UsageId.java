package com.milan.demo.zip.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class UsageId implements Serializable{

	private String ip;
	private Date date;
}
