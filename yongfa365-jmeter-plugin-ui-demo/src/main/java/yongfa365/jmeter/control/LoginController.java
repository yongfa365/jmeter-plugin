package yongfa365.jmeter.control;

import org.apache.jmeter.control.GenericController;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.testelement.ThreadListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class LoginController extends GenericController implements Serializable, ThreadListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    // property name
    public static final String USER_NAME = "yongfa365.ui.demo.UserName";
    public static final String PASSWORD = "yongfa365.ui.demo.Password";
    public static final String REMEMBER = "yongfa365.ui.demo.Remember";
    public static final String REMARK = "yongfa365.ui.demo.Remark";
    public static final String SYNTAX = "yongfa365.ui.demo.Syntax";


    @Override
    public Sampler next() {
        if (isFirst()) {
            if (!getPropertyAsString(USER_NAME).isEmpty() && getPropertyAsBoolean(REMEMBER)) {
                LOGGER.info("登录成功");
                return super.next();
            }
            LOGGER.info("登录失败：用户名 与 记住密码 必须输入才能继续");
        }
        return null;
    }

    @Override
    public void threadStarted() {

    }

    @Override
    public void threadFinished() {

    }


}