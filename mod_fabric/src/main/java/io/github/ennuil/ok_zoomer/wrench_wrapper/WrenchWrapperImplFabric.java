package io.github.ennuil.ok_zoomer.wrench_wrapper;

import com.google.auto.service.AutoService;
import org.quiltmc.config.api.ReflectiveConfig;
import org.quiltmc.config.implementor_api.ConfigEnvironment;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@AutoService(WrenchWrapperImpl.class)
public class WrenchWrapperImplFabric implements WrenchWrapperImpl {

	private static final String IMPLEMENTATION_CLASS = WrenchWrapper.getClass("org.quiltmc.loader.api.QuiltLoader") != null
		? "io.github.ennuil.ok_zoomer.wrench_wrapper.quilt.QuiltWrapper"
		: "io.github.ennuil.ok_zoomer.wrench_wrapper.fabric.FabricWrapper";

	@SuppressWarnings("unchecked")
	@Override
	public <C extends ReflectiveConfig> C create(String family, String id, Class<C> configCreatorClass) {
		try {
			var clazz = Objects.requireNonNull(WrenchWrapper.getClass(IMPLEMENTATION_CLASS));
			return (C) clazz.getMethod("create", String.class, String.class, Class.class).invoke(null, family, id, configCreatorClass);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			throw new IllegalStateException("How did you do this!!!!! " + e);
		}
	}

	@Override
	public ConfigEnvironment getConfigEnvironment() {
		try {
			var clazz = Objects.requireNonNull(WrenchWrapper.getClass(IMPLEMENTATION_CLASS));
			return (ConfigEnvironment) clazz.getMethod("getConfigEnvironment").invoke(null);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			throw new IllegalStateException("How did you do this!!!!! " + e);
		}
	}
}
