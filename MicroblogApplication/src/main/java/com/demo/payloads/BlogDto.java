package com.demo.payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class BlogDto {

	
	private int id;
	
	private String title;
	
	private String discription;
	
	private Date creationDate;
	
}
