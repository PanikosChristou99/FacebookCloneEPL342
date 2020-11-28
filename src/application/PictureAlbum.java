package application;

import java.util.ArrayList;

public class PictureAlbum {
	private int id;
	private String name;
	private String description;
	private String link;
	private ArrayList<Picture> pictures;
	private int taken_loc_id;
	private int user_id;
	private String privacy;
	
	public PictureAlbum(int id, String name, String description, String link, ArrayList<Picture> pictures,
			int taken_loc_id, int user_id, String privacy) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.link = link;
		this.pictures = pictures;
		this.taken_loc_id = taken_loc_id;
		this.user_id = user_id;
		this.privacy = privacy;
	}

//	public PictureAlbum(int id, String name, String description, String link,
//			ArrayList<Picture> pictures) {
//		this.id=id;
//		this.name=name;
//		this.description=description;
//		this.link=link;
//		this.pictures=pictures;
//	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "PictureAlbum [id=" + id + ", name=" + name + ", description=" + description + ", link=" + link
				+ ", pictures=" + pictures + ", taken_loc_id=" + taken_loc_id + ", user_id=" + user_id + ", privacy="
				+ privacy + "]";
	}

	public int getTaken_loc_id() {
		return taken_loc_id;
	}

	public void setTaken_loc_id(int taken_loc_id) {
		this.taken_loc_id = taken_loc_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(ArrayList<Picture> pictures) {
		this.pictures = pictures;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	

}
