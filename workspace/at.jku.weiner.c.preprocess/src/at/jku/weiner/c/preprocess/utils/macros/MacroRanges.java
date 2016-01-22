package at.jku.weiner.c.preprocess.utils.macros;

public class MacroRanges {
	public final int startIndex;
	public int stopIndex;
	public int addedElements;
	public int removedElements;
	public int levels;

	public MacroRanges(final int startIndex, final int stopIndex) {
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
		this.addedElements = 0;
		this.removedElements = 0;
		this.levels = 1;
	}

	@Override
	public String toString() {
		return "data(start='" + this.startIndex + "', stopIndex='"
				+ this.stopIndex + "', added='" + this.addedElements
				+ ", removed='" + this.removedElements + "', levels='"
				+ this.levels + "')";
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
		if (this.addedElements < 0) {
			throw new IllegalArgumentException(
					"Can not undo insertion that does not exist!");
		}
		this.stopIndex--;
	}
	
	public int update(final MacroRanges newRange) {
		final int current = this.stopIndex;
		this.stopIndex += newRange.addedElements;
		this.stopIndex -= newRange.removedElements;
		// this.addElements(newRange.addedElements);
		// this.removeElements(newRange.removedElements);
		if (this.stopIndex != current) {
			this.levels++;
		}
		final int result = (newRange.startIndex + newRange.addedElements)
				- this.levels;
		return result;
	}
	
	protected int getCurrentIndex() {
		return (this.startIndex + this.addedElements) - this.levels;
	}
	
}
