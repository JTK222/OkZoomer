package io.github.ennuil.ok_zoomer.wrench_wrapper.forge;

import com.google.auto.service.AutoService;
import io.github.ennuil.ok_zoomer.wrench_wrapper.WrenchWrapper;
import net.minecraftforge.fml.loading.FMLPaths;
import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.api.serializers.TomlSerializer;
import org.quiltmc.config.implementor_api.ConfigEnvironment;
import org.quiltmc.config.implementor_api.ConfigFactory;

@AutoService(WrenchWrapper.class)
public class ForgeWrapper extends WrenchWrapper {
	private static final ConfigEnvironment CONFIG_ENVIRONMENT = new ConfigEnvironment(FMLPaths.CONFIGDIR.get(), TomlSerializer.INSTANCE, TomlSerializer.INSTANCE);

	@Override
	protected <C extends ReflectiveConfig> C createConfig(String family, String id, Class<C> configCreatorClass) {
		return ConfigFactory.create(CONFIG_ENVIRONMENT, family, id, configCreatorClass);
	}
}
