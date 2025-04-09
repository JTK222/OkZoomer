package io.github.ennuil.ok_zoomer.wrench_wrapper.forge;

import com.google.auto.service.AutoService;
import io.github.ennuil.ok_zoomer.wrench_wrapper.WrenchWrapperImpl;
import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.implementor_api.ConfigEnvironment;

@AutoService(WrenchWrapperImpl.class)
public class WrenchWrapperImplForge implements WrenchWrapperImpl {
	@Override
	public <C extends ReflectiveConfig> C create(String family, String id, Class<C> configCreatorClass) {
		return ForgeWrapper.create(family, id, configCreatorClass);
	}

	@Override
	public ConfigEnvironment getConfigEnvironment() {
		return ForgeWrapper.getConfigEnvironment();
	}
}
