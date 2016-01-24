package at.jku.weiner.c.preprocess.utils.macros;

public class MacroRanges {
	public final int startIndex;
	public int stopIndex;
	public int addedElements;
	public int removedElements;
	public int changedElements;
	
	public MacroRanges(final int startIndex, final int stopIndex) {
		this.startIndex = startIndex;
		this.stopIndex = stopIndex;
		this.addedElements = 0;
		this.removedElements = 0;
		this.changedElements = 0;
	}
	
	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer("data(");
		buffer.append("start='");
		buffer.append(this.startIndex);
		buffer.append("', stopIndex='");
		buffer.append(this.stopIndex);
		buffer.append("', added='");
		buffer.append(this.addedElements);
		buffer.append("', removed='");
		buffer.append(this.removedElements);
		buffer.append("', changed='");
		buffer.append(this.changedElements);
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
		this.addedElements += elementsCount;
		this.changedElements += elementsCount;
	}
	
	public void removeElement() {
		this.removeElements(1);
	}
	
	public void removeElements(final int elementsCount) {
		if (elementsCount < 0) {
			throw new IllegalArgumentException(
					"Elements count for remove elements can not be negative!");
		}
		this.removedElements += elementsCount;
		this.stopIndex -= elementsCount;
	}
	
	public void undoInsertion() {
		this.undoInsertions(1);
	}

	protected void undoInsertions(final int elementsCount) {
		this.addedElements--;
		this.changedElements--;
		this.stopIndex--;
	}
	
	protected int getCurrentInsertionIndex() {
		return this.startIndex + this.addedElements;
	}
	
	protected int update(final MacroRanges newRange,
			final boolean calledFromRescan) {
		this.addElements(newRange.addedElements);
		this.removeElements(newRange.removedElements);
		this.changedElements -= newRange.removedElements;
		final int next = newRange.startIndex + newRange.changedElements;
		if (newRange.changedElements == 0) {
			return next;
		}
		final int result = next - 1;
		return result;
	}
	
}
