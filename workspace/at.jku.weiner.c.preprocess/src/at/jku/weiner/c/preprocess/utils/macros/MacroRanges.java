package at.jku.weiner.c.preprocess.utils.macros;

public class MacroRanges {
	public final int startIndex;
	public int currIndex;
	public int stopIndex;
	// public int addedElements;
	// public int removedElements;
	public int changedElements;

	public MacroRanges(final int startIndex, final int stopIndex) {
		this.startIndex = startIndex;
		this.currIndex = startIndex;
		this.stopIndex = stopIndex;
		// this.addedElements = 0;
		// this.removedElements = 0;
		this.changedElements = 0;
	}

	@Override
	public String toString() {
		return "data(start='" + this.startIndex + "', currIndex='"
				+ this.currIndex + "', stop='" + this.stopIndex
				+ "', changed='" + this.changedElements
				// + "', added='"+ this.addedElements + ", removed='" +
				// this.removedElements
				+ "')";
	}

	public void addElement(final boolean adaptCurrIndex) {
		this.stopIndex++;
		if ((adaptCurrIndex)) {
			this.currIndex++;
		}
		// this.addedElements++;
		this.changedElements++;
	}

	public void addElements(final boolean adaptCurrIndex,
			final int elementsCount) {
		this.stopIndex += elementsCount;
		if ((adaptCurrIndex) && ((this.currIndex + elementsCount) >= 0)) {
			this.currIndex += elementsCount;
		}
		// this.addedElements += elementsCount;
		this.changedElements += elementsCount;
	}

	public void removeElement(final boolean adaptCurrIndex) {
		if ((adaptCurrIndex) && ((this.currIndex - 1) >= 0)) {
			this.currIndex--;
		}
		// this.removedElements++;
		this.changedElements--;
		this.stopIndex--;
	}

}
