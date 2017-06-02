
public class TennisGame2 implements TennisGame {
	public int player1PointCount = 0;
	public int player2PointCount = 0;

	public String getScore() {
		String playerOneScoreInWords = "";
		String playerTwoScoreInWords = "";

		String score = "";
		if (scoresAreEqual()) {
			score = getEqualScore();
		}

		if (player1PointCount > 0 && player2PointCount == 0) {
			if (player1PointCount == 1)
				playerOneScoreInWords = "Fifteen";
			if (player1PointCount == 2)
				playerOneScoreInWords = "Thirty";
			if (player1PointCount == 3)
				playerOneScoreInWords = "Forty";

			playerTwoScoreInWords = "Love";
			score = playerOneScoreInWords + "-" + playerTwoScoreInWords;
		}
		if (player2PointCount > 0 && player1PointCount == 0) {
			if (player2PointCount == 1)
				playerTwoScoreInWords = "Fifteen";
			if (player2PointCount == 2)
				playerTwoScoreInWords = "Thirty";
			if (player2PointCount == 3)
				playerTwoScoreInWords = "Forty";

			playerOneScoreInWords = "Love";
			score = playerOneScoreInWords + "-" + playerTwoScoreInWords;
		}

		if (player1PointCount > player2PointCount && player1PointCount < 4) {
			if (player1PointCount == 2)
				playerOneScoreInWords = "Thirty";
			if (player1PointCount == 3)
				playerOneScoreInWords = "Forty";
			if (player2PointCount == 1)
				playerTwoScoreInWords = "Fifteen";
			if (player2PointCount == 2)
				playerTwoScoreInWords = "Thirty";
			score = playerOneScoreInWords + "-" + playerTwoScoreInWords;
		}

		if (player2PointCount > player1PointCount && player2PointCount < 4) {
			if (player2PointCount == 2)
				playerTwoScoreInWords = "Thirty";
			if (player2PointCount == 3)
				playerTwoScoreInWords = "Forty";
			if (player1PointCount == 1)
				playerOneScoreInWords = "Fifteen";
			if (player1PointCount == 2)
				playerOneScoreInWords = "Thirty";
			score = playerOneScoreInWords + "-" + playerTwoScoreInWords;
		}

		if (advantagePlayer1() || advantagePlayer2()) {
			score = getAdvantageScore();
		}

		if (player1Wins() || player2Wins()) {
			score = getWinerScore();
		}

		return score;
	}

	private String getWinerScore() {
		if (player1Wins()) {
			return "Win for player1";
		}
		return "Win for player2";
	}

	private boolean player2Wins() {
		return firstPlayerWinsOverSecondPlayer(player2PointCount, player1PointCount);
	}

	private boolean firstPlayerWinsOverSecondPlayer(int firstPlayerPoints, int secondPlayerPoints) {
		return  firstPlayerPoints >= 4 && secondPlayerPoints >= 0 && (firstPlayerPoints - secondPlayerPoints) >= 2;
	}

	private boolean player1Wins() {
		return firstPlayerWinsOverSecondPlayer(player1PointCount, player2PointCount);
	}

	private String getAdvantageScore() {
		String score = "";
		if (advantagePlayer1()) {
			score = "Advantage player1";
		}

		if (advantagePlayer2()) {
			score = "Advantage player2";
		}
		return score;
	}

	private boolean advantagePlayer1() {
		return calculateAdvantageFirstPlayerOverSecondPlayer(player1PointCount, player2PointCount);
	}

	private boolean advantagePlayer2() {
		return calculateAdvantageFirstPlayerOverSecondPlayer(player2PointCount, player1PointCount);
	}

	private boolean calculateAdvantageFirstPlayerOverSecondPlayer(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints > secondPlayerPoints && secondPlayerPoints >= 3;
	}

	private boolean scoresAreEqual() {
		return player1PointCount == player2PointCount;
	}

	private String getEqualScore() {
		String score = "";
		if (player1PointCount == 0)
			score = "Love";
		if (player1PointCount == 1)
			score = "Fifteen";
		if (player1PointCount == 2)
			score = "Thirty";
		score += "-All";
		if (player1PointCount == player2PointCount && player1PointCount >= 3)
			score = "Deuce";
		return score;
	}

	public void wonPoint(String player) {
		if (player == "player1")
			player1PointCount++;
		else
			player2PointCount++;
	}
}