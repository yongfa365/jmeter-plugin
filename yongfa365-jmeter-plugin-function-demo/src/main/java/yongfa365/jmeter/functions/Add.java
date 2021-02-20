package yongfa365.jmeter.functions;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Add extends AbstractFunction {
    private static final Logger LOGGER = LoggerFactory.getLogger(Add.class);
    private static final List<String> DESC = new ArrayList<>();
    private static final String KEY = "__Add2";
    private Object[] values = null;

    static {
        DESC.add("整数a");
        DESC.add("整数b");
    }

    /**
     * 在 Function Helper 中显示的自定义的函数名
     */
    @Override
    public String getReferenceKey() {
        return KEY;
    }

    /**
     * 在 Function Helper 中显示的每个参数的描述
     */
    @Override
    public List<String> getArgumentDesc() {
        return DESC;
    }

    @Override
    public void setParameters(Collection<CompoundVariable> parameters) {
        //检查参数数量，但不知为何不满足时不报错
        //checkMinParameterCount(parameters, 1);
        //checkParameterCount(parameters, 1, 1);
        values = parameters.toArray();
    }


    @Override
    public String execute(SampleResult previousResult, Sampler currentSampler) {
        LOGGER.info("============ execute 这个日志可以在Jmeter的UI的 感叹号图标点击后的日志里看===========");
        int a = Integer.parseInt(((CompoundVariable) values[0]).execute().trim());
        int b = Integer.parseInt(((CompoundVariable) values[1]).execute().trim());

        return String.valueOf(add(a, b));
    }


    private int add(int a, int b) {
        return a + b;
    }
}