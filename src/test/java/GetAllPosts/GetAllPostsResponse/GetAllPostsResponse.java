package GetAllPosts.GetAllPostsResponse;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.Setter;
import org.testng.Assert;

@Data
public class GetAllPostsResponse{
	@Setter
	private int statusCode;

	private int total;
	private List<DataItem> data;
	private int limit;
	private int page;


	public boolean hasPost(String postId){

		int size = data.stream()
				.filter(dataItem -> dataItem.getId().equals(postId))
				.collect(Collectors.toList())
				.size();

		return size == 1;

	}
}