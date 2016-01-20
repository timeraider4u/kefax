package at.jku.weiner.c.preprocess.utils.macros;

public class MacroRanges {
	public final int startIndex;
	public int stopIndex;
	public int addedElements;
	public int removedElements;
	
	public MacroRanges(final int startIndex, final int stopIndex) {
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
		this.addedElements = 0;
		this.removedElements = 0;
	}
	
	@Override
	public String toString() {
		return "data(start='" + this.startIndex + "', currIndex='"
				+ "', added='" + this.addedElements + ", removed='"
				+ this.removedElements + "')";
	}
	
	public void addElement() {
		this.addElements(1);
	}
	
	public void addElements(final int elementsCount) {
		if (elementsCount < 0) {
			throw new IllegalArgumentException(
					"elements count of elements added can not be negative!");
		}
		this.stopIndex += elementsCount;
		this.addedElements += elementsCount;
	}
	
	public void removeElement() {
		this.removeElements(1);
	}
	
	public void removeElements(final int elementsCount) {
		if (elementsCount < 0) {
			throw new IllegalArgumentException(
					"elements count of elements removed can not be negative!");
		}
		this.removedElements += elementsCount;
		this.stopIndex -= elementsCount;
	}
	
	public void undoInsertion() {
		this.addedElements--;
		this.stopIndex--;
	}

	public void update(final MacroRanges newRange) {
		this.addElements(newRange.addedElements);
		this.removeElements(newRange.removedElements);
	}
	
	public int getCurrentIndex() {
		return this.startIndex + this.addedElements;
	}

}
