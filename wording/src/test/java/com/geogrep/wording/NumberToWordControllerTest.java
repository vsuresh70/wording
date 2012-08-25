package com.geogrep.wording;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumberToWordControllerTest extends AbstractControllerTest {

	private NumberToWordService numberToWordService;
	
	@Test
	public void testGetWord() throws Exception {
		numberToWordService = mock(NumberToWordService.class);
		when(numberToWordService.convert(100)).thenReturn("one hundred");
		NumberToWordController numberToWordController = new NumberToWordController();
		ReflectionTestUtils.setField(numberToWordController, "numberToWordService",
				numberToWordService);
		ExtendedModelMap uiModel = new ExtendedModelMap();
		String result = numberToWordController.getWord(new Long(100), uiModel);
		assertNotNull(result);
		assertEquals(result, "num2word");
		String word = (String) uiModel.get("num2word");
		assertEquals("one hundred",word);
	}
}
