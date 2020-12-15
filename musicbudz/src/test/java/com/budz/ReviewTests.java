package com.budz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.budz.exceptions.InvalidRatingException;
import com.budz.models.AlbumReview;
import com.budz.models.SongReview;

class ReviewTests {

	@Test
	void tooHighAlbumReviewThrowsError() {
		Exception exception = assertThrows(InvalidRatingException.class, () -> {
	        new AlbumReview(0, 0, "test", "test", 11, "test", "test");
	    });

	    String expectedMessage = "InvalidRatingException";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void tooLowAlbumReviewThrowsError() {
		Exception exception = assertThrows(InvalidRatingException.class, () -> {
	        new AlbumReview(0, 0, "test", "test", -1, "test", "test");
	    });

	    String expectedMessage = "InvalidRatingException";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void tooHighSongReviewThrowsError() {
		Exception exception = assertThrows(InvalidRatingException.class, () -> {
	        new SongReview(0, 0, "test", "test", 11, "test", "test");
	    });

	    String expectedMessage = "InvalidRatingException";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void tooLowSongReviewThrowsError() {
		Exception exception = assertThrows(InvalidRatingException.class, () -> {
	        new SongReview(0, 0, "test", "test", -1, "test", "test");
	    });

	    String expectedMessage = "InvalidRatingException";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
