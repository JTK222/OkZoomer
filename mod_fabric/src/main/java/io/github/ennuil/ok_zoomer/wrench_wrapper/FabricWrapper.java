package io.github.ennuil.ok_zoomer.wrench_wrapper;

import com.google.auto.service.AutoService;
import io.github.ennuil.ok_zoomer.wrench_wrapper.fabric.FabricStub;
import io.github.ennuil.ok_zoomer.wrench_wrapper.quilt.QuiltStub;
import org.quiltmc.config.api.ReflectiveConfig;

@AutoService(WrenchWrapper.class)
public class FabricWrapper extends WrenchWrapper {

	private static final boolean QUILT = isRunningOnQuiltLoader();

	@Override
	protected <C extends ReflectiveConfig> C createConfig(String family, String id, Class<C> configCreatorClass) {
		if (QUILT) {
			return QuiltStub.create(family, id, configCreatorClass);
		}

		return FabricStub.create(family, id, configCreatorClass);
	}

	private static boolean isRunningOnQuiltLoader() {
		try {
			Class.forName("org.quiltmc.loader.api.QuiltLoader");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}
