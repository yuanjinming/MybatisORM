package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.mybatis.Pager;
import common.mybatis.SubWhereOperator;
import common.mybatis.SubWhereType;
import common.mybatis.WhereClause;
import dao.Impl.PmsUserDaoImpl;
import dao.model.PmsUser;


public class testservice {
	
	private PmsUserDaoImpl pmsUserDao;
	

	
	public PmsUserDaoImpl getPmsUserDao() {
		return pmsUserDao;
	}

	public void setPmsUserDao(PmsUserDaoImpl pmsUserDao) {
		this.pmsUserDao = pmsUserDao;
	}


	public String add(){
		PmsUser pu1=new PmsUser();
		pu1.setUserNo("fff1");
		pu1.setUserType("1");
		pu1.setUserPwd("123456");
		pu1.setUserName("呵呵呵呵");
		pu1.setMobileNo("33333");
		pu1.setStatus(100);
		PmsUser pu2=new PmsUser();
		pu2.setUserNo("fff2");
		pu2.setUserType("1");
		pu2.setUserPwd("123456");
		pu2.setUserName("呵呵呵呵");
		pu2.setMobileNo("33333");
		pu2.setStatus(100);
		PmsUser pu3=new PmsUser();
		pu3.setUserNo("fff3");
		pu3.setUserType("1");
		pu3.setUserPwd("123456");
		pu3.setUserName("呵呵呵呵");
		pu3.setMobileNo("33333");
		pu3.setStatus(100);
		List<PmsUser> pulist=new ArrayList<>();
		pulist.add(pu1);
		pulist.add(pu2);
		pulist.add(pu3);
		pmsUserDao.add(pulist);
		return "ok";
	}


	public String delete(){
		pmsUserDao.delete((long)17,(long)18);
		return "ok";
	}

	public String delete2(){
		List<Long> ids=new ArrayList<Long>();
		ids.add((long)22);
		ids.add((long)23);
		pmsUserDao.delete(ids);
		return "ok";
	}
	
	public String deleteby(){
		WhereClause wc=new WhereClause();
		wc.add(PmsUser.DB.userNo,"ff",SubWhereOperator.LIKE);
		pmsUserDao.deleteBy(wc);
		return "ok";
	}
	
	public String update(){
		PmsUser pu1=new PmsUser();
		pu1.setId((long)46);
		pu1.setVersion(46);
		return "ok";
	}
	
	public PmsUser get(){
		PmsUser pu=pmsUserDao.get((long)46);
		return pu;
	}
	
	public Object getList(){
		WhereClause wc=new WhereClause();
		wc.add(PmsUser.DB.userType,1,SubWhereOperator.GREATER);
		List<PmsUser> pulist=pmsUserDao.getList(wc);
		return pulist;
	}
	
	
	public Object getALL(){
		List<PmsUser> pulist=pmsUserDao.getAll();
		return pulist;
	}
	
	public Object getALLORDREBY(){
		List<PmsUser> pulist=pmsUserDao.getAll(PmsUser.DB.createTime+" desc");
		return pulist;
	}
	
	public Object runsql(){
		List<PmsUser> pulist=(List<PmsUser>) pmsUserDao.runSql("select * from edu_edmo_pms_user");
		return pulist;
	}
	
	public Object runsql2(){
		String sql=PmsUser.DB.userType+" = "+2;
		WhereClause wc=new WhereClause();
		wc.add(PmsUser.DB.id,sql,SubWhereOperator.SUB_SQL);
		List<PmsUser> pulist=pmsUserDao.getList(wc);
		return pulist;
	}
	
	public Object get2(){
		PmsUser pu=(PmsUser) pmsUserDao.get(PmsUser.DB.status,101);
		return pu;
	}
	
	public Object getpage(){
		String sql=PmsUser.DB.userType+" = "+1;
		WhereClause wc=new WhereClause();
		wc.add(PmsUser.DB.id,sql,SubWhereOperator.SUB_SQL);
		Pager<PmsUser> pager=pmsUserDao.getPage(wc, 1, 2);
		return pager;
	}
}
