package com.vinzlac.springboottest.config;

import io.vavr.control.Option;
import lombok.Builder;
import lombok.Data;

import static io.vavr.control.Option.none;

@Data
@Builder(toBuilder = true)
public class Space {
  SpaceId id;
  String title;

  @Builder.Default
  Option<String> type = none();
}
