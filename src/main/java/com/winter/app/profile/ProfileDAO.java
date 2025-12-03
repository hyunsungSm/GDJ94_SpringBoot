package com.winter.app.profile;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfileDAO {

	public int insert(ProfileDTO profileDTO)throws Exception;
}
