package com.kinoshita.springboot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

@Component
public class MyDialect extends AbstractDialect implements IExpressionEnhancingDialect {

	private static final Map<String, Object> EXPRESSION_OBJECTS;
	
	static {
	    Map<String, Object> objects = new HashMap<>();
	    objects.put("helper", new MyUtility());
	    EXPRESSION_OBJECTS = Collections.unmodifiableMap(objects);
	}
	
	
	/**
	 * オーバーライド
	 */
	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
