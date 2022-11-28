package com.newtouch.jemter.config;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.config.gui.AbstractConfigGui;
import org.apache.jmeter.gui.TestElementMetadata;
import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.property.StringProperty;
import org.apache.jmeter.util.JMeterUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pei hao on 2022/11/26.
 */

@TestElementMetadata(
        labelResource = "phsamplerconfig_default"
)
public class PhSamplerConfig extends AbstractConfigGui {
    private static final long serialVersionUID = 240L;
    private final JTextField a1;
    private final JTextField a2;
    private final JTextField a3;
    private final JTextField a4;
    private boolean displayName;

    public PhSamplerConfig() {
        this(true);
    }

    public PhSamplerConfig(boolean displayName) {
       // this.password = new JPasswordField(15);
        this.a1 = new JTextField(15);
        this.a2 = new JTextField(15);
        this.a3 = new JTextField(15);
        this.a4 = new JTextField(15);
        this.displayName = true;
        this.displayName = displayName;
        this.init();
    }

    public String getLabelResource() {
        return "phsamplerconfig_default";
    }

    public void configure(TestElement element) {
        super.configure(element);
        this.a1.setText(element.getPropertyAsString("PhSampler.a1"));
        this.a2.setText(element.getPropertyAsString("PhSampler.a2"));
        this.a3.setText(element.getPropertyAsString("PhSampler.a3"));
        this.a4.setText(element.getPropertyAsString("PhSampler.a4"));
    }

    //创建测试元素
    public TestElement createTestElement() {
        ConfigTestElement element = new ConfigTestElement();
        this.modifyTestElement(element);
        return element;
    }

    public void modifyTestElement(TestElement element) {
        this.configureTestElement(element);
//        element.setProperty(new StringProperty("ConfigTestElement.username", this.username.getText()));
//        String passwordString = new String(this.password.getPassword());
//        element.setProperty(new StringProperty("ConfigTestElement.password", passwordString));
        element.setProperty(new StringProperty("PhSampler.a1", this.a1.getText()));
        element.setProperty(new StringProperty("PhSampler.a2", this.a2.getText()));
        element.setProperty(new StringProperty("PhSampler.a3", this.a3.getText()));
        element.setProperty(new StringProperty("PhSampler.a4", this.a4.getText()));
    }

    public void clearGui() {
        super.clearGui();
        this.a1.setText("");
        this.a2.setText("");
        this.a3.setText("");
        this.a4.setText("");
    }

    private void init() {
        this.setLayout(new BorderLayout(0, 5));
        if(this.displayName) {
            this.setBorder(this.makeBorder());
            this.add(this.makeTitlePanel(), "North");
        }

        VerticalPanel mainPanel = new VerticalPanel();
        mainPanel.add(this.createA1());
        mainPanel.add(this.createA2());
        mainPanel.add(this.createA3());
        mainPanel.add(this.createA4());
        this.add(mainPanel, "Center");
    }


    private JPanel createA1() {
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        JLabel label = new JLabel(JMeterUtils.getResString("a1"));
        label.setLabelFor(this.a1);
        panel.add(label, "West");
        panel.add(this.a1, "Center");
        return panel;
    }
    private JPanel createA2() {
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        JLabel label = new JLabel(JMeterUtils.getResString("a2"));
        label.setLabelFor(this.a2);
        panel.add(label, "West");
        panel.add(this.a2, "Center");
        return panel;
    }

    private JPanel createA3() {
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        JLabel label = new JLabel(JMeterUtils.getResString("a3"));
        label.setLabelFor(this.a3);
        panel.add(label, "West");
        panel.add(this.a3, "Center");
        return panel;
    }
    private JPanel createA4() {
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        JLabel label = new JLabel(JMeterUtils.getResString("a4"));
        label.setLabelFor(this.a4);
        panel.add(label, "West");
        panel.add(this.a4, "Center");
        return panel;
    }
}
