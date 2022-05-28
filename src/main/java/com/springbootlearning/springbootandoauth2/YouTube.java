package com.springbootlearning.springbootandoauth2;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

interface YouTube {

  @GetExchange("/search?part=snippet&type=video")
  SearchListResponse channelVideos( //
    @RequestParam String channelId, //
    @RequestParam int maxResults, //
    @RequestParam Sort sort);

  enum Sort {
    VIEW_COUNT("viewCount");

    private final String type;

    Sort(String type) {
      this.type = type;
    }
  }
}
