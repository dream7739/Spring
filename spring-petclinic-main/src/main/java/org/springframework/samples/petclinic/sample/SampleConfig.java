package org.springframework.samples.petclinic.sample;

import javassist.tools.rmi.Sample;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SampleConfig {

	// 직접 Bean으로 등록
	// Configuration Annotation사용하지 않아도 Bean으로 등록
	@Bean
	public SampleController sampleController() {
		return new SampleController();
	}

}
