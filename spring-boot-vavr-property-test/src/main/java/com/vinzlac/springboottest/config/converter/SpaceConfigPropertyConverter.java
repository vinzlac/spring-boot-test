package com.vinzlac.springboottest.config.converter;

import com.vinzlac.springboottest.config.SpaceId;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class SpaceConfigPropertyConverter implements Converter<String, SpaceId> {

  @Override
  public SpaceId convert(final String from) {
    return SpaceId.from(from)
        .getOrElseThrow(
            () -> {
              throw new RuntimeException(
                  "Bad format for space [" + from + "] into t2s recommendation config");
            });
  }
}
