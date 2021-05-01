/**
 * @author Dale Butt, 957450
 *
 * This file is used to represent a picture of a user
 *
 */

public class ProfilePicture {
	
	private String pictureURL;
	
	// added this to make user and libarian work (takes 0 as a string at the moment)
	public ProfilePicture(String initial){
		this.pictureURL = initial;
	}

	/**
	 * @return the pictureURL
	 */
	public String getPictureURL() {
		return pictureURL;
	}

	/**
	 * @param pictureURL the pictureURL to set
	 */
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
}