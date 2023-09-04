package dao;

public class FeedObj {
	
	private String id, ts, content, images;

	public FeedObj(String id, String content,String ts, String images) {
		this.id = id;
		this.content = content;
		this.ts=ts;
		this.images = images;
	}

	public String getId() {return id;}

	public String getContent() {return content;}

	public String getImages() {return images;}	
	
	public String getTs() {return ts;}
}
