package yongfa365.jmeter.control.gui;


import org.apache.jmeter.control.gui.AbstractControllerGui;
import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.testbeans.gui.TextAreaEditor;
import org.apache.jmeter.testelement.TestElement;
import yongfa365.jmeter.control.GuiUtil;
import yongfa365.jmeter.control.LoginController;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;


public class LoginControllerGui extends AbstractControllerGui {
    private static final long serialVersionUID = 2412L;

    private JTextField txtUserName;
    private JTextField txtPassword;
    private JCheckBox chkRemember;
    private JTextPane txtRemark;
    private TextAreaEditor txtSyntax;

    @Override
    public String getStaticLabel() {
        return "Login Controller";
    }

    @Override
    public String getLabelResource() {
        return null;
    }

    @Override
    public TestElement createTestElement() {
        LoginController lc = new LoginController();
        modifyTestElement(lc);
        return lc;
    }

    @Override
    public void modifyTestElement(TestElement element) {
        configureTestElement(element);
        if (element instanceof LoginController) {
            LoginController obj = (LoginController) element;

            obj.setProperty(LoginController.USER_NAME,txtUserName.getText());
            obj.setProperty(LoginController.PASSWORD,txtPassword.getText());
            obj.setProperty(LoginController.REMEMBER,chkRemember.isSelected());
            obj.setProperty(LoginController.REMARK,txtRemark.getText());
            obj.setProperty(LoginController.SYNTAX,txtSyntax.getAsText());
        }
    }

    @Override
    public void configure(TestElement element) {
        txtUserName.setText(element.getPropertyAsString(LoginController.USER_NAME));
        txtPassword.setText(element.getPropertyAsString(LoginController.PASSWORD));
        chkRemember.setSelected(Boolean.parseBoolean(element.getPropertyAsString(LoginController.REMEMBER)));
        txtRemark.setText(element.getPropertyAsString(LoginController.REMARK));
        txtSyntax.setAsText(element.getPropertyAsString(LoginController.SYNTAX));

        super.configure(element);
    }

    public LoginControllerGui() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout(0, 5));
        setBorder(makeBorder());
        add(makeTitlePanel(), BorderLayout.NORTH);
        add(createBodyPanel(), BorderLayout.CENTER);
    }

    private JPanel createBodyPanel() {
        final JPanel bodyPanel = new JPanel(new GridBagLayout());

        // 用户名：TextBox
        {
            txtUserName = new JTextField();
            JLabel label1 = new JLabel("用户名：");
            label1.setLabelFor(txtUserName);

            bodyPanel.add(label1, GuiUtil.GridBag.labelConstraints);
            bodyPanel.add(txtUserName, GuiUtil.GridBag.editorConstraints);
        }

        // 密码：TextBox
        {
            txtPassword = new JTextField();
            JLabel label1 = new JLabel("密码：");
            label1.setLabelFor(txtPassword);

            bodyPanel.add(label1, GuiUtil.GridBag.labelConstraints);
            bodyPanel.add(txtPassword, GuiUtil.GridBag.editorConstraints);
        }

        // 记住密码：CheckBox
        {
            chkRemember = new JCheckBox();
            JLabel label1 = new JLabel("记住密码：");
            label1.setLabelFor(chkRemember);

            bodyPanel.add(label1, GuiUtil.GridBag.labelConstraints);
            bodyPanel.add(chkRemember, GuiUtil.GridBag.editorConstraints);
        }

        // 备注：多行文本
        {
            txtRemark = new JTextPane();
            StyledDocument doc = txtRemark.getStyledDocument();
            SimpleAttributeSet arrSet = new SimpleAttributeSet();
            StyleConstants.setFontFamily(arrSet, "新宋体");
            StyleConstants.setFontSize(arrSet, 12);

            doc.setCharacterAttributes(0, doc.getLength(), arrSet, true);
            txtRemark.setCharacterAttributes(arrSet, false);

            txtRemark.setPreferredSize(new Dimension(0, 80));

            JLabel label1 = new JLabel("备注：");
            label1.setLabelFor(txtRemark);

            bodyPanel.add(label1, GuiUtil.GridBag.labelConstraints);
            bodyPanel.add(txtRemark, GuiUtil.GridBag.editorConstraints);
        }

        // 一行长标签，一行多列的语法高亮的输入框
        {
            txtSyntax = new TextAreaEditor();
            Component component = txtSyntax.getCustomEditor();

            JLabel label1 = new JLabel("语法高亮的，有行号的输入框");
            label1.setLabelFor(component);

            bodyPanel.add(label1, GuiUtil.GridBag.allLineConstraints);
            bodyPanel.add(component, GuiUtil.GridBag.allLineConstraints);
        }

        VerticalPanel mainPanel = new VerticalPanel();
        mainPanel.add(bodyPanel);
        return mainPanel;
    }


}
