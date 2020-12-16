package com.budz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.budz.exceptions.InvalidRatingException;
import com.budz.models.Review;
class ReviewTests {

	@Test
	void tooHighReviewThrowsError() {
		Exception exception = assertThrows(InvalidRatingException.class, () -> {
	        new Review("test", "album", 0, "test", 11, "test", "test");
	    });

	    String expectedMessage = "InvalidRatingException";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void tooLowReviewThrowsError() {
		Exception exception = assertThrows(InvalidRatingException.class, () -> {
	        new Review("test", "album", 0, "test", -1, "test", "test");
	    });

	    String expectedMessage = "InvalidRatingException";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
