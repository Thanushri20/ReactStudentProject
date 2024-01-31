package com.org.students.helper;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Detailshelper {
	String studentname;
	long studentphone;
	String studentemail;
	int web;
	int corejava;
	int advancejava;
	int apti;
	int msql;
}
