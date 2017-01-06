package com.asiainfo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asiainfo.pojo.SolrTest;
import com.asiainfo.pojo.User;

/**
 * 
 * @项目名称：spring-solr
 * @类名称：SpringSolrTest
 * @类描述：测试类
 * @创建人：millery
 * @创建时间：2015年11月5日 上午10:48:57
 * @version：
 */
@Component
public class SpringSolr {

	@Autowired
	private HttpSolrServer httpSolrServer;

	public User getUser(Long id) throws SolrServerException, IOException {

		// 创建查询条件
		SolrQuery query = new SolrQuery();
		query.setQuery("id:" + id);

		// 查询并返回结果
		QueryResponse queryResponse = this.httpSolrServer.query(query);
		return (User) queryResponse.getBeans(User.class);
	}
	
	public List<SolrTest> getSolrTest(Long id) throws SolrServerException, IOException {
//		String queryStr = "*:*";
//        SolrQuery params = new SolrQuery(queryStr);
//        params.set("rows", 10);
//        QueryResponse response = null;
//        try {
//            response = this.httpSolrServer.query(params);
//            SolrDocumentList list = response.getResults();
//            System.out.println("########### 总共 ： " + list.getNumFound() + "条记录");
//            for (SolrDocument doc : list) {
//                System.out.println("######### id : " + doc.get("id") + "  title : " + doc.get("title"));
//            }
//        } catch (SolrServerException e) {
//            System.err.print(e);
//        }
//        return (SolrTest)response.getBeans(SolrTest.class);
		// 创建查询条件
		SolrQuery query = new SolrQuery();
		query.setQuery("id:" + id);

		// 查询并返回结果
		QueryResponse queryResponse = this.httpSolrServer.query(query);
		SolrDocumentList list = queryResponse.getResults();
		List<SolrTest> solrTests = new ArrayList<SolrTest>();
		for (SolrDocument doc : list) {
			SolrTest solrTest = new SolrTest();
			solrTest.setId(Long.parseLong(doc.get("id").toString()));
			solrTest.setSubject(doc.get("subject").toString());
			solrTest.setContent(doc.get("content").toString());
//			solrTest.setLast_update_time(doc.get("content").toString());
			solrTests.add(solrTest);
      }
		return solrTests;
	}
}
