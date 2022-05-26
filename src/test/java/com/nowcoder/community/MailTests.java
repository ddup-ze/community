package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        mailClient.sendMail("2535338888@qq.com", "拼多多邀请你参加在线笔试【请务必在5月26日16点前确认是否参加】", "亲爱的刘倬良\n" +
                "感谢投递拼多多，现邀请你参加在线技术笔试，笔试结果将作为进入面试的重要筛选条件。\n" +
                "关于笔试如有疑问可先在官网查看相关答疑，https://careers.pinduoduo.com/campus/intern/question\n" +
                "\n" +
                "若遇到笔试岗位与投递岗位不符等异常情况，请将你的“姓名+岗位+邮箱+手机号+详细问题描述”\n" +
                "发送邮件到pddcampus@pinduoduo.com反馈，我们收到后将尽快与你联系；\n" +
                "\n" +
                "\n" +
                "请注意：本次笔试为23届暑期实习生项目的最后一次笔试机会，请尽量协调时间参加笔试，祝笔试顺利！\n" +
                "\n" +
                "\n" +
                "考试过程需全程开启摄像头，请提前准备带摄像头的电脑，下载最新版Chrome浏览器。\n" +
                "如您因故无法参加本场考试，视为自动放弃。\n" +
                "点击确认是否参加考试\n" +
                "\n" +
                "笔试信息\n" +
                "试卷名称：2023届暑期实习生笔试--服务端5\n" +
                "考试时间：(北京时间,UTC+08:00)2022年-05-26 19:00:00 -- 21:00:00\n" +
                "考试时长：120分钟\n" +
                "考试地址：https://exam.nowcoder.com/cts/17203531/summary?id=65BEC75D43C108175D2B1AAD67C4DCC3 （考试地址为你的私人专属地址，请勿转发。如无法直接打开，请拷贝完整链接并粘贴至浏览器地址栏，建议提前15分钟打开链接进行考试信息核对、调试设备等考前准备工作）\n");
    }

    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "郑玮泽");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

        mailClient.sendMail("407029736@qq.com", "HTML", content);
    }

}
