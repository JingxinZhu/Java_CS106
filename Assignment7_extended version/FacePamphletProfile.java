/*
 * File: FacePamphletProfile.java
 * ------------------------------
 * This class keeps track of all the information for one profile
 * in the FacePamphlet social network.  Each profile contains a
 * name, an image (which may not always be set), a status (what 
 * the person is currently doing, which may not always be set),
 * and a list of friends.
 */

import acm.graphics.*;
import java.util.*;


public class FacePamphletProfile implements FacePamphletConstants {
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for
	 * the profile.
	 */
	public FacePamphletProfile(String name) {
		userName = name;
	}
	
	/* ************************ */
	/* Extension Part IV starts */
	public void setImageFile(String fileName) {
		imageFile = fileName;
	}
	
	public String getImageFile () {
		return imageFile;
	}
	
	/* Extension Part IV ends  */
	/* *********************** */
	
	/** This method returns the name associated with the profile. */ 
	public String getName() {
		return userName;	
	}

	/** 
	 * This method returns the image associated with the profile.  
	 * If there is no image associated with the profile, the method
	 * returns null. */ 
	public GImage getImage() {
		return photoGImage;
	}

	/** This method sets the image associated with the profile. */ 
	public void setImage(GImage image) {
		photoGImage = image;
	}
	
	/** 
	 * This method returns the status associated with the profile.
	 * If there is no status associated with the profile, the method
	 * returns the empty string ("").
	 */ 
	public String getStatus() {
		if (statusStr != null) {
			return statusStr;
		} else {
			return "";
		}
	}
	
	/** This method sets the status associated with the profile. */ 
	public void setStatus(String status) {
		statusStr = status;
	}

	/** 
	 * This method adds the named friend to this profile's list of 
	 * friends.  It returns true if the friend's name was not already
	 * in the list of friends for this profile (and the name is added 
	 * to the list).  The method returns false if the given friend name
	 * was already in the list of friends for this profile (in which 
	 * case, the given friend name is not added to the list of friends 
	 * a second time.)
	 */
	public boolean addFriend(String friend) {
		boolean flag = !friendsList.contains(friend);
		if ( flag ) friendsList.add(friend);
		return flag;
	}

	/** 
	 * This method removes the named friend from this profile's list
	 * of friends.  It returns true if the friend's name was in the 
	 * list of friends for this profile (and the name was removed from
	 * the list).  The method returns false if the given friend name 
	 * was not in the list of friends for this profile (in which case,
	 * the given friend name could not be removed.)
	 */
	public boolean removeFriend(String friend) {
		boolean flag = friendsList.contains(friend);
		if (flag) {
			friendsList.remove(friend);
		}
		return flag;
	}

	/** 
	 * This method returns an iterator over the list of friends 
	 * associated with the profile.
	 */ 
	public Iterator<String> getFriends() {
		return friendsList.iterator();
	}
	
	/** 
	 * This method returns a string representation of the profile.  
	 * This string is of the form: "name (status): list of friends", 
	 * where name and status are set accordingly and the list of 
	 * friends is a comma separated list of the names of all of the 
	 * friends in this profile.
	 * 
	 * For example, in a profile with name "Alice" whose status is 
	 * "coding" and who has friends Don, Chelsea, and Bob, this method 
	 * would return the string: "Alice (coding): Don, Chelsea, Bob"
	 */ 
	public String toString() {
		String names = "";
		for (int i = 0; i < friendsList.size(); i++) {
			if (i > 0) names += ", ";
			names += friendsList.get(i);
		}
		if (statusStr == null) statusStr = "";
		String profileStr = userName + " (" + statusStr + "): " + names;
		return profileStr;
	}
	
	
	/* Private instance variables */
	private String userName;
	private String statusStr;
	private GImage photoGImage;
	private ArrayList<String> friendsList = new ArrayList<String>();
	private String imageFile;
	
}
