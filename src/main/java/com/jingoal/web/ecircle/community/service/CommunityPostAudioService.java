package com.jingoal.web.ecircle.community.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jingoal.web.ecircle.community.model.CommunityPostAudio;
import com.jingoal.web.ecircle.community.dao.CommunityPostAudioDao;

import java.util.ArrayList;
import java.util.List;

/**
*  Created by fudw.
*/
@Component
public class CommunityPostAudioService {

  @Autowired
  private CommunityPostAudioDao communitypostaudioDao;

  /**
   * Add  CommunityPostAudio
   * @param communitypostaudio obj to update
   */
  public void add(CommunityPostAudio communitypostaudio) {
    this.communitypostaudioDao.add(communitypostaudio);
  }

  /**
   * Update CommunityPostAudio
   * @param communitypostaudio obj to update
   */
  public void update(CommunityPostAudio communitypostaudio) {
    this.communitypostaudioDao.update(communitypostaudio);
  }

  /**
   *  Update CommunityPostAudio
   * @param communitypostaudio obj to update
   */
  public void updatePropertys(CommunityPostAudio communitypostaudio) {
    this.communitypostaudioDao.updatePropertys(communitypostaudio);
  }

  /**
   * Delete by pk
   * @param id pk
   */
  public void del(Long id) {
    this.communitypostaudioDao.del(id);
  }

  /**
   *  Get by pk
   * @param id pk
   * @return CommunityPostAudio obj
   */
  public CommunityPostAudio get(Long id) {
    return this.communitypostaudioDao.get(id);
  }

  /**
   * Get data by page
   * @return obj list
   */
  public List<CommunityPostAudio> getByPage(int skip, int size) {
    return this.communitypostaudioDao.getByPage(skip, size);
}

  /**
   *  Get data count
   * @return long
   */
  public long getTotal() {
    return this.communitypostaudioDao.getTotal();
  }
}
