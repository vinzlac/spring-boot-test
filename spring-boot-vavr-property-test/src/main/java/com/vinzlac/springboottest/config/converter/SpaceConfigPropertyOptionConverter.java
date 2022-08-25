package com.vinzlac.springboottest.config.converter;

import com.vinzlac.springboottest.config.SpaceId;
import io.vavr.control.Option;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

//@Component
//@ConfigurationPropertiesBinding
// To AVOID:
// Failed to bind properties under 'infra.t2s.recommendations.same-brand.brands.chanel.id' to
// com.ggl.merch.t2s.model.SpaceId:
//
//    Property: infra.t2s.recommendations.same-brand.brands.chanel.id
//    Value: 1200-178
//    Origin: URL
// [file:/Users/vinzlac/clients/gl/worskpaces/ggl-config/config/api/ggl-merch/demo.yml] - 75:17
//    Reason: org.springframework.core.convert.ConverterNotFoundException: No converter found
// capable of converting from type [io.vavr.control.Option$Some<?>] to type
// [com.ggl.merch.t2s.model.SpaceId]
public class SpaceConfigPropertyOptionConverter implements Converter<Option<?>, SpaceId> {

  @Override
  public SpaceId convert(final Option<?> maybeSpace) {
    return maybeSpace
        .map(Objects::toString)
        .flatMap(SpaceId::from)
        .getOrElseThrow(
            () -> {
              throw new RuntimeException(
                  "Bad format for space [" + maybeSpace + "] into t2s recommendation config");
            });
  }
}
