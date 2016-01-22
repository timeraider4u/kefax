package at.jku.weiner.c.preprocess.utils.macros;

public class MacroRanges {
	public final int startIndex;
	public int stopIndex;
	public int addedElements;
	public int removedElements;
	public int nextIndex;
	public final int level;

	public MacroRanges(final int startIndex, final int stopIndex,
			final int macroLevel) {
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
		this.addedElements = 0;
		this.removedElements = 0;
		this.nextIndex = startIndex;
		this.level = macroLevel;
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer("data(level='");
		buffer.append(this.level);
		buffer.append("', start='");
		buffer.append(this.startIndex);
		buffer.append("', stopIndex='");
		buffer.append("', added='");
		buffer.append(this.addedElements);
		buffer.append("', removed='");
		buffer.append("')");
		return buffer.toString();
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
		this.removeElements(elementsCount, this.shouldDoRemoves());
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
		if (this.nextIndex < 0) {
			throw new IllegalArgumentException(
					"next index can not be negative!");
		}
	}

	private boolean shouldDoRemoves() {
		return ((this.level % 2) == 0);
	}

	public void undoInsertion() {
		this.addedElements--;
		this.stopIndex--;
		this.nextIndex--;
	}

	public void update(final MacroRanges newRange) {
		this.addElements(newRange.addedElements);
		this.removeElements(newRange.removedElements, (!this.shouldDoRemoves()));
	}

	protected int getCurrentInsertionIndex() {
		return this.startIndex + this.addedElements;
	}

	protected int getNextIndex() {
		return this.nextIndex;
	}

}
