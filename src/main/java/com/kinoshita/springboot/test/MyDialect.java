package com.kinoshita.springboot.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

@Component
public class MyDialect extends AbstractDialect implements IExpressionEnhancingDialect {
	
	/**
	 * オーバーライド
	 */
	
	public MyDialect() {
		super();
	}
	
	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext arg0) {
		Map<String, Object> objects = new HashMap<>();
	    objects.put("helper", new MyUtility());
	    return objects;
	}

}
