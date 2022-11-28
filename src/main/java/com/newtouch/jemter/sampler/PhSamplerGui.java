package com.newtouch.jemter.sampler;

import com.newtouch.jemter.config.PhSamplerConfig;
import com.newtouch.jemter.control.PhSampler;
import org.apache.jmeter.gui.TestElementMetadata;
import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.util.JMeterUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pei hao on 2022/11/26.
 */


@TestElementMetadata(
        labelResource = "sampler_test"
)
public class PhSamplerGui extends AbstractSamplerGui {

    private static final long serialVersionUID = 240L;

    private PhSamplerConfig loginPanel;

    //private FtpConfigGui ftpDefaultPanel;

    public PhSamplerGui() {
        this.init();
    }
    public String getLabelResource() {
        return "sampler_test";
    }

    public void configure(TestElement element) {
        super.configure(element);
        this.loginPanel.configure(element);
        //this.ftpDefaultPanel.configure(element);
    }

    //进入control
    public TestElement createTestElement() {
        PhSampler sampler = new PhSampler();
        this.modifyTestElement(sampler);
        return sampler;
    }

    public void modifyTestElement(TestElement sampler) {
        sampler.clear();
        this.loginPanel.modifyTestElement(sampler);
        super.configureTestElement(sampler);
    }

    public void clearGui() {
        super.clearGui();
        this.loginPanel.clearGui();
    }

    private void init() {
        this.setLayout(new BorderLayout(0, 5));
        this.setBorder(this.makeBorder());
        this.add(this.makeTitlePanel(), "North");
        VerticalPanel mainPanel = new VerticalPanel();
        this.loginPanel = new PhSamplerConfig(false);
        this.loginPanel.setBorder(BorderFactory.createTitledBorder(JMeterUtils.getResString("login_config")));
        mainPanel.add(this.loginPanel);
        this.add(mainPanel, "Center");
    }

}
