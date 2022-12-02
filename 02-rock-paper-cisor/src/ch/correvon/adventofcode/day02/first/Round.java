package ch.correvon.adventofcode.day02.first;

public class Round
{
	public Round(Hand me, Hand opponent)
	{
		this.me = me;
		this.opponent = opponent;
	}
	
	public int playRound()
	{
		int objectScore = me.getValue();
		int winScore = 0;
		
		if(me == opponent)
			winScore = 3;
		else		
			switch(me)
			{
				case ROCK : winScore = opponent == Hand.CISOR ? 6 : 0; break;
				case PAPER : winScore = opponent == Hand.ROCK ? 6 : 0; break;
				case CISOR : winScore = opponent == Hand.PAPER ? 6 : 0; break;
			}
		
		System.out.println("This round score : " + (objectScore + winScore) + " ("+objectScore+", "+winScore+")");
		return objectScore + winScore;
	}

	private Hand me;
	private Hand opponent;
}
