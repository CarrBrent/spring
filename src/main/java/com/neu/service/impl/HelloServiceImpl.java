package com.neu.service.impl;

import org.springframework.stereotype.Service;

import com.neu.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

	public String getNewName(String userName) {
		// TODO Auto-generated method stub
		return "hello spring"+userName;
	}

}
