package io.github.ennuil.ok_zoomer.wrench_wrapper.quilt;

import org.quiltmc.config.api.ReflectiveConfig;

import java.lang.reflect.InvocationTargetException;

public class QuiltStub {
	@SuppressWarnings("unchecked")
	public static <C extends ReflectiveConfig> C create(String family, String id, Class<C> configCreatorClass) {
		try {
			var clazz = Class.forName("org.quiltmc.loader.api.config.v2.QuiltConfig");
			return (C) clazz.getMethod("create", String.class, String.class, Class.class).invoke(null, family, id, configCreatorClass);
		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			return null;
		}
	}
}
