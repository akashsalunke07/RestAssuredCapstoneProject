package CreatePost.CreatePostRequest;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class CreatePostRequest{
	@Builder.Default
	private String owner= "633ea1d65030244ef9e41c02";
	@Builder.Default
	private String image = "https://img.dummyapi.io/photo-1564694202779-bc908c327862.jpg";

	@Builder.Default
	private String text = "The TestVagrant Story";
	@Builder.Default
	private int likes = 0;

	private List<String> tags;
}