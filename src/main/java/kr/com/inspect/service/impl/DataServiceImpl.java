package kr.com.inspect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.com.inspect.repository.DataRepository;
import kr.com.inspect.service.DataService;

@Service
public class DataServiceImpl implements DataService {
	@Autowired
	private DataRepository dataRepository;

	@Override
	public void exportExcel() {
		
	}
	
}
