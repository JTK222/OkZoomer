package io.github.ennuil.ok_zoomer.wrench_wrapper;

import org.jetbrains.annotations.ApiStatus;
import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.implementor_api.ConfigEnvironment;

import java.util.ServiceLoader;

public class WrenchWrapper {

	private static final WrenchWrapperImpl INSTANCE = ServiceLoader.load(WrenchWrapperImpl.class).findFirst().orElseThrow(() -> new IllegalStateException("Could not find a platform implementation for WrenchWrapper!"));

	public static <C extends ReflectiveConfig> C create(String family, String id, Class<C> configCreatorClass) {
		return INSTANCE.create(family, id, configCreatorClass);
	}

	public static ConfigEnvironment getConfigEnvironment() {
		return INSTANCE.getConfigEnvironment();
	}

	@ApiStatus.Internal
	public static Class<?> getClass(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
}
