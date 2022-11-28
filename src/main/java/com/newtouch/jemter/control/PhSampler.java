package com.newtouch.jemter.control;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.Interruptible;
import org.apache.jmeter.samplers.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pei hao on 2022/11/26.
 */
public class PhSampler extends AbstractSampler implements Interruptible {
    private static final long serialVersionUID = 240L;
    private static final Logger log = LoggerFactory.getLogger(PhSampler.class);
    private static final Set<String> APPLIABLE_CONFIG_CLASSES = new HashSet(Arrays.asList(new String[]{
            "com.newtouch.jemter.control.PhSamplerConfig",
            "com.newtouch.jemter.control.PhSamplerGui",
            "org.apache.jmeter.config.gui.SimpleConfigGui"}));



    public static final String a1 = "PhSampler.a1";
    public static final String a2 = "PhSampler.a2";
    public static final String a3 = "PhSampler.a3";
    public static final String a4 = "PhSampler.a4";



    public  String getA1() {
        return this.getPropertyAsString("PhSampler.a1");
    }
    public  String getA2() {
        return this.getPropertyAsString("PhSampler.a2");
    }
    public  String getA3() {
        return this.getPropertyAsString("PhSampler.a3");
    }
    public  String getA4() {
        return this.getPropertyAsString("PhSampler.a4");
    }


    public SampleResult sample(Entry entry) {
        log.info("===============getA1==========="+ this.getA1());
        log.info("===============getA2=========="+ this.getA2());
        log.info("===============getA3==========="+ this.getA3());
        log.info("===============getA4=========="+ this.getA4());
        SampleResult res = new SampleResult();
        res.setSuccessful(true);
        res.setSampleLabel("202");
        res.setSamplerData("666");
        res.setResponseData(getA1(),"UTF-8");
        return res;
    }

    public boolean applies(ConfigTestElement configElement) {
        String guiClass = configElement.getProperty("TestElement.gui_class").getStringValue();
        return APPLIABLE_CONFIG_CLASSES.contains(guiClass);
    }

    public boolean interrupt() {
        return false;
    }
}
