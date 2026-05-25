package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 数当てゲームの状態を保持するBean (Model)
 * - answer: 正解の乱数
 * - guessHistory: ユーザが入力した履歴(GuessResult)のリスト
 * - finished: 当たったかどうか（ゲーム終了フラグ）
 */
public class NumberGameBean implements Serializable {
	private int answer; // 1～99の乱数
	private List<GuessResult> guessHistory; // 入力履歴
	private boolean finished; // 正解を当てたらtrue
	private int number; //難易度による最大値

	public NumberGameBean() {
		resetNormal(); // コンストラクタでゲームを初期化
	}
	public NumberGameBean(String s) {
		if("easy".equals(s)) {
			resetEasy();
		}else if("normal".equals(s)) {
			resetNormal();
		}else if("hard".equals(s)) {
			resetHard();
		}
	}
	/**
	 * ゲームを新規開始するときに呼び出す
	 */
	public void resetEasy() {
		// 1～50の乱数を生成
		this.number=50;
		this.answer = (int) (Math.random() * this.number) + 1;
		this.guessHistory = new ArrayList<>();
		this.finished = false;
	}
	
	public void resetNormal() {
		// 1～99の乱数を生成
		this.number=99;
		this.answer = (int) (Math.random() * this.number) + 1;
		this.guessHistory = new ArrayList<>();
		this.finished = false;
	}
	
	public void resetHard() {
		// 1～999の乱数を生成
		this.number=999;
		this.answer = (int) (Math.random() * this.number) + 1;
		this.guessHistory = new ArrayList<>();
		this.finished = false;
	}

	/**
	 * ユーザが入力した値を判定し、Higher/Lower/Bingoを返す
	 * ついでに履歴リストにも追加
	 */
	public void checkGuess(int guess) {
		if (finished) {
			// すでに当たっていれば処理しない（あるいは無視）
			return;
		}

		String message;
		if (guess < answer) {
			message = "Higher!";
		} else if (guess > answer) {
			message = "Lower!";
		} else {
			message = "Bingo!!";
			finished = true;
		}

		// 履歴に追加
		GuessResult result = new GuessResult(guess, message);
		guessHistory.add(result);
	}

	public int getAnswer() {
		return answer;
	}

	public List<GuessResult> getGuessHistory() {
		return guessHistory;
	}

	public boolean isFinished() {
		return finished;
	}
	
	public int getNumber() {
		return number;
	}
}
