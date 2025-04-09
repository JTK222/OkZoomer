package io.github.ennuil.ok_zoomer.wrench_wrapper;

import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.implementor_api.ConfigEnvironment;

public interface WrenchWrapperImpl {

	<C extends ReflectiveConfig> C create(String family, String id, Class<C> configCreatorClass);

	ConfigEnvironment getConfigEnvironment();
}
