package com.cloud.setting.Dao;

import com.cloud.setting.Entity.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: suxinyu
 * @DateTme: 2019/11/27 21:47
 */
@Repository
public interface NoticeMapper {
    int addNotice(Notice notice);

    List<Notice> noticeList(String enprNo);

    int uptNotice(Notice notice);

    int delNotice(@Param("id") int id);
}
