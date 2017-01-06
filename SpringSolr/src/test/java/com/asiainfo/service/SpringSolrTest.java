package com.asiainfo.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.pojo.SolrTest;
import com.asiainfo.pojo.User;

/**
 * 
 * @项目名称：spring-solr
 * @类名称：SpringSolrTest
 * @类描述：测试类
 * @创建人：millery
 * @创建时间：2015年11月5日 上午10:56:06
 * @version：
 */
public class SpringSolrTest {

	private SpringSolr springSolr;

	@Before
	public void setUp() throws Exception {
		// 初始化Spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml", "applicationContext-solr.xml");

		// 获取对象
		this.springSolr = applicationContext.getBean(SpringSolr.class);
	}

	@Test
	public void getUserTest() throws SolrServerException, IOException {

		// 测试方法，输出结果
		User user = springSolr.getUser((long) 1);
		System.out.println(user);
	}
	
	@Test
	public void getSolrTest() throws SolrServerException, IOException {

		// 测试方法，输出结果
		List<SolrTest> solrTests = springSolr.getSolrTest((long) 1);
		System.out.println(solrTests.toString());
	}

}