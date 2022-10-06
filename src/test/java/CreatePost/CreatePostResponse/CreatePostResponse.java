package CreatePost.CreatePostResponse;

import java.util.List;
import lombok.Data;
import lombok.Setter;

@Data
public class CreatePostResponse{
	@Setter
	private int statusCode;
	private Owner owner;
	private String image;
	private String link;
	private String publishDate;
	private String id;
	private String text;
	private String updatedDate;
	private int likes;
	private List<String> tags;
}