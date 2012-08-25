package com.geogrep.wording;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumberToWordServiceTest {

	protected static Logger logger = Logger.getLogger(NumberToWordServiceTest.class);
	private NumberToWordService numberToWordService = 
			new NumberToWordService();
	@Test
	public void testConvert() {
		String word = numberToWordService.convert(100);
		logger.info(word);
		assertEquals("one hundred",word);
	
	}
}
