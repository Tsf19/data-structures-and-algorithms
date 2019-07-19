package Other.MyCodes.Logics;

public class FlatTable {
	
	private Integer id;
	private String name;
	private Integer parentId;
	private Integer level;
	private Boolean isLowest;

	public FlatTable() {
		super();
	}

	public FlatTable(Integer id, Integer parentId, Boolean isLowest) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.isLowest = isLowest;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Boolean getIsLowest() {
		return isLowest;
	}
	public void setIsLowest(Boolean isLowest) {
		this.isLowest = isLowest;
	}
	@Override
	public String toString() {
		return "FlatTable [id=" + id + ", name=" + name + ", parentId=" + parentId + ", level=" + level + ", isLowest="
				+ isLowest + "]";
	}
}
