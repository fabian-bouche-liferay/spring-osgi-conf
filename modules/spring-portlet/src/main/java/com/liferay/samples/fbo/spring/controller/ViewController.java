package com.liferay.samples.fbo.spring.controller;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.portletmvc4spring.bind.annotation.RenderMapping;
import com.liferay.samples.fbo.some.configuration.SomeConfiguration;
import com.liferay.samples.fbo.spring.dto.MyModel;

import javax.portlet.RenderRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("VIEW")
public class ViewController {

	@RenderMapping
	public String render(RenderRequest request, @ModelAttribute("myModel") MyModel myModel) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		try {
			SomeConfiguration someConfiguration = ConfigurationProviderUtil.getCompanyConfiguration(SomeConfiguration.class, companyId);
			myModel.setFoo(someConfiguration.foo());
		} catch (ConfigurationException e) {
			LOG.error("Failed to access configuration", e);
		}
		return "view";
	}
	
	private final static Logger LOG = LoggerFactory.getLogger(ViewController.class);
	
}
