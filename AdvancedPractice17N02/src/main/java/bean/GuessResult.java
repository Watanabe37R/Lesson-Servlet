package bean;

import java.io.Serializable;

/**
 * 1回分の入力履歴を表すBean
 * 「何を入力したか」「Higher/Lower/Bingoなどの結果メッセージ」を持つ
 */
public class GuessResult implements Serializable {
	private int guess; // ユーザが入力した数
	private String message; // "Higher!", "Lower!", "Bingo!!" 等

	public GuessResult(int guess, String message) {
		this.guess = guess;
		this.message = message;
	}

	public int getGuess() {
		return guess;
	}

	public void setGuess(int guess) {
		this.guess = guess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
