package com.milan.demo.zip.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UsageId implements Serializable{

	private String ip;
	private Date date;
}
