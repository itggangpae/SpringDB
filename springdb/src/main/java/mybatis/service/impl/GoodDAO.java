package mybatis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import mybatis.domain.Good;

public class GoodDAO {
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/*
	public List<Good> getList(){
		return sqlSession.selectList("good.allgood");
	}
	
	public Good codeSearch(int code){
		return sqlSession.selectOne("good.codesearch", code);
	}
	*/
	
	public List<Good> getList(){
		Map<String,Object> map = new HashMap<String,Object>();
		sqlSession.selectList("good.allgood", map);
		List<Good> list = (List<Good>)map.get("vcursor");
		return list;
	}

	public Good codeSearch(int code){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("vcode", code);
		sqlSession.selectList("good.codesearch", map);
		List<Good> list = (List<Good>)map.get("vcursor");
		return list.get(0);
	}

	
	public int insertGood(Good good){
		return sqlSession.insert("insertgood", good);
	}

	public int deleteGood(int code){
		return sqlSession.delete("good.deletegood", code);
	}
	public int updateGood(Good good) {
		return sqlSession.update("updategood", good);
	}


}