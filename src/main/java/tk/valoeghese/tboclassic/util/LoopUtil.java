package tk.valoeghese.tboclassic.util;

import java.util.function.Consumer;

public class LoopUtil {
	public static void repeat(int count, Consumer<Integer> callback) {
		for (int i = 0; i < count; ++i) {
			callback.accept(i);
		}
	}
}
