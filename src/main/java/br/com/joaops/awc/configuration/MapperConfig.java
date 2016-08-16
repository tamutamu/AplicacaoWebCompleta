/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.joaops.awc.configuration;

import br.com.joaops.awc.dozer.converter.LocaleConverter;
import br.com.joaops.awc.dozer.converter.TimeZoneConverter;
import br.com.joaops.awc.dozer.converter.URLConverter;
import br.com.joaops.awc.dozer.converter.UUIDConverter;
import java.util.ArrayList;
import java.util.List;
import org.dozer.CustomConverter;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author João
 */
@Configuration
public class MapperConfig {
    
    @Bean
    public List<CustomConverter> getCustomConverters() {
        List<CustomConverter> converters = new ArrayList<>();
        converters.add(new LocaleConverter());
        converters.add(new TimeZoneConverter());
        converters.add(new URLConverter());
        converters.add(new UUIDConverter());
        return converters;
    }
    
    @Bean
    public DozerBeanMapperFactoryBean mapper() {
        DozerBeanMapperFactoryBean mapper = new DozerBeanMapperFactoryBean();
        mapper.setCustomConverters(getCustomConverters());
        return mapper;
    }
    
}