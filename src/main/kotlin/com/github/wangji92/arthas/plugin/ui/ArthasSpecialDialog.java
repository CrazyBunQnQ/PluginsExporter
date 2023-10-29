package com.github.wangji92.arthas.plugin.ui;

import com.github.wangji92.arthas.plugin.utils.ActionLinkUtils;
import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.components.AnActionLink;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * arthas 特殊用法
 *
 * @author 汪小哥
 * @date 22-12-2019
 */
public class ArthasSpecialDialog extends JDialog {
    private AnActionLink specialOgnlLinkLabel;
    private AnActionLink ttGetSpringContextLinkLabel;
    private AnActionLink errorFilterLinkLabel;
    private AnActionLink dubboArthasLinkLabel;
    private AnActionLink redefineLinLabel;
    private JPanel contentPane;
    private AnActionLink ognlUseLinkLabel;
    private AnActionLink userCase;
    private AnActionLink tt;
    private AnActionLink conditionArthas;
    private AnActionLink watchSpringContext;
    private AnActionLink asyncExample;
    private AnActionLink arthasBestUnderStand;
    private AnActionLink arthasJprofileLink;
    private AnActionLink springAopTarget;
    private AnActionLink arthasVersionLink;

    private Project project;

    public ArthasSpecialDialog(Project project) {
        this.project = project;
        setContentPane(this.contentPane);
        setModal(false);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


    }

    /**
     * 关闭
     */
    private void onCancel() {
        dispose();
    }

    private void createUIComponents() {
        specialOgnlLinkLabel = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://github.com/alibaba/arthas/issues/71");
            }
        });
        ttGetSpringContextLinkLabel = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://github.com/alibaba/arthas/issues/482");
            }
        });
        errorFilterLinkLabel = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://github.com/alibaba/arthas/issues/429");
            }
        });
        dubboArthasLinkLabel = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("http://hengyunabc.github.io/dubbo-meet-arthas/");
            }
        });

        redefineLinLabel = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("http://hengyunabc.github.io/arthas-online-hotswap/");
            }
        });
        ognlUseLinkLabel = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://blog.csdn.net/u010634066/article/details/101013479");
            }
        });
        userCase = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://github.com/alibaba/arthas/issues?utf8=%E2%9C%93&q=+is%3Aissue+label%3Auser-case+");
            }
        });
        conditionArthas = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://github.com/WangJi92/arthas-idea-plugin/issues/6");
            }
        });
        tt = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://github.com/WangJi92/arthas-idea-plugin/issues/4");
            }
        });
        watchSpringContext = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://github.com/WangJi92/arthas-idea-plugin/issues/5");
            }
        });
        asyncExample = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://www.cnblogs.com/leihuazhe/p/11630466.html");
            }
        });
        arthasBestUnderStand = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://wangji.blog.csdn.net/article/details/106964278");
            }
        });
        arthasJprofileLink = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://github.com/alibaba/arthas/issues/1416");
            }
        });

        springAopTarget = new AnActionLink("", new AnAction() {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                BrowserUtil.browse("https://github.com/alibaba/arthas/issues/1424");
            }
        });

        arthasVersionLink = ActionLinkUtils.newActionLink("https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzkxNDI0ODE0NQ==&action=getalbum&album_id=1896318852766973955&scene=173&from_msgid=2247484030&from_itemidx=1&count=3&nolastread=1#wechat_redirect");

    }

    /**
     * 打开窗口
     */
    public void open() {
        setTitle("arthas special use");
        pack();
        setMinimumSize(new Dimension(378,242));
        //两个屏幕处理出现问题，跳到主屏幕去了 https://blog.csdn.net/weixin_33919941/article/details/88129513
        setLocationRelativeTo(WindowManager.getInstance().getFrame(this.project));
        setVisible(true);
    }
}
