package GetAllPosts.GetAllPostsResponse;

import java.util.List;
import lombok.Data;

@Data
public class DataItem{
	private Owner owner;
	private String image;
	private String publishDate;
	private String id;
	private String text;
	private int likes;
	private List<Object> tags;
	private String updatedDate;
}