package com.springbootlearning.springbootandoauth2;

record SearchListResponse(String kind, String etag, String nextPageToken, String prevPageToken, PageInfo pageInfo,
  SearchResult[] items) {
}
