package tk.valoeghese.tboclassic;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LoadMessages
{
	private static final List<String> commonMessages, uncommonMessages, rareMessages;
	
	static
	{
		commonMessages = Arrays.asList(
				"TBO Classic has been initialised!",
				"Deleting 1.12.2...",
				"Also try Lil' Tater!",
				"Y'know TheBiomeOverhaul was the first fabric biomes mod ;)",
				"TBO Classic has been enabled!"
		);
		
		uncommonMessages = Arrays.asList(
				"*hugs tree*",
				"Deleting TheBiomeUnderhaul...",
				"Not TheBiomeUnderhaul!",
				"smaller > bigger - asie"
		);
		
		rareMessages = Arrays.asList(
				"yeet",
				"Deleting Traverse API... Permanently >:)"
		);
	}
	
	private static String addChanceMessage(Random rand, String defaultMessage)
	{
		return rand.nextInt(rareMessages.size() + 1) == 0 ? "There is a 1 in " + String.valueOf((rareMessages.size() + 1) * 100) + " chance that you will see this message!" : defaultMessage;
	}
	
	public static void logMessage(Random rand)
	{
		TBOClassic.getLogger().info("[TheBiomeOverhaul] " + pickRandomMessage(rand));
	}
	
	private static String pickRandomMessage(Random rand)
	{
		if (rand.nextInt(10) == 0) {
			return rand.nextInt(8) == 0 ? addChanceMessage(rand, rareMessages.get(rand.nextInt(rareMessages.size()))) : uncommonMessages.get(rand.nextInt(uncommonMessages.size()));
		} else {
			return commonMessages.get(rand.nextInt(commonMessages.size()));
		}
	}
}
