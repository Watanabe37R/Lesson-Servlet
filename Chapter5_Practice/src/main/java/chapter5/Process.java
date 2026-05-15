package chapter5;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Process {
	public static String AgeProcess(int age) {
		if (age < 18 && age >= 0) {
			return "未成年";
		} else if (age < 0) {
			return "年齢がマイナスの数値";
		} else {
			return "大人";
		}
	}

	public static String timeProsess() {
		LocalTime now = LocalTime.now();
		if (now.isAfter(LocalTime.of(5, 0)) && now.isBefore(LocalTime.of(11, 59))) {
			return "おはようございます。";
		} else if (now.isAfter(LocalTime.of(12, 0)) && now.isBefore(LocalTime.of(17, 59))) {
			return "こんにちは。";
		} else {
			return "こんばんは。";
		}
	}

	public static String getTime() {

		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分", Locale.JAPAN);

		String datetime = now.format(formatter);

		return datetime;
	}

	public static String getMessage(String color) {
		return switch (color) {
		case "red"-> "赤は情熱の色です。";
		case "blue" -> "青は冷静さと信頼を表します";
		case "yellow" ->"黄色は元気と希望の色です。";
		case "green" -> "緑は自然や安心感を連想させます。";
		default -> "選択された色は未対応です。";
		};
	}

	public static String getColor(String color) {
		return switch (color) {
        case "red" -> "red";
        case "blue" -> "blue";
        case "yellow" -> "yellow";
        case "green" -> "green";
        default -> "white";

		};
	}
}
