public enum Setting {
	OFF ("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	private String level;
	
	Setting (String aLevel) {
		this.level = aLevel;
	}
	
	public String toString() {
		return level;
	}
}