package CreatePost.CreatePostRequest;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class CreatePostRequest{
	private String owner;
	private String image;
	private String text;
	private int likes;
	private List<String> tags;
}