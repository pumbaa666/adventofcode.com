package ch.correvon.adventofcode.day02.first;

public enum Hand
{
	ROCK("A", "X"),
	PAPER("B", "Y"),
	CISOR("C", "Z");

	private Hand(String label, String opponentLabel)
	{
		this.label = label;
		this.opponentLabel = opponentLabel;
		this.value = this.label.charAt(0) - "A".charAt(0) + 1;
	}

	public int getValue()
	{
		return this.value;
	}

	public static Hand parseEnum(String label)
	{
		for(Hand hand:Hand.values())
			if(hand.label.equals(label) || hand.opponentLabel.equals(label))
				return hand;

		System.err.println("Unable to find Hand : " + label);
		return null;
	}

	public final int value;
	public final String label;
	public final String opponentLabel;
}
