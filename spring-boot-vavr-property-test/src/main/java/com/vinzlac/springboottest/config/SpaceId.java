package com.vinzlac.springboottest.config;

import io.vavr.control.Option;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.regex.Pattern;

import static io.vavr.API.Option;
import static io.vavr.control.Option.when;
import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.compile;

@Data
@Builder(toBuilder = true)
public class SpaceId {

  private static final String SEPARATOR = "-";
  private static final Pattern PATTERN = compile("(?:.*-)?(\\d+)-(\\d+)");

  Integer page;
  Integer id;

  @Override
  public String toString() {
    return page + SEPARATOR + id;
  }

  public static Option<SpaceId> from(final String maybeSpace) {

    return Option(maybeSpace)
            .map(PATTERN::matcher)
            .flatMap(
                matcher ->
                    when(
                        matcher.matches() && matcher.groupCount() == 2,
                        () ->
                            SpaceId.builder()
                                .page(parseInt(matcher.group(1)))
                                .id(parseInt(matcher.group(2)))
                                .build()));
  }
}
