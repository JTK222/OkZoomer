package io.github.ennuil.ok_zoomer.wrench_wrapper;

import org.quiltmc.config.api.ReflectiveConfig;

import java.util.ServiceLoader;

public abstract class WrenchWrapper {

	private static final WrenchWrapper INSTANCE = ServiceLoader.load(WrenchWrapper.class).findFirst().orElseThrow(() -> new IllegalStateException("Could not find a platform implementation for WrenchWrapper!"));

	public static <C extends ReflectiveConfig> C create(String family, String id, Class<C> configCreatorClass) {
		return INSTANCE.createConfig(family, id, configCreatorClass);
	}

	protected abstract <C extends ReflectiveConfig> C createConfig(String family, String id, Class<C> configCreatorClass);
}
