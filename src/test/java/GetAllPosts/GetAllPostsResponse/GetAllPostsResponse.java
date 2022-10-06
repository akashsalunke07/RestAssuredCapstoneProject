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


	public void hasPost(String post_id,boolean condition){

		int size = this.data.stream()
				.filter(dataItem -> dataItem.getId().equals(post_id))
				.collect(Collectors.toList())
				.size();


		Assert.assertEquals(size>=1,condition);
	}
}