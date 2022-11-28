package com.newtouch.jemter.rquire;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.log4j.Logger;

/**
 * Created by 86183 on 2021/3/26.
 */
public class JemterRequireTest implements JavaSamplerClient {

    private static final Logger logger = Logger.getLogger(JemterRequireTest.class);
    private String url1 = "url1";


    //runTest之前执行
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        String ip = javaSamplerContext.getJMeterVariables().get("ip");
        logger.info("ip is========================" + ip);
    }

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult sa = new SampleResult();
        String text = "执行完成";
        sa.setResponseData(text,"UTF-8");
        sa.setDataType(SampleResult.TEXT);
        sa.setSuccessful(true);
        sa.setSampleLabel("200");
        javaSamplerContext.getJMeterVariables().put("ip","6666");
        return sa;
    }

    //runTest之后执行
    public void teardownTest(JavaSamplerContext javaSamplerContext) {
        logger.info("ip1 is ==================>end" );
    }

    /**
     * jemter页面现实的参数列表
     * @return 将对象返回出去
     */
    public Arguments getDefaultParameters() {
        Arguments ars =  new Arguments();
        ars.addArgument(url1,"http://www.baidu.com");
        return ars;
    }
}
