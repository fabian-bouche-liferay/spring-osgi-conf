package com.liferay.samples.fbo.some.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
		category = "third-party", scope = ExtendedObjectClassDefinition.Scope.COMPANY
	)
@Meta.OCD(
	    id = "com.liferay.samples.fbo.some.configuration.SomeConfiguration",
	    localization = "content/Language", name = "some-configuration-name"
	)
public interface SomeConfiguration {

	@Meta.AD(deflt = "", name = "some-configuration-foo", required = false)
	public String foo();
	
}