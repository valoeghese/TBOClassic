package tk.valoeghese.tboclassic.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.fabricmc.loader.api.FabricLoader;

public class OverhaulConfig
{
	public static final String JSON = "{\n\"client_tinted_skies\": false\n}";
	public static void init()
	{
		File configLoc = new File(FabricLoader.getInstance().getConfigDirectory().toString() + "/BiomeOverhaul.json");
		GsonBuilder gb = new GsonBuilder();
		Gson gson = gb.setPrettyPrinting().create();
		
		boolean b = false;
		try
		{
			b = configLoc.createNewFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		if (b)
		{
			try (FileWriter writer = new FileWriter(configLoc))
			{
				OverhaulSettings.SETTINGS = gson.fromJson(JSON, OverhaulSettings.class);
				
				writer.write(gson.toJson(OverhaulSettings.SETTINGS));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try (FileReader reader = new FileReader(configLoc))
			{
				OverhaulSettings.SETTINGS = gson.fromJson(reader, OverhaulSettings.class);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
