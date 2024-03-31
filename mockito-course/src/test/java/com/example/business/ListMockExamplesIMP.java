package com.example.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class ListMockExamplesIMP {

	// Multiple return
	@Test
	public void returnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void letsMockListGet() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("se7en");
		assertEquals("se7en", listMock.get(0));
	}
	
	//Argument Matcher
	@Test
	public void letsMockListGet_argumentMatcher() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("se7en");
		assertEquals("se7en", listMock.get(0));
		assertEquals("se7en", listMock.get(2));
		assertEquals("se7en", listMock.get(5));
	}
	
	//Throws Exception
		@Test(expected=RuntimeException.class)
		public void letsMockListGet_throwsException() {
			List listMock = mock(List.class);
			when(listMock.get(anyInt())).thenThrow(new RuntimeException());
			listMock.get(5);
		}

}
