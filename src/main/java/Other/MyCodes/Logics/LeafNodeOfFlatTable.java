package Other.MyCodes.Logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeafNodeOfFlatTable {

	List<Integer> leafNodes = new ArrayList<>();

	public void fun(Integer pid, List<FlatTable> list) {

		List<Integer> childNodesList = new ArrayList<>();
		for(FlatTable nodes : list) {
			if(pid == nodes.getParentId() && !nodes.getIsLowest())
				childNodesList.add(nodes.getId());
			else if(nodes.getIsLowest() && !leafNodes.contains(nodes.getId()))
				leafNodes.add(nodes.getId());
		}

		if(childNodesList.isEmpty())
			return;
		
		for(Integer cid : childNodesList) {
			fun(cid, list);
		}

	}

	public static void main(String[] args) {

		//FlatTable(Integer id, Integer parentId, Boolean isLowest)
		List<FlatTable> list = Arrays.asList(
				new FlatTable(25, null, false),
				new FlatTable(26, 25, false),
				new FlatTable(27, 25, false),
				new FlatTable(28, 25, false),
				new FlatTable(29, 26, false),
				new FlatTable(30, 29, false),
				new FlatTable(31, 30, true),
				new FlatTable(32, 30, true),
				new FlatTable(33, 29, false),
				new FlatTable(34, 33, true),
				new FlatTable(35, 33, true),
				new FlatTable(36, 33, true),
				new FlatTable(37, 28, true),
				new FlatTable(38, 28, true));
		//leaf nodes : 31, 32, 34, 35, 36, 37, 38

		LeafNodeOfFlatTable object = new LeafNodeOfFlatTable();

		Integer pid = null;
		for(FlatTable nodes : list) {
			if(nodes.getParentId() == null) {
				pid =nodes.getId();
				break;
			}
		}
		if(pid != null)
			object.fun(pid, list);
		
		System.out.println(object.leafNodes);

	}

}
