package at.jku.weiner.c.preprocess.utils.macros;

public class MacroRanges {
	public final int startIndex;
	public int stopIndex;
	public int addedElements;
	public int removedElements;
	public int nextIndex;
	public final boolean shouldDoRemoves;

	public MacroRanges(final int startIndex, final int stopIndex,
			final int currIndex, final boolean shouldDoRemoves) {
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
		this.addedElements = 0;
		this.removedElements = 0;
		this.nextIndex = currIndex;
		this.shouldDoRemoves = shouldDoRemoves;
	}

	@Override
	public String toString() {
		return "data(start='" + this.startIndex + "', stopIndex='"
				+ this.stopIndex + "', added='" + this.addedElements
				+ ", removed='" + this.removedElements + "', shouldDoRemoves='"
				+ this.shouldDoRemoves + "')";
	}

	public void addElement() {
		this.addElements(1);
	}

	public void addElements(final int elementsCount) {
		if (elementsCount < 0) {
			throw new IllegalArgumentException(
					"Elements count for add elements can not be negative!");
		}
		this.stopIndex += elementsCount;
		this.nextIndex += elementsCount;
		this.addedElements += elementsCount;
	}

	public void removeElement() {
		this.removeElements(1);
	}

	public void removeElements(final int elementsCount) {
		this.removeElements(elementsCount, this.shouldDoRemoves);
	}

	private void removeElements(final int elementsCount,
			final boolean shouldDoRemoves) {
		if (elementsCount < 0) {
			throw new IllegalArgumentException(
					"Elements count for remove elements can not be negative!");
		}
		this.removedElements += elementsCount;
		if (shouldDoRemoves) {
			this.nextIndex -= elementsCount;
		}
		this.stopIndex -= elementsCount;
	}

	public void undoInsertion() {
		this.addedElements--;
		this.stopIndex--;
	}

	public void update(final MacroRanges newRange) {
		this.addElements(newRange.addedElements);
		this.removeElements(newRange.removedElements, true);
		this.nextIndex = newRange.nextIndex;
	}

	protected int getCurrentInsertionIndex() {
		return this.startIndex + this.addedElements;
	}

	protected int getNextIndex() {
		return this.nextIndex;
	}

}
