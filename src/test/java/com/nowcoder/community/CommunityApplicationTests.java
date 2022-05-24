package com.nowcoder.community;

import com.nowcoder.community.service.TestService;
import com.nowcoder.community.dao.TestDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			this.applicationContext=applicationContext;
	}
	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);
		TestDao testDao=applicationContext.getBean(TestDao.class);
		System.out.println(testDao.select());
		TestDao testDao1=applicationContext.getBean("hiber",TestDao.class);
		System.out.println(testDao1.select());

	}
	@Test
	public void testbean(){
		TestService testService=applicationContext.getBean(TestService.class);
		System.out.println(testService);
	}

	@Test
	public void testconfig(){
		SimpleDateFormat simpleDateFormat =applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired
	@Qualifier("hiber")
	private TestDao testDao;
	@Test
	public void testDI(){
		System.out.println(testDao.select());

	}
}
