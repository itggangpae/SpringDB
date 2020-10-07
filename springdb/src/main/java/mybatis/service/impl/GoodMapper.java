package mybatis.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import mybatis.domain.Good;

@Repository
public interface GoodMapper {
	@Select("select * from goods")
	public List<Good> getList();
	
	@Select("select * from goods where code = #{code}")
	public Good codeSearch(int code);
	
	@Insert("insert into goods(code, name, manufacture, price) values(#{code}, #{name}, #{manufacture}, #{price})")
	public int insertGood(Good good);
	
	@Delete("delete from goods where code = #{code}")
	public int deleteGood(int code);
	
	@Update("update goods set name=#{name}, manufacture=#{manufacture}, price = #{price} where code = #{code}")
	public int updateGood(Good good);
}