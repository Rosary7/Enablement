package com.sb.aspect;

import org.springframework.stereotype.Service;

@Service
public class EmpService {
	public void throwException() throws Exception {
		throw new Exception();
	}

}
