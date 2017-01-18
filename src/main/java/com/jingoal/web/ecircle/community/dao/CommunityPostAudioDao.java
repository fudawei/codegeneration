package com.jingoal.web.ecircle.community.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

import com.jingoal.web.ecircle.community.model.CommunityPostAudio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Created by fudw.
 */
@Component
public class CommunityPostAudioDao {

  private static final String NAME_SPACE = "community_post_audio.";

  @Resource(name = "communitySessionTemplate")
  private SqlSessionTemplate sqlSessionTemplate;

  /**
   * Add  CommunityPostAudio
   * @param communitypostaudio obj to update
   */
  public void add(CommunityPostAudio communitypostaudio) {
    this.sqlSessionTemplate.insert(NAME_SPACE + "add", communitypostaudio);
  }

  /**
   * Update CommunityPostAudio
   * @param communitypostaudio obj to update
   */
  public void update(CommunityPostAudio communitypostaudio) {
    sqlSessionTemplate.update(NAME_SPACE + "update", communitypostaudio);
  }

  /**
   *  Update CommunityPostAudio
   * @param communitypostaudio obj to update
   */
  public void updatePropertys(CommunityPostAudio communitypostaudio) {
    sqlSessionTemplate.update(NAME_SPACE + "update", communitypostaudio);
  }


  /**
   * Delete by pk
   * @param id pk
   */
  public void del(Long id) {
    sqlSessionTemplate.update(NAME_SPACE + "del", id);
  }

  /**
   *  Get by pk
   * @param id pk
   * @return CommunityPostAudio obj
   */
  public CommunityPostAudio get(Long id) {
    return sqlSessionTemplate.selectOne(NAME_SPACE + "get", id);
  }

  /**
   * Get data by page
   * @return obj list
   */
  public List<CommunityPostAudio> getByPage(int skip, int size) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("skip", skip);
    map.put("size", size);
    return sqlSessionTemplate.selectList(NAME_SPACE + "getByPage", map);
  }

  /**
   *  Get data count
   * @return long
   */
  public long getTotal() {
    return sqlSessionTemplate.selectOne(NAME_SPACE + "getTotal");
  }
}
