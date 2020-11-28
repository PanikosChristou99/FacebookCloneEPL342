package application;

public class Link {
	private int id;
	private String name;
	private String URL;
	private String message;
	private String description;
	private String caption;
	private int user_id;
	public int getUser_id() {
		return user_id;
	}

	public Link(int id, String name, String uRL, String message, String description, String caption, int user_id) {
		super();
		this.id = id;
		this.name = name;
		URL = uRL;
		this.message = message;
		this.description = description;
		this.caption = caption;
		this.user_id = user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
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

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}


	

}
