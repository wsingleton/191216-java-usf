package com.revature;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	
	@Bean
	public ServletRegistrationBean<?> messageDispatcherServlet(ApplicationContext ctx) {
		MessageDispatcherServlet msgDispatcherServlet = new MessageDispatcherServlet();
		msgDispatcherServlet.setApplicationContext(ctx);
		msgDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(msgDispatcherServlet, "/flash-cards/*");
	}

	@Bean(name="flashCardService")
	public DefaultWsdl11Definition defaultWsdlDef(XsdSchema cardServiceDetails) {
		DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
		wsdl.setPortTypeName("flashCardPort");
		wsdl.setLocationUri("/flash-cards");
		wsdl.setTargetNamespace("http://revature.com");
		wsdl.setSchema(cardServiceDetails);
		return wsdl;
	}
	
	@Bean
	public XsdSchema cardsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("flash-cards.xsd"));
	}
	
}
