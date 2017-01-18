package com.jingoal.web.ecircle.community.model;

import java.io.Serializable;

/**
 * Created by fudw.
 */
public class CommunityPostAudio implements Serializable {

  private static final long serialVersionUID = -5051983450804074074L;

  private Long id;
  private Long communityId;
  private String fileId;
  private String audioSize;
  private Integer audioSecond;
  private Integer audioMinute;
  private String audioTitle;
  private String auduoNote;

  public Long getId() {
    return this.id;
  }

  public Long getCommunityId() {
    return this.communityId;
  }

  public String getFileId() {
    return this.fileId;
  }

  public String getAudioSize() {
    return this.audioSize;
  }

  public Integer getAudioSecond() {
    return this.audioSecond;
  }

  public Integer getAudioMinute() {
    return this.audioMinute;
  }

  public String getAudioTitle() {
    return this.audioTitle;
  }

  public String getAuduoNote() {
    return this.auduoNote;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCommunityId(Long communityId) {
    this.communityId = communityId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  public void setAudioSize(String audioSize) {
    this.audioSize = audioSize;
  }

  public void setAudioSecond(Integer audioSecond) {
    this.audioSecond = audioSecond;
  }

  public void setAudioMinute(Integer audioMinute) {
    this.audioMinute = audioMinute;
  }

  public void setAudioTitle(String audioTitle) {
    this.audioTitle = audioTitle;
  }

  public void setAuduoNote(String auduoNote) {
    this.auduoNote = auduoNote;
  }
}
