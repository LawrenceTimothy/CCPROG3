
/**
* The Tweet class represents a tweet in the Twitter application.
* It contains the user handle of the user who posted the tweet, the caption of the tweet, the number of likes of the tweet, the id of the image of the tweet, and the date the tweet was posted.
*
* @author Lawrence Timothy Codorniz
* @version 17.0
 */

/* Class attributes are the variables that are declared inside the class. */ 
public class Tweet {
	/**
	 *  The handle of the user who posted the tweet.
	 */
	public String userHandle;
	/**
	 *  The caption of the tweet.
	 */
	public String caption;
	/** 
	 * The number of likes of the tweet.
	 */
	public int likes; 
	/** 
	 * The id of the image of the tweet.
	 */
	public int imageId;
	/** 
	 * 
	 * The year the tweet was posted.
	 */
	public int createdAtYear;
	/**
	 * The month the tweet was posted.
	 */
	public int createdAtMonth; 
	/** 
	 * The day the tweet was posted.
	 */
	public int createdAtDay;

	/**
	 * This is the constructor of the Tweet class.
	 * @param userHandle The handle of the user who posted the tweet.
	 * @param caption The caption of the tweet.
	 * @param likes The number of likes of the tweet.
	 * @param imageId The id of the image of the tweet.
	 * @param createdAtYear The year the tweet was posted.
	 * @param createdAtMonth The month the tweet was posted.
	 * @param createdAtDay The day the tweet was posted.
	 */
	public Tweet(String userHandle, String caption, int likes, int imageId, int 
	createdAtYear, int createdAtMonth, int createdAtDay) {
		this.userHandle = userHandle;
		this.caption = caption;
		this.likes = likes;
		this.imageId = imageId;
		this.createdAtYear = createdAtYear;
		this.createdAtMonth = createdAtMonth;
		this.createdAtDay = createdAtDay;
	}
	
	/**
	 * This method gets the handle of the user who posted the tweet.
	 * @return The handle of the user who posted the tweet.
	 */
	public String getUserHandle() {
		return userHandle;
	}
	/**
	 * This method gets the caption of the tweet.
	 * @return The caption of the tweet.
	 */
	public String getCaption() {
		return caption;
	}
	/**
	 * This method gets the number of likes of the tweet.
	 * @return The number of likes of the tweet.
	 */
	public int getLikes() {
		return likes;
	}
	/**
	 * This method gets the id of the image of the tweet.
	 * @return The id of the image of the tweet.
	 */
	public int getImageId() {
		return imageId;
	}
	/**
	 * This method gets the creation date of the tweet in the format "day/month/year".
	 * @return The creation date of the tweet.
	 */
	public String getCreatedAt() {
		return createdAtDay + "/" + createdAtMonth + "/" + createdAtYear;
	}
	/**
	 * This method sets the number of likes the tweet has received.
	 * @param newLikes the new number of likes of the tweet.
	 */
	public void setLikes(int newLikes) {
		this.likes = newLikes;
	}
}